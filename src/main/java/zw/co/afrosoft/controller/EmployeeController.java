package zw.co.afrosoft.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.domain.Employee;
import zw.co.afrosoft.dto.EmployeeRequest;
import zw.co.afrosoft.dto.EmployeeResponse;
import zw.co.afrosoft.service.EmployeeService;
import zw.co.afrosoft.service.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public EmployeeResponse save(@RequestBody EmployeeRequest employeeRequest){
        logger.info("Save Employee: EmployeeRequest={}" +employeeRequest);
        Employee employee = employeeService.create(employeeRequest);
        return new EmployeeResponse(employee);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id")Long id){
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /*
    @PutMapping("/update/{id}")
    public EmployeeResponse update(@RequestBody EmployeeRequest employeeRequest) {
        logger.info("Update Employee: EmployeeRequest={}" + employeeRequest);
        Employee employee = employeeService.update(employeeRequest);
        return new EmployeeResponse(employee);
    }

     */


    @GetMapping("/getAll")
   public List<EmployeeResponse> getAll(){
        List<Employee>  employees = employeeService.listAll();
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();
        employees.stream().forEach(employee -> employeeResponseList.add(new EmployeeResponse(employee)));
        return employeeResponseList;
    }



}
