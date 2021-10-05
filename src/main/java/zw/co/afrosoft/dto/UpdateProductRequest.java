package zw.co.afrosoft.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
    private Long id;
    private String name;
    private String description;
    private double purchasePrice;
    private double sellingPrice;
    private int quantityOnHand;
}
