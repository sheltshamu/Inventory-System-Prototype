package zw.co.afrosoft.service;

import zw.co.afrosoft.domain.StockTakeDetail;
import zw.co.afrosoft.dto.request.StockTakeDetailRequest;

@FunctionalInterface
public interface StockTakeDetailService {
    StockTakeDetail create(StockTakeDetailRequest stockTakeDetailRequest);
}
