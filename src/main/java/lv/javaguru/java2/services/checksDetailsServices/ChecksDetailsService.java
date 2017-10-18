package lv.javaguru.java2.services.checksDetailsServices;

/**
 * Created by admin on 13.07.2017.
 */
public interface ChecksDetailsService {
    void edit(Long checkID, Integer checkPositionID, Integer categoryID, Integer subcategoryID,
              Long productID, Long sumOfProducts, String positionDetails);
}
