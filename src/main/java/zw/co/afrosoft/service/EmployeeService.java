package zw.co.afrosoft.service;

import org.springframework.http.ResponseEntity;
import zw.co.afrosoft.domain.Employee;
import zw.co.afrosoft.dto.UpdateEmployeeRequest;
import zw.co.afrosoft.dto.request.EmployeeRequest;
import zw.co.afrosoft.dto.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    EmployeeResponse create(EmployeeRequest employeeRequest);

    EmployeeResponse delete(Long id);

    EmployeeResponse update(UpdateEmployeeRequest updateEmployeeRequest);

    List<Employee> listAll();

    EmployeeResponse getEmployeeById(Long id);
}
