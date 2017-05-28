package lv.javaguru.java2.services.checksServices;

import lv.javaguru.java2.domain.checks.Checks;

import java.sql.SQLException;

/**
 * Created by admin on 24.05.2017.
 */
public interface ChecksFactory {
    Checks create(java.sql.Date dataPourches, Long sumOfCheck, String shopName, Integer userID, Integer userMoneyAccountID, Boolean detailAllow, String comments) throws SQLException;
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