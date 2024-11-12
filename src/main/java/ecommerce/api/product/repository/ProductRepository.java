package ecommerce.api.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecommerce.api.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
