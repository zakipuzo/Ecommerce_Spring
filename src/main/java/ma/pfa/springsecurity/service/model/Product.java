package ma.pfa.springsecurity.service.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	// lob pour designer un TEXT
	@Lob
	private String description;
	private Double price; 
	private int stock;
	private String image;

	@ManyToOne
    @JoinColumn(name = "fk_category")
	private Category category;


// 
	public Product(String name,String description, Double price, int stock, String image) {
		super();
		this.name = name;
		this.description=description;
		this.price = price;
		this.stock = stock;
		this.image=image;
	}


	public Product(String name, String description, Double price, int stock, String image, Category category) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.image = image;
		this.category = category;
	}



}