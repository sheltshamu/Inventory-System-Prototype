package zw.co.afrosoft.service;

import zw.co.afrosoft.domain.Product;
import zw.co.afrosoft.dto.UpdateProductRequest;
import zw.co.afrosoft.dto.request.ProductRequest;
import zw.co.afrosoft.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {

    Product create(ProductRequest productRequest);

    List<Product> listAll();

    Product update(UpdateProductRequest updateProductRequest);
}
