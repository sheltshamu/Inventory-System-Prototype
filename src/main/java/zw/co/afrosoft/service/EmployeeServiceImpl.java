package zw.co.afrosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import zw.co.afrosoft.domain.Employee;
import zw.co.afrosoft.dto.EmployeeRequest;
import zw.co.afrosoft.dto.EmployeeResponse;
import zw.co.afrosoft.persistence.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee create(EmployeeRequest employeeRequest) {
        Employee employee = new Employee(employeeRequest);
        if (employee!=null)
            employeeRepository.save(employee);
        return employee;
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }


    @Override
    public Employee update(EmployeeRequest employeeRequest) {
        return null;
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
