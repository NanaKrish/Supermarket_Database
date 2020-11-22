package supermarket.dao;

import supermarket.entity.Product;

public class DatabaseService {
    private static EmployeeDao employeeService;
    private static ProductDao productService;

    static {
        employeeService = new EmployeeDaoImpl();
        productService = new ProductDaoImpl();
    }

    public static EmployeeDao getEmployeeService() {
        return employeeService;
    }

    public static ProductDao getProductService() {
        return productService;
    }
}
