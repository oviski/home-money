package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.usersMoneyAccount.UsersMoneyAccount;

import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 25.04.2017.
 */
public interface UsersMoneyAccountDAO {
    UsersMoneyAccount save(UsersMoneyAccount usersMoneyAccount);

    Optional<UsersMoneyAccount> getById(Integer id);

    void delete(Integer id);

    void update(UsersMoneyAccount usersMoneyAccount);

    List<UsersMoneyAccount> getAll();

}
