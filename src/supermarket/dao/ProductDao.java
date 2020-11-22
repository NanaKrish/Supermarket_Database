package supermarket.dao;

import supermarket.entity.Product;

public interface ProductDao {
    public Product getProduct(int id) throws Exception;
}
