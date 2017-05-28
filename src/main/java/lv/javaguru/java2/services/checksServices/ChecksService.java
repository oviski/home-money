package lv.javaguru.java2.services.checksServices;

import java.util.Date;

/**
 * Created by admin on 24.05.2017.
 */
public interface ChecksService {
    void edit(Long checkID, Date dataPourches, Long sumOfCheck, String shopName, Integer userID, Integer userMoneyAccountID, Boolean detailAllow, String comments);
}
