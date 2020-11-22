package supermarket.dao;

import supermarket.entity.Customer;
import supermarket.entity.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    Order getOrder(int id) throws SQLException;
    List<Order> getOrders() throws SQLException;
    List<Order> getOrdersForCustomer(int customerId) throws SQLException;
    List<Order> getOrdersForCustomer(Customer customer) throws SQLException;

    Order hydrateOrder(Order order) throws SQLException;

    List<Order> hydrateOrders(List<Order> orders) throws SQLException;
    ResultSet getOrdersRaw() throws SQLException;
}
