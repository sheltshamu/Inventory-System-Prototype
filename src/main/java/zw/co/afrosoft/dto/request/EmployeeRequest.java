package zw.co.afrosoft.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeRequest {
    @NotNull
    @NotBlank(message = "firstname is required")
    private String firstname;
    @NotNull
    @NotBlank(message = "lastname is required")
    private String lastname;
    @NotNull
    @NotBlank(message = "date of birth is required")
    private LocalDate dateOfBirth;
    @NotNull
    @NotBlank(message = "firstname is required")
    private String phoneNumber;

    private String email;
}
