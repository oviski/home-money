package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.check.Check;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 25.04.2017.
 */
public interface CheckDAO {
    Check save(Check check);

    Optional<Check> getById(Long id);

    Optional<Check> getByDate(Date date);

    void delete(Long id);

    void update(Check check);

    List<Check> getAll();

}
