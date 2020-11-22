package supermarket.dao;

import supermarket.entity.Product;
import supermarket.helpers.JDBCHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProductDaoImpl implements ProductDao {
    @Override
    public Product getProduct(int pid) throws Exception {
        Connection connection = JDBCHelper.getConnection();
        Statement stmt = connection.createStatement();
//
        String que = "select * from PRODUCTS;";
        ResultSet rs = stmt.executeQuery(que);
        while (rs.next()) {
            System.out.println(rs.getString("EID"));
        }
        rs.close();
        stmt.close();
        connection.close();
        System.out.println(rs);
        return new Product();
    }

    private List<Product> resultSetToList(ResultSet rs) throws SQLException {
        List<Product> products;
        products = new ArrayList<>();
        while (rs.next()) {
            Product p = new Product();
            System.out.println(rs.getString("EID"));
            // TODO(sivagiri): Finish this method
        }
        return products;
    }
}
