package zw.co.afrosoft.service;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.domain.Product;
import zw.co.afrosoft.domain.ProductStockTake;
import zw.co.afrosoft.domain.StockTake;
import zw.co.afrosoft.dto.request.ProductStockTakeRequest;
import zw.co.afrosoft.dto.response.ProductStockTakeResponse;
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
    public ProductStockTakeResponse create(ProductStockTakeRequest productStockTakeRequest) {
        LocalDateTime auditTime =LocalDateTime.now();
        ProductStockTake productStockTake = new ProductStockTake();
        productStockTake.setQtyCounted(productStockTakeRequest.getQtyCounted());
        productStockTake.setDateCreated(auditTime);
        productStockTake.setDateModified(auditTime);

        Optional<Product> product = productRepository.findById(productStockTakeRequest.getProductId());
        if (!product.isPresent())
            throw new RuntimeException("Product not found");

        Optional<StockTake> stockTake = stockTakeRepository.findById(productStockTakeRequest.getStockTakeId());
        if(!stockTake.isPresent())
            throw new RuntimeException("Stock not found");
        productStockTake.setProduct(product.get());
        productStockTake.setStockTake(stockTake.get());
        productStockTakeRepository.save(productStockTake);

        return new ProductStockTakeResponse(productStockTake);
    }
}
