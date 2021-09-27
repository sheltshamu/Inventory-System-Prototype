package zw.co.afrosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
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
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(EmployeeRequest employeeRequest){
        Employee employee = new Employee(employeeRequest);
        if (employee!=null)
            employeeRepository.save(employee);
        return employee;
    }

    public void delete(Long id){
      employeeRepository.deleteById(id);
    }

    public Employee update(EmployeeRequest employeeRequest){
        Employee employee = employeeRepository.getById(employeeRequest.getId());
        if (!employeeRequest.getFirstname().isEmpty()&& employeeRequest.getFirstname()!=null)
            employee.setFirstname(employeeRequest.getFirstname());
        employeeRepository.save(employee);
        return employee;
    }

    public List<Employee> listAll(){
        return employeeRepository.findAll();
    }
}
