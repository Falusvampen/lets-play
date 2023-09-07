package falusvampen.letsplay.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private String userid;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
