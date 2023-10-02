package falusvampen.letsplay.models;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data  // Generates getters and setters
@NoArgsConstructor  // Generates no-arg constructor
@Document(collection = "users")
public class User {
    @Id
    private String id = uuidGenerator();  // Initialize ID upon object creation

    @NotBlank(message = "User name cannot be empty")
    private String name;

    @NotBlank(message = "User email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "User password cannot be empty")
    private String password;

    @NotNull(message = "User role cannot be null")
    private String role;

    private static String uuidGenerator() {
        return UUID.randomUUID().toString();
    }
}
