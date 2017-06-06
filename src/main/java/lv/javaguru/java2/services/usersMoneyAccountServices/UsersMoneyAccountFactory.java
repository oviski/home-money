package lv.javaguru.java2.services.usersMoneyAccountServices;

import lv.javaguru.java2.domain.users.Users;
import lv.javaguru.java2.domain.usersMoneyAccount.UsersMoneyAccount;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 09.05.2017.
 */

public interface UsersMoneyAccountFactory {

    UsersMoneyAccount create(Integer usersID, String usersMoneyAccountName);

}
