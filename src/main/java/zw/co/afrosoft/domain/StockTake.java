package zw.co.afrosoft.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StockTake extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private LocalDate date;

	@Column(name = "start_time",nullable = false)
	@JsonFormat(pattern = "HH:mm")
	private LocalTime startTime;

	@Column(name = "end_time",nullable = false)
	@JsonFormat(pattern = "HH:mm")
	private LocalTime endTime;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Long getId() {
		return id;
	}

}
