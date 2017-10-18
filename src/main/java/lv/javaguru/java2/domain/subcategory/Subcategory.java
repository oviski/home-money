package lv.javaguru.java2.domain.subcategory;

import javax.persistence.*;

/**
 * Created by admin on 23.04.2017.
 */
@Entity
@Table (name = "subcategory")
public class Subcategory {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "SubcategoryID")
    private Integer subcategoryID;
    @Column (name = "CategoryID")
    private Integer categoryID;
    @Column (name = "SubcategoryName")
    private String subcategoryName;

    public Integer getSubcategoryID() {
        return subcategoryID;
    }

    public void setSubcategoryID(Integer subcategoryID) {
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
