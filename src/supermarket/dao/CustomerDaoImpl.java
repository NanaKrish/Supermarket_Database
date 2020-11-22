package supermarket.dao;

import supermarket.entity.Customer;
import supermarket.helpers.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public Customer getCustomer(int id) throws SQLException {
        Connection connection = JDBCHelper.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM CUSTOMER WHERE CID=?");
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        return getCustomerFromResult(rs);
    }

    @Override
    public Customer getCustomer(int id, String password) throws SQLException {
        Connection connection = JDBCHelper.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM CUSTOMER WHERE CID=? AND PASSWORD=?");
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, password);
        ResultSet rs = preparedStatement.executeQuery();
        return getCustomerFromResult(rs);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return false;
    }

    @Override
    public Customer addCustomer(Customer customer) throws SQLException {
        return null;
    }

    @Override
    public Customer addCustomer(String name, String password, String mobileNo, String mailId) throws SQLException {
        Connection con = JDBCHelper.getConnection();
        PreparedStatement preparedStatement= con.prepareStatement("insert into CUSTOMER values (null, ?, ?, ?, ?)");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, mobileNo);
        preparedStatement.setString(4, mailId);
        preparedStatement.executeUpdate();

        String st = "SELECT LAST_INSERT_ID()";
        ResultSet rs = preparedStatement.executeQuery(st);
        int cid = -1;
        while(rs.next())
        {
            cid = rs.getInt(1);
        }
        if(cid!=-1) {
            return new Customer(cid, name, mobileNo, mailId);
        }
        return  null;
    }

    @Override
    public Customer getCustomer(String mobileNo, String password) throws SQLException {
        Connection connection = JDBCHelper.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM CUSTOMER WHERE MOBILENO=? AND PASSWORD=?");
        preparedStatement.setString(1, mobileNo);
        preparedStatement.setString(2, password);
        ResultSet rs = preparedStatement.executeQuery();
        return getCustomerFromResult(rs);
    }

    private Customer getCustomerFromResult(ResultSet rs) throws SQLException {
        Customer c = null;
        if (rs.next()) {
            c = new Customer();
            c.setId(rs.getInt("CID"));
            c.setUserName(rs.getString("USERNAME"));
            c.setMailId(rs.getString("MAILID"));
            c.setMobileNo(rs.getString("MOBILENO"));
        }
        return c;
    }

    private List<Customer> resultSetToList(ResultSet rs) throws SQLException {
        List<Customer> customers;
        customers= new ArrayList<>();
        while (rs.next()) {
            Customer c = getCustomerFromResult(rs);
            customers.add(c);
        }
        return customers;
    }

}
