package falusvampen.letsplay.models;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data // Generates getters and setters
@Document(collection = "products")
public class Product {
    @Id
    private String id = uuidGenerator(); // Initialize ID upon object creation

    @NotBlank(message = "Product name cannot be empty")
    private String name;

    @NotBlank(message = "Product description cannot be empty")
    private String description;

    @NotNull(message = "Product price cannot be null")
    @DecimalMin(value = "0.0", message = "Product price must be greater than or equal to 0")
    private Double price;

    @NotBlank(message = "Product userId cannot be empty")
    private String userId;

    // Manually define the setter for userId
    public void setUserId(String userId) {
        // Trim the userId before setting it
        this.userId = userId != null ? userId.trim() : null;
    }

    public static String uuidGenerator() {
        return UUID.randomUUID().toString();
    }
}
