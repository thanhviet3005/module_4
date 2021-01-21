package c0920g1.service;

import c0920g1.model.Product;

public interface ProductService extends Service<Product> {
    Product findByProductCode(String productCode);
}
