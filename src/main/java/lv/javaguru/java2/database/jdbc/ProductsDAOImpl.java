import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.ProductsDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.products.Products;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 04.05.2017.
 */
public class ProductsDAOImpl extends DAOImpl implements ProductsDAO {
    public Products save(Products products) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into PRODUCTS values (default, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, products.getCategoryID());
            preparedStatement.setInt(2, products.getSubcategoryID());
            preparedStatement.setString(3, products.getProductsName());


            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                products.setProductID(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute ProductsDAOImpl.save()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

        return products;
    }

    public Optional<Products> getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from PRODUCTS where ProductID = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Products products = null;
            if (resultSet.next()) {
                products = new Products();
                products.setProductID(resultSet.getLong("ProductID"));
                products.setCategoryID(resultSet.getInt("CategoryID"));
                products.setSubcategoryID(resultSet.getInt("SubcategoryID"));
                products.setProductsName(resultSet.getString("ProductName"));
            }
            return Optional.ofNullable(products);
        } catch (Throwable e) {
            System.out.println("Exception while execute ProductsDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Products> getAll() throws DBException {
        List<Products> productsList = new ArrayList<Products>();
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from PRODUCTS");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Products products = new Products();
                products.setProductID(resultSet.getLong("ProductID"));
                products.setCategoryID(resultSet.getInt("CategoryID"));
                products.setSubcategoryID(resultSet.getInt("SubcategoryID"));
                products.setProductsName(resultSet.getString("ProductsName"));
                productsList.add(products);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list ProductsDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return productsList;
    }

    public void delete(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from PRODUCTS where ProductsID = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute ProductsDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void update(Products products) throws DBException {
        if (products == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update PRODUCTS set CategoryID = ?, SubcategoryID = ?, ProductsName = ? " +
                            "where UserID = ?");
            preparedStatement.setInt(1, products.getCategoryID());
            preparedStatement.setInt(2, products.getSubcategoryID());
            preparedStatement.setString(3, products.getProductsName());
            preparedStatement.setLong(4, products.getProductID());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute ProductsDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

}
