package zw.co.afrosoft.dto;

import lombok.Getter;
import lombok.Setter;
import zw.co.afrosoft.domain.Employee;

import java.time.LocalDate;
@Getter
@Setter
public class EmployeeResponse {
    private final Employee employee;

    public EmployeeResponse(Employee employee) {
        this.employee = employee;
    }

}
