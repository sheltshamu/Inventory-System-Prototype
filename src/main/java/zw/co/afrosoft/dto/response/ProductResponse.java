package zw.co.afrosoft.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import zw.co.afrosoft.domain.Category;
import zw.co.afrosoft.domain.Product;

@Getter
@Setter
@ToString
public class ProductResponse {
   private final Product product;

    public ProductResponse(Product product) {
        this.product = product;
    }
}
