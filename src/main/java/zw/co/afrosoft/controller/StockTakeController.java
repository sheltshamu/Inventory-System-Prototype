package zw.co.afrosoft.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.afrosoft.domain.StockTake;
import zw.co.afrosoft.dto.request.StockTakeRequest;
import zw.co.afrosoft.dto.response.StockTakeResponse;
import zw.co.afrosoft.service.StockTakeService;

@RestController
@RequestMapping("/api/v1/stocktake")
public class StockTakeController {

    private final StockTakeService stockTakeService;

    public StockTakeController(StockTakeService stockTakeService) {
        this.stockTakeService = stockTakeService;
    }

    @PostMapping
    public StockTakeResponse save(StockTakeRequest stockTakeRequest){
        StockTake stockTake = stockTakeService.create(stockTakeRequest);
        return new StockTakeResponse(stockTake);
    }
}
