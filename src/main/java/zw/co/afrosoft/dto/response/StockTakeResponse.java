package zw.co.afrosoft.dto.response;

import lombok.Getter;
import lombok.Setter;
import zw.co.afrosoft.domain.StockTake;

import java.io.Serializable;

@Getter
@Setter
public class StockTakeResponse implements Serializable {
    private final StockTake stockTake;

    public StockTakeResponse(StockTake stockTake) {
        this.stockTake = stockTake;
    }
}
