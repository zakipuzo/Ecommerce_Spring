package ma.pfa.springsecurity.service.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany; 

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

 

	public Category(  String name ) {
	 
		this.name = name; 
	}
	 
}