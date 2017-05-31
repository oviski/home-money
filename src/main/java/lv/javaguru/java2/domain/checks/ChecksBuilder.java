package lv.javaguru.java2.domain.checks;


import java.util.Date;

/**
 * Created by admin on 24.04.2017.
 */
public class ChecksBuilder {

    private Date dataPourches;
    private Long sumOfCheck;
    private String shopName;
    private Integer userID;
    private Integer userMoneyAccountID;
    private Boolean detailAllow;
    private String comments;

    private ChecksBuilder() {}

    public static ChecksBuilder createCheck() {
        return new ChecksBuilder();
    }

    public Checks build() {
        Checks checks = new Checks();
        checks.setDataPourches(dataPourches);
        checks.setSumOfCheck(sumOfCheck);
        checks.setShopName(shopName);
        checks.setUserID(userID);
        checks.setUserMoneyAccountID(userMoneyAccountID);
        checks.setDetailAllow(detailAllow);
        checks.setComments(comments);
        return checks;
    }

    public ChecksBuilder withDatePourches (Date dataPourches){
        this.dataPourches = dataPourches;
        return this;
    }

    public ChecksBuilder withSumOfCheck(Long sumOfCheck){
        this.sumOfCheck = sumOfCheck;
        return this;
    }

    public ChecksBuilder withShopName(String shopName){
        this.shopName = shopName;
        return this;
    }
    public ChecksBuilder withWhoPayID(Integer userID){
        this.userID = userID;
        return this;
    }
    public ChecksBuilder withUserMoneyAccountID(Integer userMoneyAccountID){
        this.userMoneyAccountID = userMoneyAccountID;
        return this;
    }
    public ChecksBuilder withDetailAllow(Boolean detailAllow){
        this.detailAllow = detailAllow;
        return this;
    }
    public ChecksBuilder withComments(String comments){
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