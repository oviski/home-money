package lv.javaguru.java2.services.usersMoneyAccountServices;

import lv.javaguru.java2.domain.usersMoneyAccount.UsersMoneyAccount;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 03.06.2017.
 */

public interface UsersMoneyAccountSearch {
    Optional<List<UsersMoneyAccount>> getAllUsersMoneyAccounts();
    Optional<List<UsersMoneyAccount>> getByUsersID(Integer userID);
    Optional<UsersMoneyAccount> getByUsersMoneyAccountID(Integer usersMoneyAccountID);
}
