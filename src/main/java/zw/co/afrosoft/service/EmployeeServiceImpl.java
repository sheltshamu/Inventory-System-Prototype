package zw.co.afrosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.domain.AuditInformation;
import zw.co.afrosoft.domain.Employee;
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
        AuditInformation auditInformation = new AuditInformation();
        auditInformation.setDateCreated(currentDateTime);
        auditInformation.setDateCreated(currentDateTime);
        Employee employee = new Employee();
        if (employee==null)
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
    public Employee update(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> listAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent()){
            throw new RuntimeException("Not Found");
        }
         return employee.get();
    }

    /*
    public Employee update(EmployeeRequest employeeRequest){
        Employee employee = employeeRepository.findById(employeeRequest.getId()).orElseThrow(RuntimeException::new);
            if (!employeeRequest.getFirstname().isEmpty() && employeeRequest.getFirstname() != null){
                employee.setFirstname(employeeRequest.getFirstname());
        }else if(!employeeRequest.getLastname().isEmpty() && employeeRequest.getLastname() != null){
                employee.setFirstname(employeeRequest.getFirstname());
        return employee;
    }
     */



}
