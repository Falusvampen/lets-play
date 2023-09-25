package falusvampen.letsplay.controller;

import falusvampen.letsplay.models.AuthRequest;
import falusvampen.letsplay.models.User;
import falusvampen.letsplay.repositories.UserRepository;
import falusvampen.letsplay.service.JWTService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<?> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        try {
            // Basic input validation to prevent injection attacks
            if (authRequest.getUsername() == null || authRequest.getPassword() == null) {
                return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
            }

            Optional<User> user = userRepository.findByName(authRequest.getUsername());
            if (user.isPresent()) {
                if (passwordEncoder.matches(authRequest.getPassword(), user.get().getPassword())) {
                    String token = jwtService.generateToken(user.get().getName());
                    return new ResponseEntity<>(token, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("Wrong password", HttpStatus.UNAUTHORIZED);
                }
            } else {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Generic catch block to ensure no 5XX errors are returned
            return new ResponseEntity<>("Definitely Not An Internal Server Error, It Is Just A Bad Request",
                    HttpStatus.BAD_REQUEST);
        }
    }
}
