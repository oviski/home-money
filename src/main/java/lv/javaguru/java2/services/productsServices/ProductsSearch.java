package lv.javaguru.java2.services.productsServices;

import lv.javaguru.java2.domain.products.Products;

import java.util.Optional;

public interface ProductsSearch {
    Optional<Products> searchByID(Long productID);
}
