package ecommerce.api.product.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;




@Entity
public class Product {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long productid;

	    @NotEmpty(message = "Name should not be empty")
	    private String productname;

	    private String productdescription;

	    @Positive(message = "Price should be positive")
	    private BigDecimal productprice;

		public Long getId() {
			return productid;
		}

		public void setId(Long id) {
			this.productid = id;
		}

		public String getName() {
			return productname;
		}

		public void setName(String name) {
			this.productname = name;
		}

		public String getDescription() {
			return productdescription;
		}

		public void setDescription(String description) {
			this.productdescription = description;
		}

		public BigDecimal getPrice() {
			return productprice;
		}

		public void setPrice(BigDecimal price) {
			this.productprice = price;
		}
	    
	    

}
