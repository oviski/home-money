package lv.javaguru.java2.services.usersMoneyAccountServices;

import lv.javaguru.java2.database.UsersMoneyAccountDAO;
import lv.javaguru.java2.domain.usersMoneyAccount.UsersMoneyAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by admin on 16.05.2017.
 */
@Component
public class UsersMoneyAccountServiceImpl implements UsersMoneyAccountService{
    @Autowired
    private UsersMoneyAccountDAO usersMoneyAccountDAO; // = new UsersMoneyAccountDAOImpl();
    @Autowired
    private UsersMoneyAccountValidator usersMoneyAccountValidator; // = new UsersMoneyAccountValidatorImpl();


    @Override
    public void edit(Integer usersMonayAccountID, Integer newUsersID, String newUsersMoneyAccountName) {
        Optional<UsersMoneyAccount> usersMoneyAccountOpt = usersMoneyAccountDAO.getById(usersMonayAccountID);
        if (!usersMoneyAccountOpt.isPresent()) {
            throw new IllegalArgumentException("UsersMoneyAccount not doundby id = " + usersMonayAccountID);
        }

        usersMoneyAccountValidator.validate(newUsersID, newUsersMoneyAccountName);

        UsersMoneyAccount usersMoneyAccount = usersMoneyAccountOpt.get();
        usersMoneyAccount.setUserID(newUsersID);
        usersMoneyAccount.setMoneyAccountName(newUsersMoneyAccountName);
        usersMoneyAccountDAO.update(usersMoneyAccount);
    }
}
/*
private UserDAO userDAO = new UserDAOImpl();
    private UserValidator userValidator = new UserValidatorImpl();

    @Override
    public void edit(Long userId,
                     String newFirstName,
                     String newLastName) {
        Optional<User> userOpt = userDAO.getById(userId);
        if (!userOpt.isPresent()) {
            throw new IllegalArgumentException("User not found by id = " + userId);
        }

        userValidator.validate(newFirstName, newLastName);

        User user = userOpt.get();
        user.setFirstName(newFirstName);
        user.setLastName(newLastName);
        userDAO.update(user);
    }

 */
