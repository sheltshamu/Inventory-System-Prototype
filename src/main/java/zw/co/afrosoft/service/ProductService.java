package zw.co.afrosoft.service;

import zw.co.afrosoft.domain.Product;
import zw.co.afrosoft.dto.request.ProductRequest;

import java.util.List;

public interface ProductService {

    Product create(ProductRequest productRequest);

    List<Product> listAll();
}
