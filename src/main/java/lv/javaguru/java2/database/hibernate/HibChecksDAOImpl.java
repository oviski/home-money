package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.ChecksDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.checks.Checks;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 20.06.2017.
 */
@Component
@Transactional
public class HibChecksDAOImpl implements ChecksDAO {

    @Autowired
    private SessionFactory sessionFactory;

/*
    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
*/

    @Override
    public Checks save(Checks checks){
        sessionFactory.getCurrentSession().save(checks);

        return checks;
    }

    @Override
    public Optional<Checks> getById(Long id) {
        Checks check = (Checks) sessionFactory.getCurrentSession()
                .createCriteria(Checks.class)
                .add(Restrictions.eq("checkID", id)).uniqueResult();
        return Optional.ofNullable(check);
    }

    @Override
    public void delete(Long id) {
        Checks checks = (Checks) sessionFactory.getCurrentSession().load(Checks.class, id);
        sessionFactory.getCurrentSession().delete(checks);
        return;

    }

    @Override
    public void update(Checks checks) {
        sessionFactory.getCurrentSession().update(checks);
        return;


    }

    @Override
    public List<Checks> getAll() {
        return sessionFactory.openSession().createCriteria(Checks.class).list();
//        return sessionFactory.getCurrentSession().createQuery("from Checks").list();
    }
}
