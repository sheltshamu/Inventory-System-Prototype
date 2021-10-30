package zw.co.afrosoft.service;

import org.springframework.http.ResponseEntity;
import zw.co.afrosoft.dto.request.ProductStockTakeRequest;
import zw.co.afrosoft.dto.response.ProductStockTakeResponse;

public interface ProductStockTakeService {
    ProductStockTakeResponse create(ProductStockTakeRequest productStockTakeRequest);
}
