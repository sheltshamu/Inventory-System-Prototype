package zw.co.afrosoft.service;

import org.springframework.http.ResponseEntity;
import zw.co.afrosoft.domain.Employee;
import zw.co.afrosoft.dto.UpdateEmployeeRequest;
import zw.co.afrosoft.dto.request.EmployeeRequest;

import java.util.List;

public interface EmployeeService {

    ResponseEntity create(EmployeeRequest employeeRequest);

    Object delete(Long id);

    ResponseEntity update(UpdateEmployeeRequest updateEmployeeRequest);

    List<Employee> listAll();

    ResponseEntity getEmployeeById(Long id);
}
