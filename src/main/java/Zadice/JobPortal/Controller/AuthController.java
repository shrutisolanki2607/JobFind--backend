package Zadice.JobPortal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Zadice.JobPortal.Services.AuthService;
import Zadice.JobPortal.dto.AuthResponse;
import Zadice.JobPortal.dto.LoginRequest;
import Zadice.JobPortal.dto.RegisterRequest;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private AuthService authservice;

   @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest registerRequest){
        return authservice.register(registerRequest);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest loginRequest){
        return authservice.login(loginRequest);
    }
}