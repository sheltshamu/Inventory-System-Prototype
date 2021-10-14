package zw.co.afrosoft.dto.response;

import lombok.Getter;
import zw.co.afrosoft.domain.ProductStockTake;
@Getter
public class StockTakeDetailResponse {
    private final ProductStockTake productStockTake;

    public StockTakeDetailResponse(ProductStockTake productStockTake) {
        this.productStockTake = productStockTake;
    }


}
