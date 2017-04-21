package lv.javaguru.java2.domain;

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
    private Integer paymentTypeID;
    private boolean detailsAllow;
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
        this.whoPayID = whoPayID;
    }

    public Integer getPaymentTypeID() {
        return paymentTypeID;
    }

    public void setPaymentTypeID(Integer paymentTypeID) {
        this.paymentTypeID = paymentTypeID;
    }

    public boolean isDetailsAllow() {
        return detailsAllow;
    }

    public void setDetailsAllow(boolean detailsAllow) {
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
`CheckID` bigint NOT NULL,
	`DatePourches` DATE NOT NULL,
	`SumOfCheck` bigint NOT NULL DEFAULT '0',
	`ShopName` varchar(15),
	`WhoPayID` int NOT NULL,
	`PaymentTypeID` int NOT NULL,
	`DetailsAllow` bit NOT NULL DEFAULT '0',
	`Comments` varchar(15),
 */