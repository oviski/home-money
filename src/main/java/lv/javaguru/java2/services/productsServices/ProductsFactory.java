package lv.javaguru.java2.services.productsServices;

import lv.javaguru.java2.domain.products.Products;

public interface ProductsFactory {
    Products create(Integer categoryID, Integer subcategoryID, String productsName);
}

/*@Column (name = "ProductID")
    private Long productID;
    @Column (name = "CategoryID")
    private Integer categoryID;
    @Column (name = "SubcategoryID")
    private Integer subcategoryID;
    @Column (name = "ProductsName")
    private String productsName;*/
