package falusvampen.letsplay.services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import falusvampen.letsplay.models.User;
import falusvampen.letsplay.models.Product;
import falusvampen.letsplay.repositories.UserRepository;
import falusvampen.letsplay.repositories.ProductRepository;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    public DatabaseSeeder(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;

    }

    @Override
    public void run(String... args) throws Exception {
        // Check if the database is empty (or any other condition that triggers seeding)
        if (userRepository.count() == 0) {
            // If the User collection is empty, seed some initial data
            seedUsers();
        }

        if (productRepository.count() == 0) {
            // If the Product collection is empty, seed some initial data
            seedProducts();
        }

    }

    private void seedUsers() {
        // You can create and save User objects here
        User user1 = new User();
        user1.setId("1");
        user1.setName("John Doe");
        user1.setEmail("johndoe@example.com");
        user1.setPassword("secretpassword");
        user1.setRole("ROLE_USER");

        User user2 = new User();
        user2.setId("2");
        user2.setName("Alice Smith");
        user2.setEmail("alice@example.com");
        user2.setPassword("password123");
        user2.setRole("ROLE_ADMIN");

        // Save the User objects to the database
        userRepository.save(user1);
        userRepository.save(user2);

        System.out.println("Initial users seeded.");
    }

    private void seedProducts() {

        Product product1 = new Product();
        product1.setProductid("1");
        product1.setName("Product 1");
        product1.setPrice(100.0);
        product1.setDescription("This is product 1");
        product1.setUserid("1");

        Product product2 = new Product();
        product2.setProductid("2");
        product2.setName("Product 2");
        product2.setPrice(200.0);
        product2.setDescription("This is product 2");
        product2.setUserid("2");

        productRepository.save(product1);
        productRepository.save(product2);

        System.out.println("Initial products seeded.");

    }

}
