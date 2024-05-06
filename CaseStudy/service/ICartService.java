package CaseStudy.CaseStudy.service;

import CaseStudy.CaseStudy.dto.ProductRequestDto;
import CaseStudy.CaseStudy.entity.Product;

import java.util.List;

public abstract class ICartService {
    Product getProduct(String id) {
        return null;
    }

    public abstract Product addProduct(ProductRequestDto productRequestDto);

    List<Product> listProducts() {
        return null;
    }

    Product updateProduct(ProductRequestDto productRequestDto) {
        return null;
    }

    Void deleteProduct(String id) {
        return null;
    }
}
