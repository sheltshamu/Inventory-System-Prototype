package zw.co.afrosoft.dto;

import lombok.Getter;
import lombok.Setter;
import zw.co.afrosoft.domain.Category;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ProductRequest {
    @NotBlank
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private double purchasePrice;
    @NotBlank
    private double sellingPrice;
    @NotBlank
    private int quantityOnHand;
    @NotBlank
    private Category category;

}
