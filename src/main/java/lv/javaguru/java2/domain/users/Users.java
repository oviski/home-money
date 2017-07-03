package lv.javaguru.java2.domain.users;

import javax.persistence.*;

/**
 * Created by admin on 24.04.2017.
 */
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "UserID")
    private Integer userID;
    @Column(name = "UserName")
    private String userName;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
/*
CREATE TABLE `UsersID` (
	`UserID` int NOT NULL UNIQUE,
	`UserName` varchar NOT NULL UNIQUE,
	PRIMARY KEY (`UserID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

 */
