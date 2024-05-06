package CaseStudy.CaseStudy.service;

import CaseStudy.CaseStudy.dto.ProductRequestDto;
import CaseStudy.CaseStudy.entity.Product;
import CaseStudy.CaseStudy.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class CartServiceImpl extends ICartService {

    private ProductRepository productRepository;
    @Override
    public Product getProduct(String id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }
    @Override
    public Product addProduct(ProductRequestDto productRequestDto) {
        System.out.println("product" + productRequestDto.getCategory());
        String ProductRepository = null;
        Product product = new Product(null);
        if(productRequestDto.getCategory() !=null) product.setCategory(productRequestDto.getCategory());
        if(productRequestDto.getName() !=null) product.setName(productRequestDto.getName());
        if(productRequestDto.getStatus() !=null) product.setStatus(productRequestDto.getStatus());
        if(productRequestDto.getQuantity() !=null) product.setQuantity(productRequestDto.getQuantity());
        if(productRequestDto.getPrice() !=null) product.setPrice(BigDecimal.valueOf(productRequestDto.getPrice()));
        product.setCreatedAt(new Date());
        Product p = productRepository.save(product);
        return product;
    }
    @Override
    public List<Product> listProducts() {
        List<Product> products = new ArrayList<>();
        Iterable<Product> optionalProduct = productRepository.findAll();
        optionalProduct.forEach(products::add);;
        return products;
    }
    @Override
    public Product updateProduct(ProductRequestDto productRequestDto) {
        Optional<Product> optionalProduct = productRepository.findById(productRequestDto.getId());
        Product product = optionalProduct.orElse(null);
        if(product == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "no entity found for this id");
        if(productRequestDto.getQuantity() !=null) product.setQuantity(productRequestDto.getQuantity());
        Product p = productRepository.save(product);
        return p;
    }
    @Override
    public Void deleteProduct(String id) {
        productRepository.deleteById(id);
        return null;
    };
}
