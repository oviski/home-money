package lv.javaguru.java2.domain.checksDetail;

import lv.javaguru.java2.domain.subcategory.Subcategory;

/**
 * Created by admin on 20.04.2017.
 */
public class CheckDetails {
    private Long checkDetailID;
    private Long checkID;
    private Integer checkPositionID;
    private Integer categoryID;
    private Integer subcategoryID;
    private Long productID;
    private Long sumOfProducts;
    private String positionDetails;

    public Long getCheckDetailID() {
        return checkDetailID;
    }

    public void setCheckDetailID(Long checkDetailID) {
        this.checkDetailID = checkDetailID;
    }

    public Long getCheckID() {
        return checkID;
    }

    public void setCheckID(Long checkID) {
        this.checkID = checkID;
    }

    public Integer getCheckPositionID() {
        return checkPositionID;
    }

    public void setCheckPositionID(Integer checkPositionID) {
        this.checkPositionID = checkPositionID;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public Integer getSubcategoryID() {
        return subcategoryID;
    }

    public void setSubcategoryID(Integer subcategoryID) {
        this.subcategoryID = subcategoryID;
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
