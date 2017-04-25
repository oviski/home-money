package lv.javaguru.java2.domain.subcategory;

/**
 * Created by admin on 23.04.2017.
 */
public class Subcategory {
    private Long subcategoryID;
    private Integer categoryID;
    private String subcategoryName;

    public Long getSubcategoryID() {
        return subcategoryID;
    }

    public void setSubcategoryID(Long subcategoryID) {
        this.subcategoryID = subcategoryID;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }
}
/*
CREATE TABLE `Subcategory` (
	`SubcategoryID` bigint NOT NULL,
	`CategoryID` int NOT NULL,
	`SubcategoryName` varchar NOT NULL,
	PRIMARY KEY (`SubcategoryID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

 */
