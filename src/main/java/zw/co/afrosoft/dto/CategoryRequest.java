package zw.co.afrosoft.dto;

import lombok.Getter;
import lombok.Setter;
import zw.co.afrosoft.domain.Abbreviation;

@Getter
@Setter
public class CategoryRequest {
    private Long id;
    private Abbreviation abbreviation;
}
