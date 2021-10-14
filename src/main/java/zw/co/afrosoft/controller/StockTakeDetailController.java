package zw.co.afrosoft.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.afrosoft.domain.StockTakeDetail;
import zw.co.afrosoft.dto.request.StockTakeDetailRequest;
import zw.co.afrosoft.dto.response.StockTakeDetailResponse;
import zw.co.afrosoft.service.StockTakeDetailService;

@RestController
@RequestMapping("/api/v1/stock-take-detail")
public class StockTakeDetailController {

    private final StockTakeDetailService stockTakeDetailService;

    public StockTakeDetailController(StockTakeDetailService stockTakeDetailService) {
        this.stockTakeDetailService = stockTakeDetailService;
    }

    @GetMapping
    public StockTakeDetailResponse create(@RequestBody StockTakeDetailRequest stockTakeDetailRequest){
        StockTakeDetail stockTakeDetail = stockTakeDetailService.create(stockTakeDetailRequest);
        return new StockTakeDetailResponse(stockTakeDetail);
    }

}
