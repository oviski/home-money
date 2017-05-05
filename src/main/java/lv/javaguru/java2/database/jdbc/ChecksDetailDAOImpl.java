package lv.javaguru.java2.database.jdbc;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import lv.javaguru.java2.database.ChecksDetailDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.checks.Check;
import lv.javaguru.java2.domain.checksDetail.ChecksDetail;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 02.05.2017.
 */
public class ChecksDetailDAOImpl extends DAOImpl implements ChecksDetailDAO {
    @Override
    public ChecksDetail save(ChecksDetail checksDetail) throws DBException {
        Connection connection = null;

        try {
            connection = (Connection) getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("insert into CHECKSDETAIL values (default, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, checksDetail.getCheckID());
            preparedStatement.setLong(2, checksDetail.getCheckPositionID());
            preparedStatement.setInt(3, checksDetail.getCategoryID());
            preparedStatement.setInt(4, checksDetail.getSubcategoryID());
            preparedStatement.setLong(5, checksDetail.getProductID());
            preparedStatement.setLong(6, checksDetail.getSumOfProducts());
            preparedStatement.setString(7, checksDetail.getPositionDetails());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();

            if (rs.next()){
                checksDetail.setCheckDetailsID(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute ChecksDetailDAOImpl.save()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return checksDetail;
    }

    @Override
    public Optional<ChecksDetail> getById(Long id) throws DBException{
        Connection connection = null;

        try {
            connection = (Connection) getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("select * from CHECKSDETAILS where ChecksDetailsID = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            ChecksDetail checksDetail = null;
            if (resultSet.next()) {
                checksDetail = new ChecksDetail();
                checksDetail.setCheckDetailsID(resultSet.getLong("checksDetailsID"));
                checksDetail.setCheckID(resultSet.getLong("checkID"));
                checksDetail.setCheckPositionID(resultSet.getLong("checkPositionID"));
                checksDetail.setCategoryID(resultSet.getInt("categoryID"));
                checksDetail.setSubcategoryID(resultSet.getInt("subcategoryID"));
                checksDetail.setProductID(resultSet.getLong("productID"));
                checksDetail.setSumOfProducts(resultSet.getLong("sumOfProducts"));
                checksDetail.setPositionDetails(resultSet.getString("positionDetails"));
            }
            return Optional.ofNullable(checksDetail);
        } catch (Throwable e) {
            System.out.println("Exception while execute ChecksDetailDAOImpl.getById()");
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
            PreparedStatement preparedStatement = (PreparedStatement) connection
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
    public void update(ChecksDetail checksDetail) {
        if (checksDetail == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = (Connection) getConnection();
            java.sql.PreparedStatement preparedStatement = connection
                    .prepareStatement("update CHECKSDETAIL set CheckID = ?, CheckPositionID = ?, " +
                            "CategoryID = ?, SubcategoryID = ?, ProductID = ?, SumOfProduct = ?, positionDetails = ?, " +
                            "where ChecksDetailsID = ?");
            preparedStatement.setLong(1, checksDetail.getCheckID());
            preparedStatement.setLong(2, checksDetail.getCheckPositionID());
            preparedStatement.setInt(3, checksDetail.getCategoryID());
            preparedStatement.setInt(4, checksDetail.getSubcategoryID());
            preparedStatement.setLong(5, checksDetail.getProductID());
            preparedStatement.setLong(6, checksDetail.getSumOfProducts());
            preparedStatement.setString(7, checksDetail.getPositionDetails());
            preparedStatement.setLong(8, checksDetail.getCheckDetailsID());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute ChecksDetailDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    @Override
    public List<ChecksDetail> getAll() throws DBException{
        List<ChecksDetail> checksDetails = new ArrayList<ChecksDetail>();
        Connection connection = null;

        try {
            connection = (Connection) getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement("select * from CHECKDETAILS");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ChecksDetail checksDetail = new ChecksDetail();
                checksDetail.setCheckDetailsID(resultSet.getLong("checkDetailsID"));
                checksDetail.setCheckID(resultSet.getLong("CheckID"));
                checksDetail.setCheckPositionID(resultSet.getLong("CheckPositionID"));
                checksDetail.setCategoryID(resultSet.getInt("CategoryID"));
                checksDetail.setSubcategoryID(resultSet.getInt("SubcategoryID"));
                checksDetail.setProductID(resultSet.getLong("ProductID"));
                checksDetail.setSumOfProducts(resultSet.getLong("SumOfProducts"));
                checksDetail.setPositionDetails(resultSet.getString("PositionDetails"));

                checksDetails.add(checksDetail);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list ChecksDetailDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return checksDetails;
    }
}
