package lv.javaguru.java2.domain.check;

import lv.javaguru.java2.domain.UserBuilder;

import java.sql.Date;

/**
 * Created by admin on 24.04.2017.
 */
public class CheckBuilder {

    private Date dataPourches;
    private Long sumOfCheck;
    private String shopName;
    private Integer whoPayID;
    private Integer userMoneyAccountID;
    private Boolean detailsAllow;
    private String comments;

    private CheckBuilder() {}

    public static CheckBuilder createCheck() {
        return new CheckBuilder();
    }

    public Check build() {
        Check check = new Check();
        check.setDataPourches(dataPourches);
        check.setSumOfCheck(sumOfCheck);
        check.setShopName(shopName);
        check.setWhoPayID(whoPayID);
        check.setUserMoneyAccountID(userMoneyAccountID);
        check.setDetailsAllow(detailsAllow);
        check.setComments(comments);
        return check;
    }

    public CheckBuilder withDatePourches (Date dataPourches){
        this.dataPourches = dataPourches;
        return this;
    }

    public CheckBuilder withSumOfCheck(Long sumOfCheck){
        this.sumOfCheck = sumOfCheck;
        return this;
    }

    public CheckBuilder withShopName(String shopName){
        this.shopName = shopName;
        return this;
    }
    public CheckBuilder withWhoPayID(Integer whoPayID){
        this.whoPayID = whoPayID;
        return this;
    }
    public CheckBuilder withUserMoneyAccountID(Integer userMoneyAccountID){
        this.userMoneyAccountID = userMoneyAccountID;
        return this;
    }
    public CheckBuilder withDetailsAllow(Boolean detailsAllow){
        this.detailsAllow = detailsAllow;
        return this;
    }
    public CheckBuilder withComments(String comments){
        this.comments = comments;
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
 */