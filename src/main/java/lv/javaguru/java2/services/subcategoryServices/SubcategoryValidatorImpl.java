package lv.javaguru.java2.services.subcategoryServices;

import org.springframework.stereotype.Component;

@Component
public class SubcategoryValidatorImpl implements SubcategoryValidator {
    @Override
    public void validate( Integer categoryID, String subcategoryName) {

        validateCategoryID(categoryID);
        validateSubcategoryName(subcategoryName);

    }

    private void validateSubcategoryName(String subcategoryName) {
    }

    private void validateCategoryID(Integer categoryID) {
    }

}
