package lv.javaguru.java2.database.jdbc;

import com.mysql.jdbc.Connection;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UsersDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.users.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * Created by admin on 03.05.2017.
 */
public class UsersDAOImpl extends DAOImpl implements UsersDAO {

    public Users save(Users users) throws DBException {
        Connection connection = null;

        try {
            connection = (Connection) getConnection();
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

    public Optional<Users> getById(int id) throws DBException {
        Connection connection = null;

        try {
            connection = (Connection) getConnection();
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
            connection = (Connection) getConnection();
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

    public void delete(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = (Connection) getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from USERS where UserID = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void update(User user) throws DBException {
        if (user == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = (Connection) getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update USERS set FirstName = ?, LastName = ? " +
                            "where UserID = ?");
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setLong(3, user.getUserId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

}

