package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.checksDetail.ChecksDetail;

import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 25.04.2017.
 */
public interface ChecksDetailDAO {
    ChecksDetail save(ChecksDetail checksDetail);

    Optional<ChecksDetail> getById(Long id);

    void delete(Long id);

    void update(ChecksDetail user);

    List<ChecksDetail> getAll();

}
