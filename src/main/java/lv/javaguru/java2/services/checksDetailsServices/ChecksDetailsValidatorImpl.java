package lv.javaguru.java2.services.checksDetailsServices;

import org.springframework.stereotype.Component;

@Component
public class ChecksDetailsValidatorImpl implements ChecksDetailsValidator {
    @Override
    public void validate(Long checkID, Integer checkPositionID, Integer categoryID, Integer subcategoryID, Long productID, Long sumOfProducts, String positionDetails) {
        validateChecksID(checkID);
        validateCheckPositionID(checkPositionID);
        validateCategoryID(categoryID);
        validateSubcategoryID(subcategoryID);
        validateProductID(productID);
        validateSumOfProducts(sumOfProducts);
        validatePositionDetails(positionDetails);

    }

    private void validateChecksID(Long checkID){}
    private void validateCheckPositionID(Integer checkPositionID){}
    private void validateCategoryID(Integer categoryID){}
    private void validateSubcategoryID(Integer subcategoryID){}
    private void validateProductID(Long productID){}
    private void validateSumOfProducts(Long sumOfProducts){}
    private void validatePositionDetails(String positionDetails){}
}
