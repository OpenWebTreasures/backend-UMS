package com.example.UMS.security;

import com.example.UMS.features.user.dao.UserEntityDao;
import com.example.UMS.features.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
@Aspect
@RequiredArgsConstructor
public class AuthorizationAspect {

    private final UserEntityDao userEntityDao;

    @Before("@annotation(requiresFeature)")
    public void checkUserRole(RequiresFeature requiresFeature) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User user) {
            String feature = requiresFeature.value();
            if (userHasRoleForFeature(user.getUsername(), feature)) {
                return;
            }
        }
        throw new AuthorizationServiceException("not authorized ");
    }

    private boolean userHasRoleForFeature(String username, String feature) {
        UserEntity userEntity = userEntityDao.getUserByUserName(username);
        if (userEntity != null) {
            return userEntity.getRoles().stream()
                    .anyMatch(role -> role.getFeatures().stream()
                            .anyMatch(f -> f.getFeatureName().equals(feature)));
        }
        return false;
    }
}
