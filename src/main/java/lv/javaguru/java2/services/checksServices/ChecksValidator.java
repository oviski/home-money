package lv.javaguru.java2.services.checksServices;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * Created by admin on 24.05.2017.
 */

public interface ChecksValidator {
    void validate(Date dataPourches, Long sumOfCheck, String shopName, Integer userID, Integer userMoneyAccountID, Boolean detailAllow, String comments);
    void validateMaps(Map<String, String[]> params);
}
