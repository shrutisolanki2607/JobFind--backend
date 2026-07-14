package Zadice.JobPortal.Services;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Zadice.JobPortal.dto.AuthResponse;
import Zadice.JobPortal.dto.LoginRequest;
import Zadice.JobPortal.dto.RegisterRequest;
import Zadice.JobPortal.models.User;
import Zadice.JobPortal.repository.UserRepository;

@Service
public class AuthService {
  
    @Autowired private UserRepository userRepository;
    @Autowired private JwtService jwtService;
    @Autowired private PasswordEncoder passwordEncoder;

    public AuthResponse register(RegisterRequest request ){
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        User.Role role = (request.getRole() != null)
        ? User.Role.valueOf(request.getRole().toUpperCase())
        : User.Role.USER;
        user.setRole(role);
        User saved = userRepository.save(user);
        String token = jwtService.generateToken(saved.getEmail());
        return new AuthResponse(saved.getId(), token, saved.getEmail(), saved.getRole().name());
    }


    public AuthResponse login(LoginRequest request){
         User user = userRepository.findByEmail(request.getEmail());
         if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
              throw new RuntimeException("Invalid password");
         }

         String token = jwtService.generateToken(user.getEmail());
         return new AuthResponse(user.getId(), token, user.getEmail(), user.getRole().name());
    }

}
