package zw.co.afrosoft.domain;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Category extends  BaseEntity{

	@Column(nullable = false, length=10, unique = true)
	private String name;
}
