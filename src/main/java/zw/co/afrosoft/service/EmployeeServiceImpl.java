package zw.co.afrosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
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

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(EmployeeRequest employeeRequest) {
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
        return employee;
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }


    @Override
    public Employee update(UpdateEmployeeRequest updateEmployeeRequest) {
       Employee employee = employeeRepository.findById(updateEmployeeRequest.getId()).get();
       employee.setPhoneNumber(updateEmployeeRequest.getPhoneNumber());
       employee.setFirstname(updateEmployeeRequest.getFirstname());
       employee.setLastname(updateEmployeeRequest.getLastname());
       employee.setEmail(updateEmployeeRequest.getEmail());
       employee.setDateOfBirth(updateEmployeeRequest.getDateOfBirth());
       employee.setEmail(updateEmployeeRequest.getEmail());
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> listAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent()) {
            throw new RuntimeException("Employee "+ id + "Not Found");
        }
        return employee.get();
    }
}
