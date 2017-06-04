package lv.javaguru.java2.services.userServices;

import lv.javaguru.java2.domain.users.Users;

import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 03.06.2017.
 */
public interface UsersSearch {
    Optional<List<Users>> getAllUsers();
    Optional<Users> getUsersByUserID(Integer userID);

}
