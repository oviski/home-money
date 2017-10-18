package lv.javaguru.java2.services.categoryServices;

import lv.javaguru.java2.domain.category.Category;

/**
 * Created by admin on 10.07.2017.
 */
public interface CategoryFactory {
    Category create(String categoryName, Boolean subcategoryAllow);
}
