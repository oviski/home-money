package lv.javaguru.java2.services.usersServices;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by admin on 09.05.2017.
 */
public class UsersValidatorImplTest {
    private UsersValidator validator = new UsersValidatorImpl();

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void shouldThrowExceptionWhenFirstNameIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Users name must be not empty!");
        validator.validate(null);
    }

    @Test
    public void shouldThrowExceptionWhenFirstNameIsEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Users name must be not empty!");
        validator.validate("");
    }

    @Test
    public void shouldThrowExceptionIfUsersNameShorterThen5Symbols(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Users name must be longer then 5 symbols!");
        validator.validate("123");
    }
    @Test
    public void shouldThrowExceptionWhenNameStartsFromDigits(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Users name must be symbols!");
        validator.validate("8Sveta");
    }

    @Test
    public void shouldThtowExceptionWhenNameStartsFromLowSymbols(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Users name must starts from High Symbols!");
        validator.validate("sveta");
    }


    // write more tests


}