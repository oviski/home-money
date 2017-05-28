package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.checks.Checks;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 25.04.2017.
 */
public interface ChecksDAO {
    Checks save(Checks checks) throws SQLException;

    Optional<Checks> getById(Long id);

    void delete(Long id);

    void update(Checks checks);

    List<Checks> getAll();

}
