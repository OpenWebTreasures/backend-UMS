package com.example.UMS.features.auth;

import com.example.UMS.features.auth.payload.RegisterRequest;
import com.example.UMS.features.auth.payload.AuthenticationRequest;
import com.example.UMS.features.auth.payload.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
