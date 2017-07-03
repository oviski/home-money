package lv.javaguru.java2.domain.category;


import javax.persistence.*;

/**
 * Created by admin on 21.04.2017.
 */
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CategoryID")
    private Integer categoryID;
    @Column (name = "CategoryName")
    private String categoryName;
    @Column (name = "SubcategoryAllow", columnDefinition = "bit")
    private Boolean subcategoryAllow;

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Boolean getSubcategoryAllow() {
        return subcategoryAllow;
    }

    public void setSubcategoryAllow(Boolean subcategoryAllow) {
        this.subcategoryAllow = subcategoryAllow;
    }
}
/*

CREATE TABLE `Category` (

	`CategoryID` int NOT NULL,
	`CategoryName` varchar NOT NULL UNIQUE,
	`SubcategoryAllow` bit NOT NULL DEFAULT '0',
	PRIMARY KEY (`CategoryID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

 */