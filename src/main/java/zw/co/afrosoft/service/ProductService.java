package zw.co.afrosoft.service;

import org.springframework.http.ResponseEntity;
import zw.co.afrosoft.domain.Product;
import zw.co.afrosoft.dto.UpdateProductRequest;
import zw.co.afrosoft.dto.request.ProductRequest;
import zw.co.afrosoft.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse create(ProductRequest productRequest);

    List<Product> listAll();

    ProductResponse update(UpdateProductRequest updateProductRequest);
}
