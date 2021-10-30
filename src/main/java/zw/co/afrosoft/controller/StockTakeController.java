package zw.co.afrosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.domain.StockTake;
import zw.co.afrosoft.dto.ApiResponse;
import zw.co.afrosoft.dto.ResponseCode;
import zw.co.afrosoft.dto.request.StockTakeRequest;
import zw.co.afrosoft.dto.response.StockTakeResponse;
import zw.co.afrosoft.service.StockTakeService;

@RestController
@RequestMapping("api/v1/stocktake")
public class StockTakeController {
    private final StockTakeService stockTakeService;

    @Autowired
    public StockTakeController(StockTakeService stockTakeService) {
        this.stockTakeService = stockTakeService;
    }

    @PostMapping
    public ApiResponse<StockTakeResponse> create(@RequestBody StockTakeRequest stockTakeRequest){
        StockTakeResponse stockTake = stockTakeService.create(stockTakeRequest);
        return new ApiResponse<>(stockTake,"OK", ResponseCode.SUCCESS);
    }
}
