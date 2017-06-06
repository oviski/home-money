package lv.javaguru.java2.services.userServices;

import org.springframework.stereotype.Component;

/**
 * Created by admin on 09.05.2017.
 */
@Component
public class UsersValidatorImpl implements UsersValidator{

    @Override
    public void validate(String usersName) {
        validateUsersName(usersName);
    }

    private void validateUsersName(String usersName) {
        if (usersName == null || usersName.isEmpty()) {
            throw new IllegalArgumentException("Users name must be not empty!");
        }

        if (usersName.length() <= 5){
            throw new IllegalArgumentException("Users name must be longer then 5 symbols!");
        }

        char[] charsUsersName = usersName.toCharArray();
        //if (charsUsersName():)
    }
}
