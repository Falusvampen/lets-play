package falusvampen.letsplay.repositories;

import falusvampen.letsplay.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
