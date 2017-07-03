package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UsersDAO;
import lv.javaguru.java2.domain.users.Users;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 03.05.2017.
 */
//@Component
public class UsersDAOImpl extends DAOImpl implements UsersDAO {

    public Users save(Users users) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into USERS values (default, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, users.getUserName());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                users.setUserID(rs.getInt(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UsersDAOImpl.save()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

        return users;
    }

    public Optional<Users> getById(Integer id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from USERS where UserID = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Users users = null;
            if (resultSet.next()) {
                users = new Users();
                users.setUserID(resultSet.getInt("UserID"));
                users.setUserName(resultSet.getString("UserName"));
            }
            return Optional.ofNullable(users);
        } catch (Throwable e) {
            System.out.println("Exception while execute UsersDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Users> getAll() throws DBException {
        List<Users> usersList = new ArrayList<Users>();
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from USERS");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Users users = new Users();
                users.setUserID(resultSet.getInt("UserID"));
                users.setUserName(resultSet.getString("UserName"));
                usersList.add(users);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list UsersDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return usersList;
    }

    public void delete(Integer id) throws DBException {
        Connection connection = null;
        try {
            connection =  getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from USERS where UserID = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UsersDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void update(Users users) throws DBException {
        if (users == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update USERS set UserName = ?  where UserID = ?");
            preparedStatement.setString(1, users.getUserName());
            preparedStatement.setLong(2, users.getUserID());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UsersDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

}

