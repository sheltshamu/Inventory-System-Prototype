package zw.co.afrosoft.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import zw.co.afrosoft.domain.Employee;

import java.time.LocalDate;
@Getter
@Setter
@ToString
public class EmployeeResponse {

    private final Employee employee;

    public EmployeeResponse(Employee employee) {
        this.employee = employee;
    }

}
