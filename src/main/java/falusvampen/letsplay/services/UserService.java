package falusvampen.letsplay.services;

import falusvampen.letsplay.models.User;
import falusvampen.letsplay.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        // You can add any validation logic here before saving the user to the database
        // For example, check if the email is unique or validate the password.

        // Save the user to the database using the userRepository
        return userRepository.save(user);
    }
}
