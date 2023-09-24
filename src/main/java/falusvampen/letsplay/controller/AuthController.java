package falusvampen.letsplay.controller;

import falusvampen.letsplay.models.AuthRequest;
import falusvampen.letsplay.models.User;
import falusvampen.letsplay.repositories.UserRepository;
import falusvampen.letsplay.service.JWTsService;
import falusvampen.letsplay.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JWTsService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {

        Optional<User> user = userRepository.findByName(authRequest.getUsername());
        if (user.isPresent()) {
            if (passwordEncoder.matches(authRequest.getPassword(), user.get().getPassword())) {
                return jwtService.generateToken(user.get().getName());
            }
        } else {
            return "User not found";
        }
        return "Wrong password";
    }

}
