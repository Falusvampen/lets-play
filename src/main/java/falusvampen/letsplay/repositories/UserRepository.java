package falusvampen.letsplay.repositories;

import falusvampen.letsplay.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByName(String username);
}
