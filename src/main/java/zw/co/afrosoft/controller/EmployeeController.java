package zw.co.afrosoft.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.domain.Employee;
import zw.co.afrosoft.dto.UpdateEmployeeRequest;
import zw.co.afrosoft.dto.request.EmployeeRequest;
import zw.co.afrosoft.dto.response.EmployeeResponse;
import zw.co.afrosoft.service.EmployeeService;
import zw.co.afrosoft.service.EmployeeServiceImpl;

import javax.validation.Valid;
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
    public ResponseEntity save(@Valid @RequestBody EmployeeRequest employeeRequest){
        logger.info("Save Employee: EmployeeRequest={}" +employeeRequest);
        return ResponseEntity.ok().body(employeeService.create(employeeRequest));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@RequestParam("id")Long id){
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity update(@Valid @RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
        return employeeService.update(updateEmployeeRequest);
    }

    @GetMapping("/getAll")
   public List<EmployeeResponse> getAll(){
        List<Employee>  employees = employeeService.listAll();
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();
        employees.stream().forEach(employee -> employeeResponseList.add(new EmployeeResponse(employee)));
        return employeeResponseList;
    }
}
