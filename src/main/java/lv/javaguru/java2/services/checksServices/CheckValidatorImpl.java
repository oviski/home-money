package lv.javaguru.java2.services.checksServices;

import lv.javaguru.java2.database.UsersDAO;
import lv.javaguru.java2.database.UsersMoneyAccountDAO;
import lv.javaguru.java2.domain.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import static java.util.Calendar.getInstance;

/**
 * Created by admin on 24.05.2017.
 */
@Component
public class CheckValidatorImpl implements ChecksValidator {
    @Autowired
    private UsersDAO usersDAO;
    @Autowired
    private UsersMoneyAccountDAO usersMoneyAccountDAO;

    @Override
    public void validate(Date dataPourches, Long sumOfCheck, String shopName, Integer userID, Integer userMoneyAccountID, Boolean detailAllow, String comments) {
        validateDataPourches(dataPourches);
        validateSumOfCheck(sumOfCheck);
        validateShopName(shopName);
        validateUserID(userID);
        validateUserMoneyAccountID(userMoneyAccountID);
        validateDetailAllow(detailAllow);
        validateComments(comments);
    }

    @Override
    public void validateMaps(Map<String, String[]> params) {

    }

    private void validateDataPourches(Date dataPourches){
        if (dataPourches == null){
            throw new IllegalArgumentException("DataPourches must be not empty!");
        }
        /*if (dataPourches.before(dd.MM.yyyy, )) {
            throw new IllegalArgumentException("DataPourches less then 01.01.2015! (to late)");
        }*/
        if (dataPourches.after(Calendar.getInstance().getTime())){
            throw new IllegalArgumentException("DataPourches is ftom future!");
        }

    }

    private void validateSumOfCheck(Long sumOfCheck){
        if (sumOfCheck < 0) {
            throw new IllegalArgumentException("SumOfCheck is less by zero!");
        }
        if (sumOfCheck > Long.MAX_VALUE){
            throw new IllegalArgumentException("SumOfCheck ismore than Long limits!");
        }
    }

    private void validateShopName(String shopName){}

    private void validateUserID(Integer userID){
        if (!usersDAO.getById(userID).isPresent()){
            throw new IllegalArgumentException("UsersID not exist!");
        }
    }

    private void validateUserMoneyAccountID(Integer userMoneyAccountID){
        if (!usersMoneyAccountDAO.getById(userMoneyAccountID).isPresent()){
            throw new IllegalArgumentException("UsersMoneyAccountID not exist!");
        }
    }

    private void validateDetailAllow(Boolean detailAllow){}

    private void validateComments(String comments){
        if (comments.length()>35) {
            throw new IllegalArgumentException("Comments is too long! (maximum lenght is 35 symbols)");
        }
    }
}
/*
@Override
    public void validate(String firstName, String lastName) {
        validateFirstName(firstName);
        validateLastName(lastName);
    }

    private void validateFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First Name must be not empty!");
        }
    }

    private void validateLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last Name must be not empty!");
        }
    }

 */