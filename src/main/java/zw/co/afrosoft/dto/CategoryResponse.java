package zw.co.afrosoft.dto;

import lombok.Getter;
import lombok.Setter;
import zw.co.afrosoft.domain.Abbreviation;
import zw.co.afrosoft.domain.Category;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CategoryResponse {
    private Long id;
    @NotBlank
    private Abbreviation abbreviation;

    public CategoryResponse(Category category){
        this.abbreviation=category.getAbbreviation();
    }
}
