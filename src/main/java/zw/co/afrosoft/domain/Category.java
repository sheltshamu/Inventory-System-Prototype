package zw.co.afrosoft.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length=10)
	private Abbreviation abbreviation;

	public Abbreviation getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(Abbreviation abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	
	
	

}
