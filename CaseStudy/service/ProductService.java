package CaseStudy.CaseStudy.service;

import CaseStudy.CaseStudy.dto.ProductRequest;
import CaseStudy.CaseStudy.dto.ProductResponse;
import CaseStudy.CaseStudy.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import CaseStudy.CaseStudy.repository.ProductRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/products")

public class ProductService {

//    private final ProductRepository productRepository;
//
//    public List<ProductResponse> getProduct() {
//    List<Product> products = productRepository.findAll();
//
//        return products.stream().map(this::mapToProductResponse).toList();
//    }
//
//    public void createProduct(ProductRequest productRequest) {
//        Product product = Product.builder()
//                .name(productRequest.getName())
//                .description(productRequest.getDescription())
//                .price(productRequest.getPrice())
//                .build();
//
//        productRepository.save(product);
//        log.info("Ürün  {} is Kayıt edildi...", product.getId());
//    }
//
//    public void updateProduct(ProductRequest productRequest) {
//        Product product = Product.builder()
//                .name(productRequest.getName())
//                .description(productRequest.getDescription())
//                .price(productRequest.getPrice())
//                .build();
//
//        productRepository.save(product);
//        log.info("Product {} is updated", product.getId());
//    }
//    public void deleteProduct(ProductRequest productRequest) {
//        Product product = Product.builder()
//                .name(productRequest.getName())
//                .description(productRequest.getDescription())
//                .price(productRequest.getPrice())
//                .build();
//
//        productRepository.delete(product);
//        log.info("Ürün {} silindi...", product.getId());
//    }


    private ProductRepository productRepository;

    public List<Product> searchProducts(String name, List<String> categories, List<String> attributes) {

        return null;
    }

//    @GetMapping
//    public Page<Product> getAllProducts(Product product) {
//        return productRepository.findAll(product);
//    }

    public Product updateProduct(String id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}


