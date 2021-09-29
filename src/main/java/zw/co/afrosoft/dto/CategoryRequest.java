package zw.co.afrosoft.dto;

import lombok.Getter;
import lombok.Setter;
import zw.co.afrosoft.domain.Abbreviation;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CategoryRequest {
    @NotBlank
    private Long id;
    @NotBlank
    private Abbreviation abbreviation;
}
