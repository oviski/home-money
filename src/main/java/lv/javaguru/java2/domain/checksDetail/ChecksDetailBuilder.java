package lv.javaguru.java2.domain.checksDetail;

/**
 * Created by admin on 24.04.2017.
 */
public class ChecksDetailBuilder {
    private Long checkPositionID;
    private Integer categoryID;
    private Integer subcategoryID;
    private Long productID;
    private Long sumOfProducts;
    private String positionDetails;
    private Long checkDetailsID;

    private ChecksDetailBuilder() {}

    public static ChecksDetailBuilder createChecksDetail() {
        return new ChecksDetailBuilder();
    }

    public ChecksDetail build() {
        ChecksDetail checksDetail = new ChecksDetail();
        checksDetail.setCheckPositionID(checkPositionID);
        checksDetail.setCategoryID(categoryID);
        checksDetail.setSubcategoryID(subcategoryID);
        checksDetail.setProductID(productID);
        checksDetail.setSumOfProducts(sumOfProducts);
        checksDetail.setPositionDetails(positionDetails);
        return checksDetail;
    }

    public ChecksDetailBuilder withCheckPositionID(Long checkPositionID){
        this.checkPositionID = checkPositionID;
        return this;
    }
    public ChecksDetailBuilder withCategoryID(Integer categoryID){
        this.categoryID = categoryID;
        return this;
    }
    public ChecksDetailBuilder withSubcategoryID(Integer subcategoryID){
        this.subcategoryID = subcategoryID;
        return this;
    }
    public ChecksDetailBuilder withProductsID(Long productID){
        this.productID = productID;
        return this;
    }
    public ChecksDetailBuilder withSumOfProducts(Long sumOfProducts){
        this.sumOfProducts = sumOfProducts;
        return this;
    }
    public ChecksDetailBuilder withPositionDetails(String positionDetails){
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
