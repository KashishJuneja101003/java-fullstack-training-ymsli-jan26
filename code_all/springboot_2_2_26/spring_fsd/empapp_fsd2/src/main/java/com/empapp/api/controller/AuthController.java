package com.empapp.api.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empapp.api.config.JwtUtil;
import com.empapp.api.request.LoginRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest req) {

        if ("raj".equals(req.username())
                && "raj".equals(req.password())) {

            String token = jwtUtil.generateToken(req.username());
            return Map.of("token", token);
        }

        throw new RuntimeException("Invalid credentials");
    }
}
