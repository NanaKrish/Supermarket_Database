package supermarket.dao;

import supermarket.entity.Product;

public class DatabaseService {
    private static EmployeeDao employeeService;
    private static CustomerDao customerService;
    private static ProductDao productService;

    private static OrderDao orderService;

    static {
        employeeService = new EmployeeDaoImpl();
        customerService = new CustomerDaoImpl();
        productService = new ProductDaoImpl();
        orderService = new OrderDaoImpl();
    }

    public static EmployeeDao getEmployeeService() {
        return employeeService;
    }

    public static CustomerDao getCustomerService() {
        return customerService;
    }

    public static ProductDao getProductService() {
        return productService;
    }
    public static OrderDao getOrderService() {
        return orderService;
    }
}
