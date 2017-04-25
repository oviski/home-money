package lv.javaguru.java2.domain.checksDetail;

import lv.javaguru.java2.domain.subcategory.Subcategory;

/**
 * Created by admin on 20.04.2017.
 */
public class ChecksDetail {
    private Long checkID;
    private Long checkPositionID;
    private Integer categoryID;
    private Integer SubcategoryID;
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

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public Integer getSubcategoryID() {
        return SubcategoryID;
    }

    public void setSubcategoryID(Integer subcategoryID) {
        SubcategoryID = subcategoryID;
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
CREATE TABLE `CheckDetails` (
	`CheckID` bigint NOT NULL,
	`ChekPositionID` bigint NOT NULL,
	`CategoryID` int NOT NULL,
	`SubcategoryID` int NOT NULL,
	`ProductID` bigint NOT NULL,
	`SumOfProduct` bigint DEFAULT '0',
	`PositionDatails` varchar,
	`DetailsID` varchar NOT NULL,
	PRIMARY KEY (`DetailsID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;
)

 */
