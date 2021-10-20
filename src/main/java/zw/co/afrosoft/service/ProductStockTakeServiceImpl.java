package zw.co.afrosoft.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.domain.Product;
import zw.co.afrosoft.domain.ProductStockTake;
import zw.co.afrosoft.domain.StockTake;
import zw.co.afrosoft.dto.request.ProductStockTakeRequest;
import zw.co.afrosoft.exception.NoProductFoundException;
import zw.co.afrosoft.exception.NoRecordExistException;
import zw.co.afrosoft.persistence.ProductRepository;
import zw.co.afrosoft.persistence.ProductStockTakeRepository;
import zw.co.afrosoft.persistence.StockTakeRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProductStockTakeServiceImpl implements ProductStockTakeService{

    private final ProductStockTakeRepository productStockTakeRepository;
    private final ProductRepository productRepository;
    private final StockTakeRepository stockTakeRepository;

    public ProductStockTakeServiceImpl(ProductStockTakeRepository productStockTakeRepository, ProductRepository productRepository, StockTakeRepository stockTakeRepository) {
        this.productStockTakeRepository = productStockTakeRepository;
        this.productRepository = productRepository;
        this.stockTakeRepository = stockTakeRepository;
    }

    @Override
    public ResponseEntity create(ProductStockTakeRequest productStockTakeRequest) {
        LocalDateTime auditTime =LocalDateTime.now();
        ProductStockTake productStockTake = new ProductStockTake();
        productStockTake.setQtyCounted(productStockTakeRequest.getQtyCounted());
        productStockTake.setDateCreated(auditTime);
        productStockTake.setDateModified(auditTime);

        Optional<Product> product = productRepository.findById(productStockTakeRequest.getProductId());
        if (product.isPresent()) {
            productStockTake.setProduct(product.get());
        }
        Optional<StockTake> stockTake = stockTakeRepository.findById(productStockTakeRequest.getStockTakeId());
        if(stockTake.isPresent()){
            productStockTake.setStockTake(stockTake.get());
        }
        productStockTakeRepository.save(productStockTake);
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }
}
