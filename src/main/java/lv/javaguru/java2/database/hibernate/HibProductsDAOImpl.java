package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.ProductsDAO;
import lv.javaguru.java2.domain.products.Products;
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
public class HibProductsDAOImpl implements ProductsDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Products save(Products products) {
        sessionFactory.getCurrentSession().save(products);
        return products;
    }

    @Override
    public Optional<Products> getById(Long id) {
        Products products = (Products) sessionFactory.getCurrentSession()
                .createCriteria(Products.class)
                .add(Restrictions.eq("productsID", id))
                .uniqueResult();
        return Optional.ofNullable(products);
    }

    @Override
    public void delete(Long id) {
        Products products = (Products) sessionFactory.getCurrentSession().load(Products.class, id);
        sessionFactory.getCurrentSession().delete(products);
        return;
    }

    @Override
    public void update(Products products) {
        sessionFactory.getCurrentSession().update(products);
    }

    @Override
    public List<Products> getAll() {
        return sessionFactory.openSession().createCriteria(Products.class).list();
    }
}
