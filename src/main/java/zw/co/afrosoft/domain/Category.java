package zw.co.afrosoft.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import zw.co.afrosoft.dto.CategoryRequest;
import zw.co.afrosoft.dto.CategoryResponse;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length=10)
	private Abbreviation abbreviation;

	public Category(CategoryRequest categoryRequest){
		this.id=categoryRequest.getId();
		this.abbreviation=categoryRequest.getAbbreviation();
	}

	public Abbreviation getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(Abbreviation abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	
	
	

}
