package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.category.Category;

import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 25.04.2017.
 */
public interface CategoryDAO {
    Category save(Category category);

    Optional<Category> getById(Long id);

    void delete(Long id);

    void update(Category user);

    List<Category> getAll();

}
