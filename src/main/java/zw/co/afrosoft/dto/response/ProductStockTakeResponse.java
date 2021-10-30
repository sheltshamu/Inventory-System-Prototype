package zw.co.afrosoft.dto.response;

import zw.co.afrosoft.domain.ProductStockTake;

public class ProductStockTakeResponse {
    private final ProductStockTake productStockTake;

    public ProductStockTakeResponse(ProductStockTake productStockTake) {
        this.productStockTake = productStockTake;
    }

    public ProductStockTake getProductStockTake() {
        return productStockTake;
    }
}
