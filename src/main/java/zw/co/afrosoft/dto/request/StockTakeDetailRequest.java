package zw.co.afrosoft.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StockTakeDetailRequest {
    @NotNull(message = "productId is required")
    private Long productId;
    @NotNull(message = "stockTakeId is required")
    private Long stockTakeId;
    @NotBlank(message = "quantity counted is required")
    private int qtyCounted;
}
