package zw.co.afrosoft.dto.response;

import lombok.Getter;
import zw.co.afrosoft.domain.StockTakeDetail;
@Getter
public class StockTakeDetailResponse {
    private final StockTakeDetail stockTakeDetail;

    public StockTakeDetailResponse(StockTakeDetail stockTakeDetail) {
        this.stockTakeDetail = stockTakeDetail;
    }


}
