package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.ChecksDetailsDAO;
import lv.javaguru.java2.domain.checksDetails.ChecksDetails;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 05.07.2017.
 */
@Component
public class HibChecksDetailsDAOImpl implements ChecksDetailsDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public ChecksDetails save(ChecksDetails checksDetails) {
        sessionFactory.getCurrentSession().save(checksDetails);
        return checksDetails;
    }

    @Override
    public Optional<ChecksDetails> getById(Long id) {
        ChecksDetails checksDetails = (ChecksDetails) sessionFactory.getCurrentSession()
                .createCriteria(ChecksDetails.class)
                .add(Restrictions.eq("checksDetailsID", id)).uniqueResult();
        return Optional.ofNullable(checksDetails);
    }

    @Override
    public void delete(Long id) {
        ChecksDetails checksDetails = (ChecksDetails) sessionFactory.getCurrentSession().load(ChecksDetails.class, id);
        sessionFactory.getCurrentSession().delete(checksDetails);
        return;
    }

    @Override
    public void update(ChecksDetails checksDetails) {
        sessionFactory.getCurrentSession().update(checksDetails);
        return;

    }

    @Override
    public List<ChecksDetails> getAll() {
        return sessionFactory.openSession().createCriteria(ChecksDetails.class).list();
    }
}
