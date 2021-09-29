package zw.co.afrosoft.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.domain.Employee;
import zw.co.afrosoft.dto.EmployeeRequest;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {

    Employee create(EmployeeRequest employeeRequest);

    void delete(Long id);

    Employee update(EmployeeRequest employeeRequest);

    List<Employee> listAll();

    Employee getEmployeeById(Long id);
}
