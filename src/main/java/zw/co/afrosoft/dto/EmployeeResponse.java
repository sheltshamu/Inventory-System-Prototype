package zw.co.afrosoft.dto;

import lombok.Getter;
import lombok.Setter;
import zw.co.afrosoft.domain.Employee;

import java.time.LocalDate;
@Getter
@Setter
public class EmployeeResponse {
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String email;

    public EmployeeResponse(Employee employee){
        this.firstname=employee.getFirstname();
        this.lastname=employee.getLastname();
        this.dateOfBirth=employee.getDateOfBirth();
        this.dateOfBirth=employee.getDateOfBirth();
        this.email=employee.getEmail();
    }
}
