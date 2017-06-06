package lv.javaguru.java2.services.usersMoneyAccountServices;

import lv.javaguru.java2.database.UsersDAO;
import lv.javaguru.java2.database.UsersMoneyAccountDAO;
import lv.javaguru.java2.database.jdbc.UsersDAOImpl;
import lv.javaguru.java2.database.jdbc.UsersMoneyAccountDAOImpl;
import lv.javaguru.java2.domain.users.Users;
import lv.javaguru.java2.domain.usersMoneyAccount.UsersMoneyAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.java2.domain.users.UsersBuilder.createUser;
import static lv.javaguru.java2.domain.usersMoneyAccount.UsersMoneyAccountBuilder.createMoneyAccount;

/**
 * Created by admin on 16.05.2017.
 */
@Component
public class UsersMoneyAccountFactoryImpl implements UsersMoneyAccountFactory {
    @Autowired
    private UsersMoneyAccountValidator usersMoneyAccountValidator;// = new UsersMoneyAccountValidatorImpl();
    @Autowired
    private UsersMoneyAccountDAO usersMoneyAccountDAO; // = new UsersMoneyAccountDAOImpl();


    @Override
    public UsersMoneyAccount create(Integer usersID, String usersMoneyAccountName) {
        usersMoneyAccountValidator.validate(usersID, usersMoneyAccountName);

        UsersMoneyAccount usersMoneyAccount = createMoneyAccount()
                .withUserID(usersID)
                .withMoneyAccountName(usersMoneyAccountName).build();

        return usersMoneyAccountDAO.save(usersMoneyAccount);
    }
}
/*
    private UserValidator userValidator = new UserValidatorImpl();
    private UserDAO userDAO = new UserDAOImpl();


    @Override
    public User create(String firstName, String lastName) {
        userValidator.validate(firstName, lastName);

        User user = createUser()
                .withFirstName(firstName)
                .withLastName(lastName).build();

        return userDAO.save(user);
    }

 */