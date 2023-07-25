package by.it.tasklist.service;

import by.it.tasklist.web.dto.auth.JwtRequest;
import by.it.tasklist.web.dto.auth.JwtResponse;

public interface AuthService {

    JwtResponse login(JwtRequest loginRequest);
    JwtResponse refresh(String refreshToken);
}
