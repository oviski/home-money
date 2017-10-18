package lv.javaguru.java2.services.productsServices;

import lv.javaguru.java2.domain.products.Products;
import org.springframework.stereotype.Component;

@Component
public class ProductsFactoryImpl implements ProductsFactory {
    @Override
    public Products create(Integer categoryID, Integer subcategoryID, String productsName) {
        return null;
    }
}
