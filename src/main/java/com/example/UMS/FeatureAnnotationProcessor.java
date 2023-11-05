package com.example.UMS;

import com.example.UMS.security.RequiresFeature;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

@Component
public class FeatureAnnotationProcessor {

//    @PostConstruct
//    public void processAnnotations() {
//        // Scan the classpath for RestControllers with methods containing RequiresFeature annotations
//        Set<Class<?>> restControllerClasses = findClassesWithRestControllerAnnotation("com.example.UMS");
//
//        for (Class<?> clazz : restControllerClasses) {
//            Method[] methods = clazz.getDeclaredMethods();
//            for (Method method : methods) {
//                RequiresFeature requiresFeature = method.getAnnotation(RequiresFeature.class);
//                if (requiresFeature != null) {
//                    String featureName = requiresFeature.value();
//                    // Perform your logic based on the featureName
//                    System.out.println("Found method with RequiresFeature in class: " + clazz.getName() +
//                            ", Method: " + method.getName() + ", Feature: " + featureName);
//                }
//            }
//        }
//    }
//
//    private Set<Class<?>> findClassesWithRestControllerAnnotation(String basePackage) {
//        Set<Class<?>> result = new HashSet<>();
//
//        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
//        TypeFilter filter = new AnnotationTypeFilter(RestController.class);
//        scanner.addIncludeFilter(filter);
//
//        for (BeanDefinition beanDefinition : scanner.findCandidateComponents(basePackage)) {
//            try {
//                result.add(Class.forName(beanDefinition.getBeanClassName()));
//            } catch (ClassNotFoundException e) {
//                // Handle the exception as needed
//            }
//        }
//
//        return result;
//    }
}
