package zw.co.afrosoft.service;

import zw.co.afrosoft.domain.Employee;
import zw.co.afrosoft.dto.UpdateEmployeeRequest;
import zw.co.afrosoft.dto.request.EmployeeRequest;

import java.util.List;

public interface EmployeeService {

    Employee create(EmployeeRequest employeeRequest);

    void delete(Long id);

    Employee update(UpdateEmployeeRequest updateEmployeeRequest);

    List<Employee> listAll();

    Employee getEmployeeById(Long id);
}
