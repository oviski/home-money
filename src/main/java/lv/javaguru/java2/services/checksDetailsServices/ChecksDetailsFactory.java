package lv.javaguru.java2.services.checksDetailsServices;

import lv.javaguru.java2.domain.checksDetails.ChecksDetails;

/**
 * Created by admin on 13.07.2017.
 */
public interface ChecksDetailsFactory {
    ChecksDetails create(Long checksID, Integer checkPositionID, Integer categoryID, Integer subcategoryID,
                         Long productID, Long sumOfProducts, String positionDetails);
}
