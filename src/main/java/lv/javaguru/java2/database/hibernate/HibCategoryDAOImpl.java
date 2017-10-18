package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.CategoryDAO;
import lv.javaguru.java2.domain.category.Category;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 07.07.2017.
 */
@Component
public class HibCategoryDAOImpl implements CategoryDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Category save(Category category) {
        sessionFactory.getCurrentSession().save(category);
        return category;
    }

    @Override
    public Optional<Category> getById(Integer id) {
        Category category = (Category) sessionFactory.getCurrentSession()
                .createCriteria(Category.class)
                .add(Restrictions.eq("categoryID", id)).uniqueResult();
        return Optional.ofNullable(category);
    }

    @Override
    public void delete(Integer id) {
        Category category = (Category) sessionFactory.getCurrentSession().load(Category.class, id);
        sessionFactory.getCurrentSession().delete(category);
        return;

    }

    @Override
    public void update(Category category) {
        sessionFactory.getCurrentSession().update(category);
        return;

    }

    @Override
    public List<Category> getAll() {
        return sessionFactory.openSession().createCriteria(Category.class).list();
    }
}
