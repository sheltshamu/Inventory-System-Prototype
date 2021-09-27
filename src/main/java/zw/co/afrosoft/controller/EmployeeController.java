package zw.co.afrosoft.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.domain.Employee;
import zw.co.afrosoft.dto.EmployeeRequest;
import zw.co.afrosoft.dto.EmployeeResponse;
import zw.co.afrosoft.service.EmployeeService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

   // @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public EmployeeResponse save(@Valid @RequestBody EmployeeRequest employeeRequest){
        logger.info("save employee request" + employeeRequest);
        Employee employee = employeeService.save(employeeRequest);
        return new EmployeeResponse(employee);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<EmployeeResponse> delete(@PathVariable("id")Long id){
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeResponse> update(@RequestBody EmployeeRequest employeeRequest){
        employeeService.update(employeeRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/getAll")
    public List<EmployeeResponse> getAll(){
       List<Employee> employeeList = employeeService.listAll();
       List<EmployeeResponse> employeeResponseList = new ArrayList<>();
       employeeList.stream().filter(employee -> employeeResponseList.add(new EmployeeResponse(employee)));
       return employeeResponseList;
    }



}
