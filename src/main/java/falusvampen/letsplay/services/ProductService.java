// package falusvampen.letsplay.services;

// import falusvampen.letsplay.models.Product;
// import falusvampen.letsplay.repositories.ProductRepository;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// public class ProductService {

// private final ProductRepository productRepository;

// public ProductService(ProductRepository productRepository) {
// this.productRepository = productRepository;
// }

// // Create Product
// public Product createProduct(Product product) {
// return productRepository.save(product);
// }

// // Read All Products
// public List<Product> getAllProducts() {
// return productRepository.findAll();
// }

// // Read Product by Id
// public Product getProductById(String id) {
// return productRepository.findById(id).orElse(null);
// }

// // Update Product
// public Product updateProduct(String id, Product updatedProduct) {
// Optional<Product> optionalProduct = productRepository.findById(id);
// if (optionalProduct.isPresent()) {
// Product existingProduct = optionalProduct.get();
// existingProduct.setName(updatedProduct.getName());
// existingProduct.setPrice(updatedProduct.getPrice());
// return productRepository.save(existingProduct);
// }
// return null;
// }

// // Delete Product
// public boolean deleteProduct(String id) {
// if (productRepository.existsById(id)) {
// productRepository.deleteById(id);
// return true;
// }
// return false;
// }
// }
