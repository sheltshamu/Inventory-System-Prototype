package zw.co.afrosoft.service;

import org.springframework.stereotype.Service;
import zw.co.afrosoft.domain.Product;
import zw.co.afrosoft.domain.StockTakeDetail;
import zw.co.afrosoft.dto.request.StockTakeDetailRequest;
import zw.co.afrosoft.persistence.ProductRepository;
import zw.co.afrosoft.persistence.StockTakeDetailRepository;
import zw.co.afrosoft.persistence.StockTakeRepository;

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
        Product product =
        StockTakeDetail stockTakeDetail =
    }
}
