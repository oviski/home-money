package lv.javaguru.java2.domain.checks;

import java.util.Date;

/**
 * Created by admin on 20.04.2017.
 */
public class Checks {
    private Long checkID;
    private Date dataPourches;
    private Long sumOfCheck;
    private String shopName;
    private Integer userID;
    private Integer userMoneyAccountID;
    private Boolean detailAllow;
    private String comments;

    public Long getCheckID() {
        return checkID;
    }

    public void setCheckID(Long checkID) {
        this.checkID = checkID;
    }

    public Date getDataPourches() {
        return dataPourches;
    }

    public void setDataPourches(Date dataPourches) {
        this.dataPourches = dataPourches;
    }

    public Long getSumOfCheck() {
        return sumOfCheck;
    }

    public void setSumOfCheck(Long sumOfCheck) {
        this.sumOfCheck = sumOfCheck;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getUserMoneyAccountID() {
        return userMoneyAccountID;
    }

    public void setUserMoneyAccountID(Integer userMoneyAccountID) {
        this.userMoneyAccountID = userMoneyAccountID;
    }

    public Boolean getDetailAllow() {
        return detailAllow;
    }

    public void setDetailAllow(Boolean detailAllow) {
        this.detailAllow = detailAllow;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
/*
CREATE TABLE `Checks` (
	`CheckID` bigint NOT NULL,
	`DatePourches` DATE NOT NULL,
	`SumOfCheck` bigint NOT NULL DEFAULT '0',
	`ShopName` varchar(15),
	`UserID` int NOT NULL,
	`UserMoneyAccountID` int NOT NULL,
	`DetailAllow` bit NOT NULL DEFAULT '0',
	`Comments` varchar,
	PRIMARY KEY (`CheckID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;
 */