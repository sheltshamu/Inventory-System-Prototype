package zw.co.afrosoft.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private LocalDateTime dateCreated;
    @NotNull
    private LocalDateTime dateModified;
}
