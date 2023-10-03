package falusvampen.letsplay.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import falusvampen.letsplay.models.User;
import falusvampen.letsplay.models.Product;
import falusvampen.letsplay.repositories.UserRepository;
import falusvampen.letsplay.repositories.ProductRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    private final PasswordEncoder passwordEncoder;

    public DatabaseSeeder(UserRepository userRepository, ProductRepository productRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            seedUsers();
        }

        if (productRepository.count() == 0) {
            seedProducts();
        }

    }

    private void seedUsers() {
        var user1 = User.builder()
                .id("1")
                .name("user")
                .email("user@example.com")
                .password(passwordEncoder.encode("password"))
                .role("ROLE_USER")
                .build();

        var user2 = User.builder()
                .id("2")
                .name("admin")
                .email("admin@example.com")
                .password(passwordEncoder.encode("password"))
                .role("ROLE_ADMIN")
                .build();

        userRepository.save(user1);
        userRepository.save(user2);

        System.out.println("Initial users seeded.");
    }

    private void seedProducts() {

        var product1 = Product.builder()
                .id("1")
                .name("Product 1")
                .price(100.0)
                .description("This is product 1")
                .userId("1")
                .build();

        var product2 = Product.builder()
                .id("2")
                .name("Product 2")
                .price(200.0)
                .description("This is product 2")
                .userId("2")
                .build();

        productRepository.save(product1);
        productRepository.save(product2);

        System.out.println("Initial products seeded.");

    }

}
