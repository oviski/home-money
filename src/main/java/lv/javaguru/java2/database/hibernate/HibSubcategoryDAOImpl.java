package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.SubcategoryDAO;
import lv.javaguru.java2.domain.subcategory.Subcategory;
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
public class HibSubcategoryDAOImpl implements SubcategoryDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Subcategory save(Subcategory subcategory) {
        sessionFactory.getCurrentSession().save(subcategory);
        return subcategory;
    }

    @Override
    public Optional<Subcategory> getById(Integer id) {
        Subcategory subcategory = (Subcategory) sessionFactory.getCurrentSession()
                .createCriteria(Subcategory.class)
                .add(Restrictions.eq("subcategoryID", id)).uniqueResult();
        return Optional.ofNullable(subcategory);
    }

    @Override
    public void delete(Integer id) {
        Subcategory subcategory = (Subcategory) sessionFactory.getCurrentSession().load(Subcategory.class, id);
        sessionFactory.getCurrentSession().delete(subcategory);
        return;
    }

    @Override
    public void update(Subcategory subcategory) {
        sessionFactory.getCurrentSession().update(subcategory);
        return;
    }

    @Override
    public List<Subcategory> getAll() {
        return sessionFactory.openSession().createCriteria(Subcategory.class).list();
    }
}

