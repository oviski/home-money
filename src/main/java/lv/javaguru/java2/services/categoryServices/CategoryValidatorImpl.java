package lv.javaguru.java2.services.categoryServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 12.07.2017.
 */
@Component
public class CategoryValidatorImpl implements CategoryValidator {

    @Override
    public void validate(String categoryName, Boolean subcategoryAllow) {
        validateCategoryName(categoryName);
        validateSubcategoryAllow(subcategoryAllow);
    }

    private void validateCategoryName(String categoryName){
        return;
    }

    private void validateSubcategoryAllow(Boolean subcategoryAllow){
        return;
    }
}
