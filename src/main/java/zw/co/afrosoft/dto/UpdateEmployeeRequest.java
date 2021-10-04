package zw.co.afrosoft.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {
    @NotNull(message = "id must not be null")
    @NotBlank(message = "employeeId is required")
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String email;
}
