package zw.co.afrosoft.dto.request;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import zw.co.afrosoft.domain.AuditInformation;
import zw.co.afrosoft.domain.Employee;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeRequest {
    @NotNull
    private String firstname;
   @NotNull
    private String lastname;
   @NotNull
    private LocalDate dateOfBirth;
   @NotNull
    private String phoneNumber;
   @NotNull
    private String email;
}
