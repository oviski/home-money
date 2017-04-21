package lv.javaguru.java2.domain;

/**
 * Created by admin on 20.04.2017.
 */
public class ChecksDetail {
    private Long checkID;
    private Long checkPositionID;
    private Long productID;
    private Long sumOfProducts;
    private String positionDetails;
    private Long checkDetailsID;

    public Long getCheckID() {
        return checkID;
    }

    public void setCheckID(Long checkID) {
        this.checkID = checkID;
    }

    public Long getCheckPositionID() {
        return checkPositionID;
    }

    public void setCheckPositionID(Long checkPositionID) {
        this.checkPositionID = checkPositionID;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public Long getSumOfProducts() {
        return sumOfProducts;
    }

    public void setSumOfProducts(Long sumOfProducts) {
        this.sumOfProducts = sumOfProducts;
    }

    public String getPositionDetails() {
        return positionDetails;
    }

    public void setPositionDetails(String positionDetails) {
        this.positionDetails = positionDetails;
    }

    public Long getCheckDetailsID() {
        return checkDetailsID;
    }

    public void setCheckDetailsID(Long checkDetailsID) {
        this.checkDetailsID = checkDetailsID;
    }
}
/*
CREATE TABLE `ChecksDetails` (
	`CheckID` bigint NOT NULL,
	`ChekPositionID` bigint NOT NULL,
	`ProductID` bigint NOT NULL,
	`SumOfProduct` bigint DEFAULT '0',
	`PositionDatails` varchar,
	`DetailsID` varchar NOT NULL,
	PRIMARY KEY (`DetailsID`)
)

 */
