package zw.co.afrosoft.service;

import zw.co.afrosoft.domain.Employee;
import zw.co.afrosoft.domain.StockTake;
import zw.co.afrosoft.dto.request.StockTakeRequest;
import zw.co.afrosoft.persistence.EmployeeRepository;
import zw.co.afrosoft.persistence.StockTakeRepository;

import java.time.LocalDateTime;

public class StockTakeServiceImpl implements StockTakeService{

    private final StockTakeRepository stockTakeRepository;
    private final EmployeeRepository employeeRepository;

    public StockTakeServiceImpl(StockTakeRepository stockTakeRepository, EmployeeRepository employeeRepository) {
        this.stockTakeRepository = stockTakeRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public StockTake create(StockTakeRequest stockTakeRequest) {
        Employee employee = employeeRepository.findById(stockTakeRequest.getEmployeeId()).get();
        LocalDateTime currentDateTime = LocalDateTime.now();
        StockTake stockTake = new StockTake();
        stockTake.setDate(stockTakeRequest.getDate());
        stockTake.setStartTime(stockTakeRequest.getStartTime());
        stockTake.setEndTime(stockTakeRequest.getEndTime());
        stockTake.setEmployee(employee);
        stockTake.setDateCreated(currentDateTime);
        stockTake.setDateModified(currentDateTime);
        return stockTake;
    }
}
