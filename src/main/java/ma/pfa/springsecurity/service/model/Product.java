package ma.pfa.springsecurity.service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Product {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@Lob
	private String description;
	private Double price; 
	private int stock;
	private String image;

	public Product(String name,String description, Double price, int stock, String image) {
		super();
		this.name = name;
		this.description=description;
		this.price = price;
		this.stock = stock;
		this.image=image;
	}
}