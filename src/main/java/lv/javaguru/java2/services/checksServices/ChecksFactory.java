package lv.javaguru.java2.services.checksServices;

import lv.javaguru.java2.domain.checks.Checks;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

/**
 * Created by admin on 24.05.2017.
 */

public interface ChecksFactory {
    Checks create(Date dataPourches, Long sumOfCheck, String shopName, Integer userID, Integer userMoneyAccountID, Boolean detailAllow, String comments) throws SQLException;
    Checks createFromMap (Map<String, String[]> params) throws ParseException, SQLException;
}
/*
private Long checkID;S
    private Date dataPourches;
    private Long sumOfCheck;
    private String shopName;
    private Integer userID;
    private Integer userMoneyAccountID;
    private Boolean detailAllow;
    private String comments;
 */