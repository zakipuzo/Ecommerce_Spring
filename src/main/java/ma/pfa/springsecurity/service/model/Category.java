package ma.pfa.springsecurity.service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Category {
	@Id
	@GeneratedValue
	private Long id;
	private String name;  

	public Category(String name) {
		super();
		this.name = name; 
	}
}