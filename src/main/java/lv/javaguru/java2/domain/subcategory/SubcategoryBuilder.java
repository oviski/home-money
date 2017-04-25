package lv.javaguru.java2.domain.subcategory;

/**
 * Created by admin on 24.04.2017.
 */
public class SubcategoryBuilder {
    private Integer categoryID;
    private String subcategoryName;

    private SubcategoryBuilder() {}

    public static SubcategoryBuilder createSubcategory() {
        return new SubcategoryBuilder();
    }

    public Subcategory build() {
        Subcategory subcategory = new Subcategory();
        subcategory.setCategoryID(categoryID);
        subcategory.setSubcategoryName(subcategoryName);
        return subcategory;
    }

    public SubcategoryBuilder withCategoryID(Integer categoryID){
        this.categoryID = categoryID;
        return this;
    }

    public SubcategoryBuilder withSubcategoryName(String subcategoryName){
        this.subcategoryName = subcategoryName;
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