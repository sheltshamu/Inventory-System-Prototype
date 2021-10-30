package zw.co.afrosoft.service;

import org.springframework.http.ResponseEntity;
import zw.co.afrosoft.domain.StockTake;
import zw.co.afrosoft.dto.request.StockTakeRequest;
import zw.co.afrosoft.dto.response.StockTakeResponse;

import java.util.List;

public interface StockTakeService {
    StockTakeResponse create(StockTakeRequest stockTakeRequest);
    List<StockTake> getAll();
}
