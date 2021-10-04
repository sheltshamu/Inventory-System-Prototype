package zw.co.afrosoft.service;

import zw.co.afrosoft.domain.StockTake;
import zw.co.afrosoft.dto.request.StockTakeRequest;
@FunctionalInterface
public interface StockTakeService {
    StockTake create(StockTakeRequest stockTakeRequest);
}
