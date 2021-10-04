package zw.co.afrosoft.dto.request;

import lombok.*;
import zw.co.afrosoft.domain.Employee;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StockTakeRequest {
    private Long id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Long employeeId;
}
