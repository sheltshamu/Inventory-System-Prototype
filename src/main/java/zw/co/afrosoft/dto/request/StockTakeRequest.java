package zw.co.afrosoft.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import zw.co.afrosoft.domain.Employee;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StockTakeRequest implements Serializable {
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize
    private LocalDate date;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startTime;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime endTime;
    private Long employeeId;
}
