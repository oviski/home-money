package lv.javaguru.java2.domain.products;

import javax.persistence.*;

/**
 * Created by admin on 23.04.2017.
 */
@Entity
@Table (name = "products")
public class Products {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "ProductID")
    private Long productID;
    @Column (name = "CategoryID")
    private Integer categoryID;
    @Column (name = "SubcategoryID")
    private Integer subcategoryID;
    @Column (name = "ProductsName")
    private String productsName;


    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
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

    public String getProductsName() {
        return productsName;
    }

    public void setProductsName(String productsName) {
        this.productsName = productsName;
    }
}
/*
CREATE TABLE `Products` (
	`ProductID` bigint NOT NULL,
	`CategoryID` int NOT NULL,
	`SubcategoryID` bigint,
	`ProductName` bigint NOT NULL,
	PRIMARY KEY (`ProductID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;


 */