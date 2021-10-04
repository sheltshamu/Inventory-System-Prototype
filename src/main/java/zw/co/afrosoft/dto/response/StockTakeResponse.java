package zw.co.afrosoft.dto.response;

import lombok.Getter;
import lombok.Setter;
import zw.co.afrosoft.domain.StockTake;
@Getter
@Setter
public class StockTakeResponse {
    private final StockTake stockTake;

    public StockTakeResponse(StockTake stockTake) {
        this.stockTake = stockTake;
    }
}
