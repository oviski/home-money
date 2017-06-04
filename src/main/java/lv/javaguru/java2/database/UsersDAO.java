package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.users.Users;

import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 25.04.2017.
 */
public interface UsersDAO {
    Users save(Users users);

    Optional<Users> getById(Integer id);

    void delete(Integer id);

    void update(Users users);

    List<Users> getAll();
}
