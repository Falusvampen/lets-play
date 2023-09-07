package falusvampen.letsplay.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String role;

    // Getters and Setters
    // ...

    public String getName() {
        return name;
    }

}
