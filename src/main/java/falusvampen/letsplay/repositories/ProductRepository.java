package falusvampen.letsplay.repositories;

import falusvampen.letsplay.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
