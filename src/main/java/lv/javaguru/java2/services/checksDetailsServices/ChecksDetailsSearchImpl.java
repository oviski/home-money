package lv.javaguru.java2.services.checksDetailsServices;

import lv.javaguru.java2.domain.checksDetails.ChecksDetails;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ChecksDetailsSearchImpl implements ChecksDetailsSearch {
    @Override
    public Optional<ChecksDetails> searchByID(Long checksDetailsID) {
        return null;
    }

    @Override
    public List<ChecksDetails> searchByCheckID(Long checkID) {
        return null;
    }

    @Override
    public List<ChecksDetails> searchByDateOfPourches(Date DateOfPourches) {
        return null;
    }

    @Override
    public List<ChecksDetails> searchByCategoryID(Integer categoryID) {
        return null;
    }

    @Override
    public List<ChecksDetails> searchBySubcategoryID(Integer subcategoryID) {
        return null;
    }
}
