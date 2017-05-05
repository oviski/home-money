package lv.javaguru.java2.database.jdbc;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import lv.javaguru.java2.database.ChecksDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.checks.Checks;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 01.05.2017.
 */
public class ChecksDAOImpl extends DAOImpl implements ChecksDAO {
    @Override
    public Checks save(Checks checks) throws DBException{
        Connection connection = null;

        try {
            connection = (Connection) getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("insert into CHECKS values (default, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setDate(1, checks.getDataPourches());
            preparedStatement.setLong(2, checks.getSumOfCheck());
            preparedStatement.setString(3, checks.getShopName());
            preparedStatement.setInt(4, checks.getUserID());
            preparedStatement.setInt(5, checks.getUserMoneyAccountID());
            preparedStatement.setBoolean(6, checks.getDetailAllow());
            preparedStatement.setString(7, checks.getComments());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();

            if (rs.next()){
                checks.setCheckID(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute ChecksDAOImpl.save()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return checks;
    }

    @Override
    public Optional<Checks> getById(Long id) throws DBException{
        Connection connection = null;

        try {
            connection = (Connection) getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from CHECKS where CheckID = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Checks checks = null;
            if (resultSet.next()) {
                checks = new Checks();
                checks.setCheckID(resultSet.getLong("CheckID"));
                checks.setDataPourches(resultSet.getDate("DatePourches"));
                checks.setSumOfCheck(resultSet.getLong("SumOfCheck"));
                checks.setShopName(resultSet.getString("ShopName"));
                checks.setUserID(resultSet.getInt("UserID"));
                checks.setUserMoneyAccountID(resultSet.getInt("UserMoneyAccountID"));
                checks.setDetailAllow(resultSet.getBoolean("DetailAllow"));
                checks.setComments(resultSet.getString("Comments"));
            }
            return Optional.ofNullable(checks);
        } catch (Throwable e) {
            System.out.println("Exception while execute ChecksDAOImpl.getById()");
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
            connection = getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) connection
                    .prepareStatement("delete from CHECKS where CheckID = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute CheckDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    @Override
    public void update(Checks checks) {
        if (checks == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            java.sql.PreparedStatement preparedStatement = connection
                    .prepareStatement("update CHECKS set DatePourches = ?, SumOfCheck = ?, " +
                            "ShopName = ?, UserID = ?, UserMoneyAccountID = ?, DetailAllow = ?, Comments = ?, " +
                            "where CheckID = ?");
            preparedStatement.setDate(1, checks.getDataPourches());
            preparedStatement.setLong(2, checks.getSumOfCheck());
            preparedStatement.setString(3, checks.getShopName());
            preparedStatement.setInt(4, checks.getUserID());
            preparedStatement.setInt(5, checks.getUserMoneyAccountID());
            preparedStatement.setBoolean(6, checks.getDetailAllow());
            preparedStatement.setString(7, checks.getComments());
            preparedStatement.setLong(8, checks.getCheckID());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute CheckDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    @Override
    public List<Checks> getAll() throws DBException{
        List<Checks> checks = new ArrayList<>();
        Connection connection = null;

        try {
            connection = (Connection) getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("select * from CHECKS");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Checks checks = new Checks();
                checks.setCheckID(resultSet.getLong("CheckID"));
                checks.setDataPourches(resultSet.getDate("DatePourches"));
                checks.setSumOfCheck(resultSet.getLong("SumOfCheck"));
                checks.setShopName(resultSet.getString("ShopName"));
                checks.setUserID(resultSet.getInt("UserID"));
                checks.setUserMoneyAccountID(resultSet.getInt("UserMoneyAccountID"));
                checks.setDetailAllow(resultSet.getBoolean("DetailAllow"));
                checks.setComments(resultSet.getString("Comments"));
                checks.add(checks);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list ChecksDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return checks;
    }
}
