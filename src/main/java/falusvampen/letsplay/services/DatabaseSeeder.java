package falusvampen.letsplay.services;

// import falusvampen.letsplay.models.User;
// import falusvampen.letsplay.repositories.UserRepository;
// import falusvampen.letsplay.repositories.ProductRepository;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// @Component
// public class DatabaseSeeder implements CommandLineRunner {

// private final UserRepository userRepository;
// private final ProductRepository productRepository;

// public DatabaseSeeder(UserRepository userRepository, ProductRepository
// productRepository) {
// this.userRepository = userRepository;
// this.productRepository = productRepository;
// }

// @Override
// public void run(String... args) {
// System.out.println("Fetching all users from database...");
// userRepository.findAll().forEach(user -> System.out.println(user.getName()));
// System.out.println("Fetching all products from database...");
// productRepository.findAll().forEach(product ->
// System.out.println(product.getName()));

// }
// }

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import falusvampen.letsplay.models.User;
import falusvampen.letsplay.repositories.UserRepository;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final UserRepository userRepository;

    public DatabaseSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Check if the database is empty (or any other condition that triggers seeding)
        if (userRepository.count() == 0) {
            // If the User collection is empty, seed some initial data
            seedUsers();
        }
    }

    private void seedUsers() {
        // You can create and save User objects here
        User user1 = new User();
        user1.setName("John Doe");
        user1.setEmail("johndoe@example.com");
        user1.setPassword("secretpassword");
        user1.setRole("user");

        User user2 = new User();
        user2.setName("Alice Smith");
        user2.setEmail("alice@example.com");
        user2.setPassword("password123");
        user2.setRole("user");

        // Save the User objects to the database
        userRepository.save(user1);
        userRepository.save(user2);

        System.out.println("Initial users seeded.");
    }
}
