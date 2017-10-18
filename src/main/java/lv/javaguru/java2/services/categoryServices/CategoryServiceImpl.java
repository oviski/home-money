package lv.javaguru.java2.services.categoryServices;

import lv.javaguru.java2.database.CategoryDAO;
import lv.javaguru.java2.domain.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.Callable;

/**
 * Created by admin on 13.07.2017.
 */
@Component
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryValidator categoryValidator;
    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public void edit(Integer categoryID, String categoryName, Boolean subcategoryAllow) {
        Optional<Category> categoryOptional = categoryDAO.getById(categoryID);
        if (!categoryOptional.isPresent()) {
            throw new IllegalArgumentException("Category nit doundby id = " + categoryID);
        }
        categoryValidator.validate(categoryName, subcategoryAllow);
        Category category = categoryOptional.get();
        category.setCategoryName(categoryName);
        category.setSubcategoryAllow(subcategoryAllow);
        categoryDAO.update(category);

    }
}
/*public void edit(Integer usersMonayAccountID, Integer newUsersID, String newUsersMoneyAccountName) {
        Optional<UsersMoneyAccount> usersMoneyAccountOpt = usersMoneyAccountDAO.getById(usersMonayAccountID);
        if (!usersMoneyAccountOpt.isPresent()) {
            throw new IllegalArgumentException("UsersMoneyAccount not doundby id = " + usersMonayAccountID);
        }

        usersMoneyAccountValidator.validate(newUsersID, newUsersMoneyAccountName);

        UsersMoneyAccount usersMoneyAccount = usersMoneyAccountOpt.get();
        usersMoneyAccount.setUserID(newUsersID);
        usersMoneyAccount.setMoneyAccountName(newUsersMoneyAccountName);
        usersMoneyAccountDAO.update(usersMoneyAccount);
    }*/