package lv.javaguru.java2.services.subcategoryServices;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class SubcategoryValidatorImplTest {

    SubcategoryValidator subcategoryValidator = new SubcategoryValidatorImpl();

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void CategoryIDisEmpty(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("In subcategories categoryID must be empty!");
        subcategoryValidator.validate(null, "subcategoryName");
    }

}


/* private UserValidator validator = new UserValidatorImpl();

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void shouldThrowExceptionWhenFirstNameIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("First Name must be not empty!");
        validator.validate(null, "password");
    }

    @Test
    public void shouldThrowExceptionWhenFirstNameIsEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("First Name must be not empty!");
        validator.validate("", "password");
    }
*/