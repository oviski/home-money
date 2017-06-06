package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.CategoryDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.category.Category;
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
public class CategoryDAOImpl extends DAOImpl implements CategoryDAO {
    @Override
    public Category save(Category category) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into CATEGORY values (default, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, category.getCategoryName());
            preparedStatement.setBoolean(2, category.getSubcategoryAllow());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                category.setCategoryID(rs.getInt(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute CategoryDAOImpl.save()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return category;
    }

    @Override
    public Optional<Category> getById(Integer id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from CATEGORY where CategoryID = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Category category = null;
            if (resultSet.next()) {
                category = new Category();
                category.setCategoryID(resultSet.getInt("CategoryID"));
                category.setCategoryName(resultSet.getString("CategoryName"));
                category.setSubcategoryAllow(resultSet.getBoolean("CategoryAllow"));
            }
            return Optional.ofNullable(category);
        } catch (Throwable e) {
            System.out.println("Exception while execute CategoryDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    @Override
    public void delete(Integer id) throws DBException{
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from CATEGORY where CategoryID = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute CategoryDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Category category) throws DBException{
        if (category == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update CATEGORY set CategoryName = ?, SubcategoryAllow = ? " +
                            "where CategoryID = ?");
            preparedStatement.setString(1, category.getCategoryName());
            preparedStatement.setBoolean(2, category.getSubcategoryAllow());
            preparedStatement.setInt(3, category.getCategoryID());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    @Override
    public List<Category> getAll() throws DBException{
        List<Category> categories = new ArrayList<Category>();
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from CATEGORY");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setCategoryID(resultSet.getInt("CategoryID"));
                category.setCategoryName(resultSet.getString("CategoryName"));
                category.setSubcategoryAllow(resultSet.getBoolean("SubcategoryAllow"));
                categories.add(category);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list CategoryDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return categories;

    }
}
