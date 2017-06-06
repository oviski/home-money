package lv.javaguru.java2.services.userServices;

import lv.javaguru.java2.domain.users.Users;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 09.05.2017.
 */

public interface UsersFactory {

    Users create(String usersName);

}
