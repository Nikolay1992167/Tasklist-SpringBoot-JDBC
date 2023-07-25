package by.it.tasklist.service.impl;

import by.it.tasklist.service.AuthService;
import by.it.tasklist.web.dto.auth.JwtRequest;
import by.it.tasklist.web.dto.auth.JwtResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public JwtResponse login(JwtRequest loginRequest) {
        return null;
    }

    @Override
    public JwtResponse refresh(String refreshToken) {
        return null;
    }
}
