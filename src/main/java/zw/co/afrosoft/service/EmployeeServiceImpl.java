package zw.co.afrosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import zw.co.afrosoft.domain.Employee;
import zw.co.afrosoft.dto.UpdateEmployeeRequest;
import zw.co.afrosoft.dto.request.EmployeeRequest;
import zw.co.afrosoft.dto.response.EmployeeResponse;
import zw.co.afrosoft.persistence.EmployeeRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponse create(EmployeeRequest employeeRequest) {
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
        return new EmployeeResponse(employee);
    }

    @Override
    public EmployeeResponse delete(Long id) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (!existingEmployee.isPresent())
            throw new RuntimeException("Employee Not Found");
        Employee employee = existingEmployee.get();
        employeeRepository.delete(employee);
        return new EmployeeResponse(employee);
    }


    @Override
    public EmployeeResponse update(UpdateEmployeeRequest updateEmployeeRequest) {
        LocalDateTime currentDateTime =LocalDateTime.now();
        Optional<Employee> existingEmployee = employeeRepository.findById(updateEmployeeRequest.getId());
        if (!existingEmployee.isPresent())
            throw new RuntimeException("Employee Not Found");
        Employee employee = existingEmployee.get();
        employee.setEmail(updateEmployeeRequest.getEmail());
        employee.setPhoneNumber(updateEmployeeRequest.getPhoneNumber());
        employee.setFirstname(updateEmployeeRequest.getFirstname());
        employee.setLastname(updateEmployeeRequest.getLastname());
        employee.setDateOfBirth(updateEmployeeRequest.getDateOfBirth());
        employee.setDateModified(currentDateTime);
        return new EmployeeResponse(employee);
    }

    @Override
    public List<Employee> listAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (!existingEmployee.isPresent())
            throw new RuntimeException("Employee Not Found");

        Employee employee = existingEmployee.get();
        return new EmployeeResponse(employee);

    }
}
