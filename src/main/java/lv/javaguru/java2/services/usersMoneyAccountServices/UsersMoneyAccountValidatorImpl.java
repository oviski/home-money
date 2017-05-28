package lv.javaguru.java2.services.usersMoneyAccountServices;

/**
 * Created by admin on 09.05.2017.
 */
public class UsersMoneyAccountValidatorImpl implements UsersMoneyAccountValidator {

    @Override
    public void validate(Integer usersID, String usersMoneyAccoutName) {
        validateUsersID(usersID);
        validateUsersMoneyAccountName(usersMoneyAccoutName);
    }

    private void validateUsersMoneyAccountName(String usersMoneyAccoutName) {
    }

    private void validateUsersID(Integer usersID) {
        /*if (usersName == null || usersName.isEmpty()) {
            throw new IllegalArgumentException("Users name must be not empty!");
        }

        if (usersName.length() <= 5){
            throw new IllegalArgumentException("Users name must be longer then 5 symbols!");
        }

        char[] charsUsersName = usersName.toCharArray();
        //if (charsUsersName():)
    */}
}
