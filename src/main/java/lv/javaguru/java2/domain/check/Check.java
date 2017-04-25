package lv.javaguru.java2.domain.check;

import java.sql.Date;

/**
 * Created by admin on 20.04.2017.
 */
public class Check {
    private Long checkID;
    private Date dataPourches;
    private Long sumOfCheck;
    private String shopName;
    private Integer whoPayID;
    private Integer userMoneyAccountID;
    private Boolean detailsAllow;
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

    public Integer getWhoPayID() {
        return whoPayID;
    }

    public void setWhoPayID(Integer whoPayID) {
        this.whoPayID = this.whoPayID;
    }

    public Integer getUserMoneyAccountID() {
        return userMoneyAccountID;
    }

    public void setUserMoneyAccountID(Integer userMoneyAccountID) {
        this.userMoneyAccountID = userMoneyAccountID;
    }

    public Boolean getDetailsAllow() {
        return detailsAllow;
    }

    public void setDetailsAllow(Boolean detailsAllow) {
        this.detailsAllow = detailsAllow;
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
	`WhoPayID` int NOT NULL,
	`UserMoneyAccountID` int NOT NULL,
	`DetailsAllow` bit NOT NULL DEFAULT '0',
	`Comments` varchar,
	PRIMARY KEY (`CheckID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;
 */