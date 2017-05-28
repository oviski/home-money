package lv.javaguru.java2.domain.users;


/**
 * Created by admin on 24.04.2017.
 */
public class UsersBuilder {
    private String userName;

    private UsersBuilder() {}

    public static UsersBuilder createUser() {
        return new UsersBuilder();
    }

    public Users build() {
        Users users = new Users();
        users.setUserName(userName);
        return users;
    }

    public UsersBuilder withUserName(String userName) {
        this.userName = userName;
        return this;
    }

}
