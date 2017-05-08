package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.subcategory.Subcategory;

import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 25.04.2017.
 */
public interface SubcategoryDAO {
    Subcategory save(Subcategory subcategory);

    Optional<Subcategory> getById(Integer id);

    void delete(Integer id);

    void update(Subcategory subcategory);

    List<Subcategory> getAll();

}
