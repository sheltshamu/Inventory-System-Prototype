package zw.co.afrosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import zw.co.afrosoft.domain.Employee;
import zw.co.afrosoft.dto.UpdateEmployeeRequest;
import zw.co.afrosoft.dto.request.EmployeeRequest;
import zw.co.afrosoft.persistence.EmployeeRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ResponseEntity create(EmployeeRequest employeeRequest) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Employee employee = new Employee();
        employee.setDateCreated(currentDateTime);
        employee.setDateModified(currentDateTime);
        employee.setFirstname(employeeRequest.getFirstname());
        employee.setLastname(employeeRequest.getLastname());
        employee.setDateOfBirth(employeeRequest.getDateOfBirth());
        employee.setPhoneNumber(employeeRequest.getPhoneNumber());
        employee.setEmail(employeeRequest.getEmail());
        employeeRepository.save(employee);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @Override
    public ResponseEntity<Object> delete(Long id) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (!existingEmployee.isPresent())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee does not exist");
       // return employeeRepository.delete(existingEmployee.get());
        return null;
    }


    @Override
    public ResponseEntity update(UpdateEmployeeRequest updateEmployeeRequest) {
        LocalDateTime currentDateTime =LocalDateTime.now();
       Optional<Employee> existingEmployee = employeeRepository.findById(updateEmployeeRequest.getId());
       if (!existingEmployee.isPresent())
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
      Employee employee = existingEmployee.get();
      employee.setEmail(updateEmployeeRequest.getEmail());
      employee.setPhoneNumber(updateEmployeeRequest.getPhoneNumber());
      employee.setFirstname(updateEmployeeRequest.getFirstname());
      employee.setLastname(updateEmployeeRequest.getLastname());
      employee.setDateOfBirth(updateEmployeeRequest.getDateOfBirth());
      employee.setDateModified(currentDateTime);
      return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @Override
    public List<Employee> listAll() {
        return employeeRepository.findAll();
    }

    @Override
    public ResponseEntity getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee not found");

        return ResponseEntity.status(HttpStatus.OK).body(employee.get());

    }
}
