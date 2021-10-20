package zw.co.afrosoft.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeRequest implements Serializable {
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String email;
}
