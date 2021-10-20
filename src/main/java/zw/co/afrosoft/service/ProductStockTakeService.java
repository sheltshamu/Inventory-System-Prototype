package zw.co.afrosoft.service;

import org.springframework.http.ResponseEntity;
import zw.co.afrosoft.dto.request.ProductStockTakeRequest;

public interface ProductStockTakeService {
    ResponseEntity create(ProductStockTakeRequest productStockTakeRequest);
}
