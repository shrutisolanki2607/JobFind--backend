package Zadice.JobPortal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse{
    private int id;
    private String token;
    private String email;
    private String role;
}