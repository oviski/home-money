package lv.javaguru.java2.database.jdbc;


import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.SubcategoryDAO;
import lv.javaguru.java2.domain.subcategory.Subcategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 04.05.2017.
 */
public class SubcategoryDAOImpl extends DAOImpl implements SubcategoryDAO {

    public Subcategory save(Subcategory subcategory) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into SUBCATEGORY values (default, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, subcategory.getCategoryID());
            preparedStatement.setString(2, subcategory.getSubcategoryName());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                subcategory.setSubcategoryID(rs.getInt(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute SubcategoryDAOImpl.save()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

        return subcategory;
    }

    public Optional<Subcategory> getById(Integer id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from SUBCATEGORY where SubcategoryID = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Subcategory subcategory = null;
            if (resultSet.next()) {
                subcategory = new Subcategory();
                subcategory.setSubcategoryID(resultSet.getInt("SubcategoryID"));
                subcategory.setCategoryID(resultSet.getInt("CategoryID"));
                subcategory.setSubcategoryName(resultSet.getString("SubcategoryName"));
            }
            return Optional.ofNullable(subcategory);
        } catch (Throwable e) {
            System.out.println("Exception while execute SubcategoryDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Subcategory> getAll() throws DBException {
        List<Subcategory> subcategories = new ArrayList<Subcategory>();
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from SUBCATEGORY");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Subcategory subcategory = new Subcategory();
                subcategory.setSubcategoryID(resultSet.getInt("SubcategoryID"));
                subcategory.setCategoryID(resultSet.getInt("CategoryID"));
                subcategory.setSubcategoryName(resultSet.getString("SubcategoryName"));
                subcategories.add(subcategory);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list SubcategoryDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return subcategories;
    }

    public void delete(Integer id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from SUBCATEGORY where SubcategoryID = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute SubcategoryDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void update(Subcategory subcategory) throws DBException {
        if (subcategory == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update SUBCATEGORY set CategoryID = ?, SubcategoryName = ? " +
                            "where SubcategoryID = ?");
            preparedStatement.setInt(1, subcategory.getCategoryID());
            preparedStatement.setString(2, subcategory.getSubcategoryName());
            preparedStatement.setInt(3, subcategory.getSubcategoryID());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute SubcategoryDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

}
