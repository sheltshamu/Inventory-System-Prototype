package zw.co.afrosoft.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import zw.co.afrosoft.commons.Time;
import javax.persistence.*;
import java.time.LocalDate;
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StockTake extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private LocalDate date;

	@Column(name = "start_time")
	@Embedded
	private Time startTime;

	@Column(name = "end_time")
	@Embedded
	private Time endTime;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

}
