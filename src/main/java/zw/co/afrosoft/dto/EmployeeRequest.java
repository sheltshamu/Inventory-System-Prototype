package zw.co.afrosoft.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zw.co.afrosoft.domain.Employee;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class EmployeeRequest {
    @NotBlank
    private Long id;
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
    @NotBlank
    private LocalDate dateOfBirth;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String email;

    public EmployeeRequest(Employee employee){
        this.firstname=employee.getFirstname();
        this.lastname=employee.getLastname();
        this.dateOfBirth=employee.getDateOfBirth();
        this.phoneNumber=employee.getPhoneNumber();
        this.email=employee.getEmail();
    }

}
