package lv.javaguru.java2.services.usersMoneyAccountServices;

import lv.javaguru.java2.database.UsersMoneyAccountDAO;
import lv.javaguru.java2.database.jdbc.UsersMoneyAccountDAOImpl;
import lv.javaguru.java2.domain.usersMoneyAccount.UsersMoneyAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 03.06.2017.
 */
@Component
public class UsersMoneyAccountSearchImpl implements UsersMoneyAccountSearch {
    @Autowired
    UsersMoneyAccountDAO usersMoneyAccountDAO;
    @Override
    public Optional<List<UsersMoneyAccount>> getAllUsersMoneyAccounts() {
        //UsersMoneyAccountDAO usersMoneyAccountDAO = new UsersMoneyAccountDAOImpl();
        List<UsersMoneyAccount> allUsersMoneyAccountsInDB = usersMoneyAccountDAO.getAll();
        return Optional.of(allUsersMoneyAccountsInDB);
    }

    @Override
    public Optional<List<UsersMoneyAccount>> getByUsersID(Integer userID) {
        //UsersMoneyAccountDAO usersMoneyAccountDAO = new UsersMoneyAccountDAOImpl();
        return usersMoneyAccountDAO.getByUsersID(userID);
    }

    @Override
    public Optional<UsersMoneyAccount> getByUsersMoneyAccountID(Integer usersMoneyAccountID) {
        //UsersMoneyAccountDAO usersMoneyAccountDAO = new UsersMoneyAccountDAOImpl();
        Optional<UsersMoneyAccount> usersMoneyAccountOptional = usersMoneyAccountDAO.getById(usersMoneyAccountID);
        return usersMoneyAccountOptional;
    }
}
