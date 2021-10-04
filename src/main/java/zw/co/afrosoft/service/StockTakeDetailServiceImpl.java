package zw.co.afrosoft.service;

import org.springframework.stereotype.Service;
import zw.co.afrosoft.domain.Product;
import zw.co.afrosoft.domain.StockTake;
import zw.co.afrosoft.domain.StockTakeDetail;
import zw.co.afrosoft.dto.request.StockTakeDetailRequest;
import zw.co.afrosoft.persistence.ProductRepository;
import zw.co.afrosoft.persistence.StockTakeDetailRepository;
import zw.co.afrosoft.persistence.StockTakeRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class StockTakeDetailServiceImpl implements StockTakeDetailService{
    private final StockTakeDetailRepository stockTakeDetailRepository;
    private final ProductRepository productRepository;
    private final StockTakeRepository stockTakeRepository;

    public StockTakeDetailServiceImpl(StockTakeDetailRepository stockTakeDetailRepository, ProductRepository productRepository, StockTakeRepository stockTakeRepository) {
        this.stockTakeDetailRepository = stockTakeDetailRepository;
        this.productRepository = productRepository;
        this.stockTakeRepository = stockTakeRepository;
    }

    @Override
    public StockTakeDetail create(StockTakeDetailRequest stockTakeDetailRequest) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Product product = productRepository.findById(stockTakeDetailRequest.getProductId()).get();
        Optional<StockTake> stockTake = stockTakeRepository.findById(stockTakeDetailRequest.getStockTakeId());
        StockTakeDetail stockTakeDetail = new StockTakeDetail();
        stockTakeDetail.setProduct(product);
        stockTakeDetail.setStockTake(stockTake.get());
        stockTakeDetail.setQtyCounted(stockTakeDetailRequest.getQtyCounted());
        stockTakeDetail.setDateCreated(currentDateTime);
        stockTakeDetail.setDateModified(currentDateTime);
        return stockTakeDetail;
    }

    private void validateRequest(StockTakeDetailRequest stockTakeDetailRequest){

    }
}
