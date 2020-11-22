package supermarket.dao;

import supermarket.entity.Customer;

import java.sql.SQLException;

public interface CustomerDao {
    public Customer getCustomer(int id) throws SQLException;
    public Customer getCustomer(int id, String password) throws SQLException;
    public Customer getCustomer(String mobileNo, String password) throws SQLException;
    public boolean updateCustomer(Customer customer) throws SQLException;
    public Customer addCustomer(Customer customer) throws SQLException;
    public Customer addCustomer(String name, String password, String mobileNo, String mailId) throws SQLException;
}
