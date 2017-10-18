package lv.javaguru.java2.services.usersServices;

import lv.javaguru.java2.database.UsersDAO;
import lv.javaguru.java2.domain.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 03.06.2017.
 */
@Component
public class UsersSearchImpl implements UsersSearch {
    @Autowired
    private UsersDAO usersDAO;
    @Override
    public Optional<List<Users>> getAllUsers() {
//        UsersDAO usersDAO = new UsersDAOImpl();
        List<Users> allUsersInDB = usersDAO.getAll();
        return Optional.of(allUsersInDB);
    }

    @Override
    public Optional<Users> getUsersByUserID(Integer userID) {
//        UsersDAO usersDAO = new UsersDAOImpl();
        Optional<Users> usersOptional = usersDAO.getById(userID);
        return usersOptional;
    }

}
