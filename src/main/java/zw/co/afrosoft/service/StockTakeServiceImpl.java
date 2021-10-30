package zw.co.afrosoft.service;

import jdk.nashorn.internal.ir.Optimistic;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.domain.Employee;
import zw.co.afrosoft.domain.StockTake;
import zw.co.afrosoft.dto.request.StockTakeRequest;
import zw.co.afrosoft.dto.response.StockTakeResponse;
import zw.co.afrosoft.persistence.EmployeeRepository;
import zw.co.afrosoft.persistence.StockTakeRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StockTakeServiceImpl implements StockTakeService{

    private final StockTakeRepository stockTakeRepository;
    private final EmployeeRepository employeeRepository;

    public StockTakeServiceImpl(StockTakeRepository stockTakeRepository, EmployeeRepository employeeRepository) {
        this.stockTakeRepository = stockTakeRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public StockTakeResponse create(StockTakeRequest stockTakeRequest) {
        Optional<Employee> existingEmployee = employeeRepository.findById(stockTakeRequest.getEmployeeId());
        if (!existingEmployee.isPresent())
            throw new RuntimeException("Employee not found");
        Employee employee =existingEmployee.get();
        LocalDateTime currentDateTime = LocalDateTime.now();
        StockTake stockTake = new StockTake();
        stockTake.setDate(stockTakeRequest.getDate());
        stockTake.setStartTime(stockTakeRequest.getStartTime());
        stockTake.setEndTime(stockTakeRequest.getEndTime());
        stockTake.setEmployee(employee);
        stockTake.setDateCreated(currentDateTime);
        stockTake.setDateModified(currentDateTime);
        return new StockTakeResponse(stockTake);
    }

    @Override
    public List<StockTake> getAll() {
        List<StockTake> stockTakeList = stockTakeRepository.findAll();
        return stockTakeList;
    }


}
