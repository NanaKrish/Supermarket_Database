package supermarket.dao;

import supermarket.entity.Customer;
import supermarket.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
    public Customer getCustomer(int id) throws SQLException;
    public Customer getCustomer(int id, String password) throws SQLException;

    boolean addProductToCart(Customer c, Product p, int quantity) throws SQLException;

    boolean addProductToCart(int c, int p, int quantity) throws SQLException;

    List<Product> productsInCart(int customerId) throws SQLException;

    public Customer getCustomer(String mobileNo, String password) throws SQLException;
    public boolean updateCustomer(Customer customer) throws SQLException;
    public Customer addCustomer(Customer customer) throws SQLException;
    public Customer addCustomer(String name, String password, String mobileNo, String mailId) throws SQLException;
    List<Product> productsInCart(Customer c) throws SQLException;
}
