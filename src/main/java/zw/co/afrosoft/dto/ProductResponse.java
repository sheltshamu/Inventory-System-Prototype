package zw.co.afrosoft.dto;

import lombok.Getter;
import lombok.Setter;
import zw.co.afrosoft.domain.Category;
import zw.co.afrosoft.domain.Product;

@Getter
@Setter
public class ProductResponse {
   private final Product product;

    public ProductResponse(Product product) {
        this.product = product;
    }
}
