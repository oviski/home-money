package lv.javaguru.java2.database.jdbc;


import lv.javaguru.java2.database.ChecksDetailsDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.checksDetails.ChecksDetails;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 02.05.2017.
 */

public class ChecksDetailsDAOImpl extends DAOImpl implements ChecksDetailsDAO {
    @Override
    public ChecksDetails save(ChecksDetails checksDetails) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("insert into CHECKSDETAIL values (default, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, checksDetails.getCheckID());
            preparedStatement.setLong(2, checksDetails.getCheckPositionID());
            preparedStatement.setInt(3, checksDetails.getCategoryID());
            preparedStatement.setInt(4, checksDetails.getSubcategoryID());
            preparedStatement.setLong(5, checksDetails.getProductID());
            preparedStatement.setLong(6, checksDetails.getSumOfProducts());
            preparedStatement.setString(7, checksDetails.getPositionDetails());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();

            if (rs.next()){
                checksDetails.setCheckDetailID(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute ChecksDetailDAOImpl.save()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return checksDetails;
    }

    @Override
    public Optional<ChecksDetails> getById(Long id) throws DBException{
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from CHECKSDETAILS where ChecksDetailsID = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            ChecksDetails checksDetail = null;
            if (resultSet.next()) {
                checksDetail = new ChecksDetails();
                checksDetail.setCheckDetailID(resultSet.getLong("checksDetailsID"));
                checksDetail.setCheckID(resultSet.getLong("checkID"));
                checksDetail.setCheckPositionID(resultSet.getInt("checkPositionID"));
                checksDetail.setCategoryID(resultSet.getInt("categoryID"));
                checksDetail.setSubcategoryID(resultSet.getInt("subcategoryID"));
                checksDetail.setProductID(resultSet.getLong("productID"));
                checksDetail.setSumOfProducts(resultSet.getLong("sumOfProducts"));
                checksDetail.setPositionDetails(resultSet.getString("positionDetails"));
            }
            return Optional.ofNullable(checksDetail);
        } catch (Throwable e) {
            System.out.println("Exception while execute ChecksDetailsDAOImpl.getById()");
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
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from CHECKSDETAIL where ChecksDetailID = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute ChecksDetailDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    @Override
    public void update(ChecksDetails checksDetail) {
        if (checksDetail == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update CHECKSDETAIL set CheckID = ?, CheckPositionID = ?, CategoryID = ?, SubcategoryID = ?, ProductID = ?, SumOfProduct = ?, positionDetails = ?, where ChecksDetailsID = ?");
            preparedStatement.setLong(1, checksDetail.getCheckID());
            preparedStatement.setLong(2, checksDetail.getCheckPositionID());
            preparedStatement.setInt(3, checksDetail.getCategoryID());
            preparedStatement.setInt(4, checksDetail.getSubcategoryID());
            preparedStatement.setLong(5, checksDetail.getProductID());
            preparedStatement.setLong(6, checksDetail.getSumOfProducts());
            preparedStatement.setString(7, checksDetail.getPositionDetails());
            preparedStatement.setLong(8, checksDetail.getCheckDetailID());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute ChecksDetailsDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    @Override
    public List<ChecksDetails> getAll() throws DBException{
        List<ChecksDetails> checksDetailsList = new ArrayList<ChecksDetails>();
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from CHECKDETAILS");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ChecksDetails checksDetails = new ChecksDetails();
                checksDetails.setCheckDetailID(resultSet.getLong("checkDetailsID"));
                checksDetails.setCheckID(resultSet.getLong("CheckID"));
                checksDetails.setCheckPositionID(resultSet.getInt("CheckPositionID"));
                checksDetails.setCategoryID(resultSet.getInt("CategoryID"));
                checksDetails.setSubcategoryID(resultSet.getInt("SubcategoryID"));
                checksDetails.setProductID(resultSet.getLong("ProductID"));
                checksDetails.setSumOfProducts(resultSet.getLong("SumOfProducts"));
                checksDetails.setPositionDetails(resultSet.getString("PositionDetails"));

                checksDetailsList.add(checksDetails);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list ChecksDetailDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return checksDetailsList;
    }
}
