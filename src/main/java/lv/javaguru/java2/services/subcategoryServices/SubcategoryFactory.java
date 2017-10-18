package lv.javaguru.java2.services.subcategoryServices;

import lv.javaguru.java2.domain.subcategory.Subcategory;

public interface SubcategoryFactory {
    Subcategory create(Integer categoryID, String subcategoryName);
}
