package supermarket.dao;

import com.sun.org.apache.xpath.internal.operations.Or;
import supermarket.entity.Customer;
import supermarket.entity.Order;
import supermarket.entity.Product;
import supermarket.helpers.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public Order getOrder(int id) throws SQLException {
        Connection connection = JDBCHelper.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM ORDERS WHERE OID=?");
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        return getOrderFromResult(rs);
    }
    private Order getOrderFromResult(ResultSet rs) throws SQLException {
        Order o = null;
        if (rs.next()) {
            o = new Order();
            o.setOrderId(rs.getInt("OID"));
            o.setCustomerId(rs.getInt("CID"));
            o.setOrderDate(rs.getDate("ORDERDATE"));
            o.setOrderStatus(rs.getString("ORDERSTATUS"));
        }
        return o;
    }

    @Override
    public List<Order> getOrders() throws SQLException {
        Connection connection = JDBCHelper.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM ORDERS");
        ResultSet rs = preparedStatement.executeQuery();
        return resultSetToList(rs);
    }

    @Override
    public List<Order> getOrdersForCustomer(int customerId) throws SQLException {
        Connection connection = JDBCHelper.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM ORDERS WHERE CID=?");
        preparedStatement.setInt(1, customerId);
        ResultSet rs = preparedStatement.executeQuery();
        return resultSetToList(rs);
    }

    @Override
    public List<Order> getOrdersForCustomer(Customer customer) throws SQLException {
        return getOrdersForCustomer(customer.getId());
    }

    @Override
    public Order hydrateOrder(Order order) throws SQLException {
        Connection connection = JDBCHelper.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM ORDERS JOIN PRODUCTS_ORDERED PO on ORDERS.OID = PO.OID JOIN PRODUCTS P ON P.PID = PO.PID WHERE OID=?");
        preparedStatement.setInt(1, order.getOrderId());
        ResultSet rs = preparedStatement.executeQuery();
        List<Product> products;
        products = new ArrayList<>();
        while (rs.next()) {
            Product p= new Product();
            p.setId(rs.getInt("PID"));
            p.setPrice(rs.getInt("PRICE"));
            p.setProductName(rs.getString("PNAME"));
            p.setQuantity(rs.getInt("QUANTITY"));
            products.add(p);
        }
        order.setProducts(products);
        return order;
    }

    @Override
    public List<Order> hydrateOrders(List<Order> orders) throws SQLException {
        for (Order order:
             orders) {
            hydrateOrder(order);
        }
        return orders;
    }

    private List<Order> resultSetToList(ResultSet rs) throws SQLException {
        List<Order> orders;
        orders = new ArrayList<>();
        while (rs.next()) {
            Order o= getOrderFromResult(rs);
            orders.add(o);
        }
        return orders;
    }

    @Override
    public ResultSet  getOrdersRaw() throws SQLException {
        Connection connection = JDBCHelper.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM ORDERS");
        ResultSet rs = preparedStatement.executeQuery();
        return rs;
    }

}
