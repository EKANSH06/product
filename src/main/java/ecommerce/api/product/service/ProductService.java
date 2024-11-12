package ecommerce.api.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.api.product.entity.Product;
import ecommerce.api.product.exception.ProductException;
import ecommerce.api.product.exception.ProductNotFoundException;
import ecommerce.api.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        //if(productRepository.findById(id).isEmpty()) {
    	return productRepository.findById(id).orElseThrow(() -> new ProductException("Product not found"));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        if (!productRepository.existsById(id)) {
           throw new ProductNotFoundException("Product not found with id " + id);
        }
        Product existingProduct = getProductById(id);
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found with id " + id);
        }
        productRepository.deleteById(id);
    }
}
