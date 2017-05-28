package lv.javaguru.java2.domain.usersMoneyAccount;

/**
 * Created by admin on 24.04.2017.
 */
public class UsersMoneyAccountBuilder {
    private Integer userID;
    private String moneyAccountName;

    private UsersMoneyAccountBuilder() {}

    public static UsersMoneyAccountBuilder createMoneyAccount() {
        return new UsersMoneyAccountBuilder();
    }

    public UsersMoneyAccount build() {
        UsersMoneyAccount usersMoneyAccount = new UsersMoneyAccount();
        usersMoneyAccount.setUserID(userID);
        usersMoneyAccount.setMoneyAccountName(moneyAccountName);
        return usersMoneyAccount;
    }

    public UsersMoneyAccountBuilder withUserID(Integer userID) {
        this.userID = userID;
        return this;
    }

    public UsersMoneyAccountBuilder withMoneyAccountName(String moneyAccountName) {
        this.moneyAccountName = moneyAccountName;
        return this;
    }

}
