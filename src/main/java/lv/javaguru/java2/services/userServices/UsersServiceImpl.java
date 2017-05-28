package lv.javaguru.java2.services.userServices;

import lv.javaguru.java2.database.UsersDAO;
import lv.javaguru.java2.database.jdbc.UsersDAOImpl;
import lv.javaguru.java2.domain.users.Users;

import java.util.Optional;

/**
 * Created by admin on 16.05.2017.
 */
public class UsersServiceImpl implements UsersService{
    private UsersDAO usersDAO = new UsersDAOImpl();
    private UsersValidator usersValidator = new UsersValidatorImpl();

    @Override
    public void edit(Integer userID, String newUserName) {
        Optional<Users> usersOpt = usersDAO.getById(userID);
        if (!usersOpt.isPresent()){
            throw new IllegalArgumentException("User not found by ID = " + userID);
        }

        usersValidator.validate(newUserName);

        Users users = usersOpt.get();
        users.setUserName(newUserName);
        usersDAO.update(users);

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
