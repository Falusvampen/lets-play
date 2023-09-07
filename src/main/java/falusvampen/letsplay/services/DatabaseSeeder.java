package falusvampen.letsplay.services;

import falusvampen.letsplay.models.User;
import falusvampen.letsplay.repositories.UserRepository;
import falusvampen.letsplay.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public DatabaseSeeder(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("Fetching all users from database...");
        userRepository.findAll().forEach(user -> System.out.println(user.getName()));
        System.out.println("Fetching all products from database...");
        productRepository.findAll().forEach(product -> System.out.println(product.getName()));

    }
}
