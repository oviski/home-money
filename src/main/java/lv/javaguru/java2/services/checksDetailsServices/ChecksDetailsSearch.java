package lv.javaguru.java2.services.checksDetailsServices;

import lv.javaguru.java2.domain.checksDetails.ChecksDetails;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 13.07.2017.
 */
public interface ChecksDetailsSearch {
    Optional<ChecksDetails> searchByID (Long checksDetailsID);
    List<ChecksDetails> searchByCheckID(Long checkID);
    List<ChecksDetails> searchByDateOfPourches(Date DateOfPourches);
    List<ChecksDetails> searchByCategoryID(Integer categoryID);
    List<ChecksDetails> searchBySubcategoryID(Integer subcategoryID);
}
