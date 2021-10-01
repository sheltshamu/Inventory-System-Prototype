package zw.co.afrosoft.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import zw.co.afrosoft.domain.Category;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class CategoryResponse {
    private final Category category;

    public CategoryResponse(Category category) {
        this.category = category;
    }
}
