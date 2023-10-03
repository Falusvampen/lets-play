package falusvampen.letsplay.service;

import falusvampen.letsplay.models.User;
import falusvampen.letsplay.models.UserDTO;
import falusvampen.letsplay.repositories.UserRepository;
import falusvampen.letsplay.repositories.ProductRepository;
import falusvampen.letsplay.exceptions.UserCollectionException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.validation.ConstraintViolationException;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
            ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.productRepository = productRepository;
    }

    // Conversion Method
    public UserDTO convertToUserDTO(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getRole());
    }

    // Create User
    public void createUser(User user)
            throws ConstraintViolationException, UserCollectionException {
        Optional<User> userOptional = userRepository.findByEmail(user.getEmail().trim());
        if (userOptional.isPresent()) {
            throw new UserCollectionException(UserCollectionException.UserAlreadyExistException());
        }
        // make sure username is unique
        Optional<User> userOptional1 = userRepository.findByName(user.getName().trim());
        if (userOptional1.isPresent()) {
            throw new UserCollectionException(UserCollectionException.UserNameAlreadyTaken());
        }

        // set id to new uuid
        while (true) {
            user.setId(User.uuidGenerator());
            Optional<User> userOptional2 = userRepository.findById(user.getId().trim());
            if (userOptional2.isEmpty()) {
                break;
            }
        }
        user.setName(user.getName().trim());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    // Read All Users
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::convertToUserDTO).collect(Collectors.toList());
    }

    public UserDTO getUserById(String id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.map(this::convertToUserDTO).orElse(null);
    }

    // Update User
    public void updateUser(String id, User updatedUser)
            throws ConstraintViolationException, UserCollectionException {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new UserCollectionException(UserCollectionException.NotFoundException(id));
        }
        updatedUser.setId(id.trim());
        updatedUser.setName(updatedUser.getName().trim());
        updatedUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        updatedUser.setRole(updatedUser.getRole().trim());
        updatedUser.setEmail(updatedUser.getEmail().trim());

        userRepository.save(updatedUser);
    }

    // Delete User
    public void deleteUser(String id) throws UserCollectionException {
        Optional<User> userOptional = userRepository.findById(id);
        System.out.println("userOptional: " + userOptional);

        if (userOptional.isEmpty()) {
            throw new UserCollectionException(UserCollectionException.NotFoundException(id));
        } else {
            productRepository.deleteAllByUserId(id);
            userRepository.deleteById(id);
        }
    }
}
