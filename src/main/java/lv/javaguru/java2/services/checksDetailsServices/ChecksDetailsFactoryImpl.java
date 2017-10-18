package lv.javaguru.java2.services.checksDetailsServices;

import lv.javaguru.java2.database.ChecksDetailsDAO;
import lv.javaguru.java2.domain.checksDetails.ChecksDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.java2.domain.checksDetails.ChecksDetailsBuilder.createChecksDetail;

@Component
public class ChecksDetailsFactoryImpl implements ChecksDetailsFactory {
    @Autowired
    ChecksDetailsValidator checksDetailsValidator;
    @Autowired
    ChecksDetailsDAO checksDetailsDAO;
    @Override
    public ChecksDetails create(Long checksID, Integer checkPositionID, Integer categoryID, Integer subcategoryID, Long productID, Long sumOfProducts, String positionDetails) {
        checksDetailsValidator.validate(checksID, checkPositionID, categoryID, subcategoryID, productID,sumOfProducts, positionDetails);

        ChecksDetails checksDetails = createChecksDetail()
                .withCheckID(checksID)
                .withCheckPositionID(checkPositionID)
                .withCategoryID(categoryID)
                .withSubcategoryID(subcategoryID)
                .withProductsID(productID)
                .withSumOfProducts(sumOfProducts)
                .withPositionDetails(positionDetails).build();

        return checksDetailsDAO.save(checksDetails);
    }
}
