package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.UsersMoneyAccountDAO;
import lv.javaguru.java2.domain.usersMoneyAccount.UsersMoneyAccount;
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
public class HibUsersMoneyAccountDAOImpl implements UsersMoneyAccountDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public UsersMoneyAccount save(UsersMoneyAccount usersMoneyAccount) {
        sessionFactory.getCurrentSession().save(usersMoneyAccount);
        return usersMoneyAccount;
    }

    @Override
    public Optional<UsersMoneyAccount> getById(Integer id) {
        UsersMoneyAccount usersMoneyAccount = (UsersMoneyAccount) sessionFactory.getCurrentSession()
                .createCriteria(UsersMoneyAccount.class)
                .add(Restrictions.eq("userMoneyAccountID", id)).uniqueResult();
        return Optional.ofNullable(usersMoneyAccount);
    }

    @Override
    public void delete(Integer id) {
        UsersMoneyAccount usersMoneyAccount = (UsersMoneyAccount) sessionFactory.getCurrentSession().load(UsersMoneyAccount.class, id);
        sessionFactory.getCurrentSession().delete(usersMoneyAccount);
        return;

    }

    @Override
    public void update(UsersMoneyAccount usersMoneyAccount) {
        sessionFactory.getCurrentSession().update(usersMoneyAccount);
        return;
    }

    @Override
    public List<UsersMoneyAccount> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from UsersMoneyAccount").list();
    }

    @Override
    public Optional<List<UsersMoneyAccount>> getByUsersID(Integer usersID) {
        List<UsersMoneyAccount> usersMoneyAccountList = sessionFactory.getCurrentSession()
                .createCriteria(UsersMoneyAccount.class)
                //.createCriteria("from UsersMoneyAccout")
                .add(Restrictions.eq("userID", usersID)).list();
        return Optional.ofNullable(usersMoneyAccountList);
    }
}
