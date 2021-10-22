package zw.co.afrosoft.service;

import org.springframework.http.ResponseEntity;
import zw.co.afrosoft.domain.StockTake;
import zw.co.afrosoft.dto.request.StockTakeRequest;

import java.util.List;

public interface StockTakeService {
    ResponseEntity create(StockTakeRequest stockTakeRequest);
    ResponseEntity getAll();
}
