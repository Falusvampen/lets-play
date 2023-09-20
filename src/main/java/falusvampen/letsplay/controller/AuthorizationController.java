package falusvampen.letsplay.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Optional;

import falusvampen.letsplay.models.AuthRequest;
import falusvampen.letsplay.models.User;
import falusvampen.letsplay.repositories.UserRepository;
import falusvampen.letsplay.services.JwtService;
import falusvampen.letsplay.utils.FieldValidator;

public class AuthorizationController {
    @PostMapping("/users/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) throws NoSuchAlgorithmException {
        Optional<User> userOptional = userRepository.findByUser(authRequest.getUsername());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            String storedPassword = user.getPassword(); // This should contain the stored salted and hashed password
            System.out.println("storedPassword: " + storedPassword);

            String hashedAuthPassword = FieldValidator.hashPassword(authRequest.getPassword());
            System.out.println("authPassword: " + authRequest.getPassword());
            System.out.println("hashedAuthPassword " + hashedAuthPassword);

            // take from storedSaltedPassword from $2a$10$ onwards

            String passwordToCheck = storedPassword.replaceFirst("^\\$2a\\$10\\$", "");
            System.out.println("passwordToCheck : " + passwordToCheck);

            // Compare the stored salted and hashed password with the newly generated hash
            if (passwordToCheck.equals(storedPassword)) {
                return jwtService.generateToken(authRequest.getUsername());
            } else {
                throw new BadCredentialsException("Invalid password");
            }
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
