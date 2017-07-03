package lv.javaguru.java2.domain.usersMoneyAccount;

import javax.persistence.*;

/**
 * Created by admin on 24.04.2017.
 */
@Entity
@Table (name = "usersmoneyaccount")
public class UsersMoneyAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UserMoneyAccountID")
    private Integer userMoneyAccountID;
    @Column(name = "UserID")
    private Integer userID;
    @Column(name = "MoneyAccountName")
    private String moneyAccountName;

    public Integer getUserMoneyAccountID() {
        return userMoneyAccountID;
    }

    public void setUserMoneyAccountID(Integer userMoneyAccountID) {
        this.userMoneyAccountID = userMoneyAccountID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getMoneyAccountName() {
        return moneyAccountName;
    }

    public void setMoneyAccountName(String moneyAccountName) {
        this.moneyAccountName = moneyAccountName;
    }



}
/*
CREATE TABLE `UsersMoneyAccount` (
	`UserMoneyAccountID` int NOT NULL,
	`UserID` int NOT NULL,
	`MoneyAccountName` varchar NOT NULL UNIQUE,
	PRIMARY KEY (`UserMoneyAccountID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

 */
