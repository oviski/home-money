package lv.javaguru.java2.services.usersMoneyAccountServices;

import org.springframework.stereotype.Component;

/**
 * Created by admin on 09.05.2017.
 */

public interface UsersMoneyAccountValidator {

    void validate(Integer usersID, String usersMoneyAccountName);
}
