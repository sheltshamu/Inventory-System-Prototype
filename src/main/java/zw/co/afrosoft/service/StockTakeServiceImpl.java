package zw.co.afrosoft.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.domain.Employee;
import zw.co.afrosoft.domain.StockTake;
import zw.co.afrosoft.dto.request.StockTakeRequest;
import zw.co.afrosoft.persistence.EmployeeRepository;
import zw.co.afrosoft.persistence.StockTakeRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StockTakeServiceImpl implements StockTakeService{

    private final StockTakeRepository stockTakeRepository;
    private final EmployeeRepository employeeRepository;

    public StockTakeServiceImpl(StockTakeRepository stockTakeRepository, EmployeeRepository employeeRepository) {
        this.stockTakeRepository = stockTakeRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ResponseEntity create(StockTakeRequest stockTakeRequest) {
        Employee employee = employeeRepository.findById(stockTakeRequest.getEmployeeId()).get();
        LocalDateTime currentDateTime = LocalDateTime.now();
        StockTake stockTake = new StockTake();
        stockTake.setDate(stockTakeRequest.getDate());
        stockTake.setStartTime(stockTakeRequest.getStartTime());
        stockTake.setEndTime(stockTakeRequest.getEndTime());
        stockTake.setEmployee(employee);
        stockTake.setDateCreated(currentDateTime);
        stockTake.setDateModified(currentDateTime);
        return ResponseEntity.ok(stockTake);
    }

    @Override
    public ResponseEntity getAll() {
        List<StockTake> stockTakes = stockTakeRepository.findAll();
        return ResponseEntity.ok(stockTakes);
    }


}
