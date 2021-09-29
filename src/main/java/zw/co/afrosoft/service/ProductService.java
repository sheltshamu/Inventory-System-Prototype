package zw.co.afrosoft.service;

import org.springframework.stereotype.Service;
import zw.co.afrosoft.domain.Product;
import zw.co.afrosoft.dto.ProductRequest;

import java.util.List;

@Service
public interface ProductService {

    Product create(ProductRequest productRequest);

    List<Product> listAll();
}
