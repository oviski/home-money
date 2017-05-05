package lv.javaguru.java2.database.jdbc;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UsersMoneyAccountDAO;
import lv.javaguru.java2.domain.usersMoneyAccount.UsersMoneyAccount;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 04.05.2017.
 */
public class UsersMoneyAccountDAOImpl extends DAOImpl implements UsersMoneyAccountDAO {
    @Override
    public UsersMoneyAccount save(UsersMoneyAccount usersMoneyAccount) throws DBException{
        Connection connection = null;

        try {
            connection = (Connection) getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into USERSMONEYACCOUNT values(default, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, usersMoneyAccount.getUserID());
            preparedStatement.setString(2, usersMoneyAccount.getMoneyAccountName());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                usersMoneyAccount.setUserMoneyAccountID(rs.getInt(1));
            }

        } catch (Throwable e) {
            System.out.println("Exception while execute UsersMoneyAccountDAOImpl.save()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return usersMoneyAccount;
    }

    @Override
    public Optional<UsersMoneyAccount> getById(Long id) throws DBException{
        Connection connection = null;

        try{
            connection= getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from USERSMONEYACCOUNT where UsersMoneyAccountID = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            UsersMoneyAccount usersMoneyAccount = null;
            if (resultSet.next()){
                usersMoneyAccount = new UsersMoneyAccount();
                usersMoneyAccount.setUserMoneyAccountID(resultSet.getInt("UserMoneyAccountID"));
                usersMoneyAccount.setUserID(resultSet.getInt("UserID"));
                usersMoneyAccount.setMoneyAccountName(resultSet.getString("MoneyAccountName"));
            }
            return Optional.ofNullable(usersMoneyAccount);
        } catch (Throwable e){
            System.out.println("Exception whileexecute UsersMoneyAccountDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void delete(Long id) throws DBException{
        Connection connection = null;
        try {
            connection = (Connection) getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from USERSMONEYACCOUNT where UserMoneyAccountID = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UsersMoneyAccountDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    @Override
    public void update(UsersMoneyAccount usersMoneyAccount) throws DBException{
        if (usersMoneyAccount == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update USERSMONEYACCOUNT set UserID = ?, MoneyAccountName = ?" +
                            "where UserMoneyAccountID = ?");
            preparedStatement.setInt(1, usersMoneyAccount.getUserID());
            preparedStatement.setString(2, usersMoneyAccount.getMoneyAccountName());
            preparedStatement.setInt(3, usersMoneyAccount.getUserMoneyAccountID());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UsersMoneyccountDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    @Override
    public List<UsersMoneyAccount> getAll() throws DBException{
        List<UsersMoneyAccount> usersMoneyAccounts = new ArrayList<UsersMoneyAccount>();
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from USERSMONEYACCOUNT");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UsersMoneyAccount usersMoneyAccount = new UsersMoneyAccount();
                usersMoneyAccount.setUserMoneyAccountID(resultSet.getInt("UserMoneyAccountID"));
                usersMoneyAccount.setUserID(resultSet.getInt("UserID"));
                usersMoneyAccount.setMoneyAccountName(resultSet.getString("MoneyAccountName"));
                usersMoneyAccounts.add(usersMoneyAccount);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list UsersMoneyAccountNameDAOImpl");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return usersMoneyAccounts;
    }
}