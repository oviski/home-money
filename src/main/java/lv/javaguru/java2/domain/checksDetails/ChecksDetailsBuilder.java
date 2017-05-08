package lv.javaguru.java2.domain.checksDetails;

/**
 * Created by admin on 24.04.2017.
 */
public class ChecksDetailsBuilder {
    private Long checkDetailsID;
    private Integer checkPositionID;
    private Integer categoryID;
    private Integer subcategoryID;
    private Long productID;
    private Long sumOfProducts;
    private String positionDetails;


    private ChecksDetailsBuilder() {}

    public static ChecksDetailsBuilder createChecksDetail() {
        return new ChecksDetailsBuilder();
    }

    public ChecksDetails build() {
        ChecksDetails checksDetails = new ChecksDetails();
        checksDetails.setCheckPositionID(checkPositionID);
        checksDetails.setCategoryID(categoryID);
        checksDetails.setSubcategoryID(subcategoryID);
        checksDetails.setProductID(productID);
        checksDetails.setSumOfProducts(sumOfProducts);
        checksDetails.setPositionDetails(positionDetails);
        return checksDetails;
    }

    public ChecksDetailsBuilder withCheckPositionID(Integer checkPositionID){
        this.checkPositionID = checkPositionID;
        return this;
    }
    public ChecksDetailsBuilder withCategoryID(Integer categoryID){
        this.categoryID = categoryID;
        return this;
    }
    public ChecksDetailsBuilder withSubcategoryID(Integer subcategoryID){
        this.subcategoryID = subcategoryID;
        return this;
    }
    public ChecksDetailsBuilder withProductsID(Long productID){
        this.productID = productID;
        return this;
    }
    public ChecksDetailsBuilder withSumOfProducts(Long sumOfProducts){
        this.sumOfProducts = sumOfProducts;
        return this;
    }
    public ChecksDetailsBuilder withPositionDetails(String positionDetails){
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
