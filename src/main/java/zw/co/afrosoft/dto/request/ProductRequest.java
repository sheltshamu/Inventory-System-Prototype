package zw.co.afrosoft.dto.request;

import lombok.*;
import zw.co.afrosoft.domain.Category;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private String name;
    private String description;
    private double purchasePrice;
    private double sellingPrice;
    private int quantityOnHand;
    private Long  categoryId;


}
