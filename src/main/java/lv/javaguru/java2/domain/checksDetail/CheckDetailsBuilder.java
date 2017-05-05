package lv.javaguru.java2.domain.checksDetail;

/**
 * Created by admin on 24.04.2017.
 */
public class CheckDetailsBuilder {
    private Long checkDetailsID;
    private Integer checkPositionID;
    private Integer categoryID;
    private Integer subcategoryID;
    private Long productID;
    private Long sumOfProducts;
    private String positionDetails;


    private CheckDetailsBuilder() {}

    public static CheckDetailsBuilder createChecksDetail() {
        return new CheckDetailsBuilder();
    }

    public CheckDetails build() {
        CheckDetails checkDetails = new CheckDetails();
        checkDetails.setCheckPositionID(checkPositionID);
        checkDetails.setCategoryID(categoryID);
        checkDetails.setSubcategoryID(subcategoryID);
        checkDetails.setProductID(productID);
        checkDetails.setSumOfProducts(sumOfProducts);
        checkDetails.setPositionDetails(positionDetails);
        return checkDetails;
    }

    public CheckDetailsBuilder withCheckPositionID(Integer checkPositionID){
        this.checkPositionID = checkPositionID;
        return this;
    }
    public CheckDetailsBuilder withCategoryID(Integer categoryID){
        this.categoryID = categoryID;
        return this;
    }
    public CheckDetailsBuilder withSubcategoryID(Integer subcategoryID){
        this.subcategoryID = subcategoryID;
        return this;
    }
    public CheckDetailsBuilder withProductsID(Long productID){
        this.productID = productID;
        return this;
    }
    public CheckDetailsBuilder withSumOfProducts(Long sumOfProducts){
        this.sumOfProducts = sumOfProducts;
        return this;
    }
    public CheckDetailsBuilder withPositionDetails(String positionDetails){
        this.positionDetails = positionDetails;
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
