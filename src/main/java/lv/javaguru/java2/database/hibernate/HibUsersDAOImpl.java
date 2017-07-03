package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.UsersDAO;
import lv.javaguru.java2.domain.users.Users;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 27.06.2017.
 */
@Component
@Transactional
public class HibUsersDAOImpl implements UsersDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Users save(Users users) {
        sessionFactory.getCurrentSession().save(users);
        return users;
    }

    @Override
    public Optional<Users> getById(Integer id) {
        Users users = (Users) sessionFactory.getCurrentSession()
                .createCriteria(Users.class)
                .add(Restrictions.eq("userID", id)).uniqueResult();
        return Optional.ofNullable(users);
    }

    @Override
    public void delete(Integer id) {
        Users users = (Users) sessionFactory.getCurrentSession().load(Users.class, id);
        sessionFactory.getCurrentSession().delete(users);
        return;

    }

    @Override
    public void update(Users users) {
        sessionFactory.getCurrentSession().update(users);
        return;

    }

    @Override
    public List<Users> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Users").list();
    }
}
