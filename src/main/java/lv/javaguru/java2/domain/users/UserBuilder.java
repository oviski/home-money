package lv.javaguru.java2.domain.users;


/**
 * Created by admin on 24.04.2017.
 */
public class UserBuilder {
    private String userName;

    private UserBuilder() {}

    public static UserBuilder createUser() {
        return new UserBuilder();
    }

    public Users build() {
        Users users = new Users();
        users.setUserName(userName);
        return users;
    }

    public UserBuilder withUserName(String userName) {
        this.userName = userName;
        return this;
    }

}
