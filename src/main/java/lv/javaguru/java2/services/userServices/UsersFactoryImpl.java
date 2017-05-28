package lv.javaguru.java2.services.userServices;

import lv.javaguru.java2.database.UsersDAO;
import lv.javaguru.java2.database.jdbc.UsersDAOImpl;
import lv.javaguru.java2.domain.users.Users;

import static lv.javaguru.java2.domain.users.UsersBuilder.createUser;

/**
 * Created by admin on 16.05.2017.
 */
public class UsersFactoryImpl implements UsersFactory {
    private UsersValidator usersValidator = new UsersValidatorImpl();
    private UsersDAO usersDAO = new UsersDAOImpl();

    @Override
    public Users create(String usersName) {
        usersValidator.validate(usersName);

        Users users = createUser()
                .withUserName(usersName).build();

        return usersDAO.save(users);
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