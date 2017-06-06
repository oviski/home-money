package lv.javaguru.java2.services.checksServices;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * Created by admin on 24.05.2017.
 */
@Component
public class CheckValidatorImpl implements ChecksValidator {
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

    }

    private void validateSumOfCheck(Long sumOfCheck){}
    private void validateShopName(String shopName){}
    private void validateUserID(Integer userID){}
    private void validateUserMoneyAccountID(Integer userMoneyAccountID){}
    private void validateDetailAllow(Boolean detailAllow){}
    private void validateComments(String comments){}
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