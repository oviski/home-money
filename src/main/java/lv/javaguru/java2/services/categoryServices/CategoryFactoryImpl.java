package lv.javaguru.java2.services.categoryServices;

import lv.javaguru.java2.database.CategoryDAO;
import lv.javaguru.java2.domain.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.java2.domain.category.CategoryBuilder.createCategory;

/**
 * Created by admin on 12.07.2017.
 */
@Component
public class CategoryFactoryImpl implements CategoryFactory {
    @Autowired
    private CategoryValidator categoryValidator;
    @Autowired
    private CategoryDAO categoryDAO;
    @Override
    public Category create(String categoryName, Boolean subcategoryAllow) {
         categoryValidator.validate(categoryName, subcategoryAllow);
         Category category = createCategory()
                 .withCategoryName(categoryName)
                 .withSubcategoryAllow(subcategoryAllow).build();
         return categoryDAO.save(category);
    }
}
