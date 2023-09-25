package falusvampen.letsplay.controller;

import falusvampen.letsplay.models.Product;
import falusvampen.letsplay.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Utility to validate input against MongoDB injection attacks
    private boolean isValidInput(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        // Check for MongoDB special characters
        if (input.contains("$") || input.contains("{") || input.contains("}")) {
            return false;
        }

        return true;
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        try {
            if (product == null || !isValidInput(product.getName())) { // Added validation
                return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
            }
            Product createdProduct = productService.createProduct(product);
            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        try {
            Iterable<Product> products = productService.getAllProducts();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable String id) {
        try {
            if (!isValidInput(id)) { // Added validation
                return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
            }
            Product product = productService.getProductById(id);
            if (product != null) {
                return new ResponseEntity<>(product, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
        try {
            if (updatedProduct == null || !isValidInput(id) || !isValidInput(updatedProduct.getName())) { // Added
                                                                                                          // validation
                return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
            }
            Product product = productService.updateProduct(id, updatedProduct);
            if (product != null) {
                return new ResponseEntity<>(product, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteProduct(@PathVariable String id) {
        try {
            if (!isValidInput(id)) { // Added validation
                return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
            }
            boolean deleted = productService.deleteProduct(id);
            if (deleted) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.BAD_REQUEST);
        }
    }
}
