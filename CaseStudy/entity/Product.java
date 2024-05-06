package CaseStudy.CaseStudy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document(value = "product")
@Data
@Builder
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;

    public Product(String productRepository) {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ",  name='" + name + '\'' +
                ",  description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public Product(String id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void addProduct(Product product) {
        product.addProduct(product);
    }
    public void createProduct(Product product) {
        product.createProduct(product);
    }
    public void updateProduct(Product product) {
        product.updateProduct(product);
    }
    public void deleteProduct(Product product) {
        product.deleteProduct(product);
    }

    public void setCreatedAt(Date date) {
    }

    public void setQuantity(Integer quantity) {
    }

    public void setCategory(String category) {
    }

    public void setStatus(String status) {
    }
}

