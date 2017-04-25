package lv.javaguru.java2.domain.category;

/**
 * Created by admin on 24.04.2017.
 */
public class CategoryBuilder {
    private String categoryName;
    private Boolean subcategoryAllow;

    private CategoryBuilder() {}

    public static CategoryBuilder createCategory() {
        return new CategoryBuilder();
    }

    public Category build() {
        Category category = new Category();
        category.setCategoryName(categoryName);
        category.setSubcategoryAllow(subcategoryAllow);
        return category;
    }

    public CategoryBuilder withCategoryName(String categoryName){
        this.categoryName = categoryName;
        return this;
    }
    public CategoryBuilder withSubcategoryAllow(Boolean subcategoryAllow){
        this.subcategoryAllow = subcategoryAllow;
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
