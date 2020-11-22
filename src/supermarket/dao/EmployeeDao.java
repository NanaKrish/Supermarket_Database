package supermarket.dao;

import supermarket.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EmployeeDao {
    public Employee getEmployee(int id) throws SQLException;
    public Employee getEmployee(int id, String password) throws SQLException;
    public boolean updateEmployee(Employee employee) throws SQLException;
    ResultSet getAllEmployees() throws SQLException;
}
