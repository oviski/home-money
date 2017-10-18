package lv.javaguru.java2.services.subcategoryServices;

import lv.javaguru.java2.domain.subcategory.Subcategory;

import java.util.Optional;

public interface SubcategorySearch {
    Optional<Subcategory> searchByID(Integer subcategoryID);
}
