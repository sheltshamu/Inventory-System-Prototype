package zw.co.afrosoft.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.domain.Employee;
import zw.co.afrosoft.dto.ApiResponse;
import zw.co.afrosoft.dto.ResponseCode;
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
    public ApiResponse<EmployeeResponse> save(@Valid @RequestBody EmployeeRequest employeeRequest){
       EmployeeResponse employee = employeeService.create(employeeRequest);
       return new ApiResponse<>(employee,"OK",ResponseCode.SUCCESS);
    }

    @DeleteMapping(value = "/{id}")
    public ApiResponse<EmployeeResponse> delete(@RequestParam("id")Long id){
       EmployeeResponse employeeResponse= employeeService.delete(id);
        return new ApiResponse<>(employeeResponse,"OK",ResponseCode.SUCCESS);
    }

    @PutMapping("/update")
    public ApiResponse update(@Valid @RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
        EmployeeResponse employee = employeeService.update(updateEmployeeRequest);
        return new ApiResponse(employee,"OK",ResponseCode.SUCCESS);
    }

    @GetMapping("/getAll")
   public ApiResponse<List<EmployeeResponse>> getAll(){
        List<Employee> employeeList = employeeService.listAll();
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();
        employeeList.stream().forEach(employee -> employeeResponseList.add(new EmployeeResponse(employee)));
        return new ApiResponse<>(employeeResponseList,"OK",ResponseCode.SUCCESS);
    }
}
