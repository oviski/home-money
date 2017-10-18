package lv.javaguru.java2.services.categoryServices;

import lv.javaguru.java2.domain.category.Category;

import java.util.Optional;

/**
 * Created by admin on 10.07.2017.
 */
public interface CategorySearch{
    Optional<Category> searchByID(Integer categoryID);
}
