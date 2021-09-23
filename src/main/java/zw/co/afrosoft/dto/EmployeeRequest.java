package zw.co.afrosoft.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zw.co.afrosoft.domain.Employee;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class EmployeeRequest {
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String email;

    public EmployeeRequest(Employee employee){
        this.firstname=employee.getFirstname();
        this.lastname=employee.getLastname();
        this.dateOfBirth=employee.getDateOfBirth();
        this.phoneNumber=employee.getPhoneNumber();
        this.email=employee.getEmail();
    }

}
