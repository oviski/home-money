package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.checksDetails.ChecksDetails;

import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 25.04.2017.
 */
public interface ChecksDetailsDAO {
    ChecksDetails save(ChecksDetails checksDetails);

    Optional<ChecksDetails> getById(Long id);

    void delete(Long id);

    void update(ChecksDetails user);

    List<ChecksDetails> getAll();

}
