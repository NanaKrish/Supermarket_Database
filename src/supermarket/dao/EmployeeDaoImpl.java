package supermarket.dao;

import supermarket.entity.Employee;
import supermarket.entity.Product;
import supermarket.helpers.JDBCHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public Employee getEmployee(int id) throws SQLException {
        Connection connection = JDBCHelper.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE EID=?");
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        return getEmployeeFromResult(rs);
    }

    @Override
    public Employee getEmployee(int id, String password) throws SQLException {
        Connection connection = JDBCHelper.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE EID=? AND PASSWORD=?");
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, password);
        ResultSet rs = preparedStatement.executeQuery();
        return getEmployeeFromResult(rs);
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        return false;
    }

    private Employee getEmployeeFromResult(ResultSet rs) throws SQLException {
        Employee e = null;
        if (rs.next()) {
            e = new Employee();
            e.setId(rs.getInt("EID"));
            e.setEmployeeName(rs.getString("ENAME"));
            e.setMailId(rs.getString("MAILID"));
            e.setMobileNo(rs.getString("MOBILENO"));
        }
        return e;
    }
    private List<Employee> resultSetToList(ResultSet rs) throws SQLException {
        List<Employee> employees;
        employees = new ArrayList<>();
        while (rs.next()) {
            Employee e = getEmployeeFromResult(rs);
            employees.add(e);
        }
        return employees;
    }

}
