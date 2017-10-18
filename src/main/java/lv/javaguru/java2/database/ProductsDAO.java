package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.products.Products;

import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 25.04.2017.
 */
public interface ProductsDAO {
    Products save(Products products);

    Optional<Products> getById(Long id);

    void delete(Long id);

    void update(Products products);

    List getAll();

}
