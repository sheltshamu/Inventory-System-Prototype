package zw.co.afrosoft.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
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

    @JsonDeserialize(using = LocalTimeDeserializer.class)
    @JsonSerialize(using = LocalTimeSerializer.class)
    private LocalTime startTime;

    @JsonDeserialize(using = LocalTimeDeserializer.class)
    @JsonSerialize(using = LocalTimeSerializer.class)
    private LocalTime endTime;

    private Long employeeId;
}
