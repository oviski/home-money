package lv.javaguru.java2.domain.products;

/**
 * Created by admin on 24.04.2017.
 */
public class ProductsBuilder {
    private Integer categoryID;
    private Integer subcategoryID;
    private String productsName;

    private ProductsBuilder() {}

    public static ProductsBuilder createProducts(){
        return new ProductsBuilder();
    }

    public Products build() {
        Products products = new Products();
        products.setCategoryID(categoryID);
        products.setSubcategoryID(subcategoryID);
        products.setProductsName(productsName);
        return products;
    }

    public ProductsBuilder withCategoryID(Integer categoryID){
        this.categoryID = categoryID;
        return this;
    }
    public ProductsBuilder withSubcategoryID(Integer subcategoryID){
        this.subcategoryID = subcategoryID;
        return this;
    }
    public ProductsBuilder withProductsName(String productsName){
        this.productsName = productsName;
        return this;
    }

}
/*
public class UserBuilder {

    private String firstName;
    private String lastName;


    private UserBuilder() {}

    public static UserBuilder createUser() {
        return new UserBuilder();
    }

    public User build() {
        User users = new User();
        users.setFirstName(firstName);
        users.setLastName(lastName);
        return users;
    }

    public UserBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

}

 */
