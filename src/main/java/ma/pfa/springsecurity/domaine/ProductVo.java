package ma.pfa.springsecurity.domaine;

import lombok.Data;

@Data
public class ProductVo {
	private Long id;
	private String name; 
	private String description;
	private Double price; 
	private int stock;
	private String image;
	private CategoryVo category;
	public ProductVo() {
		super();
	}
	public ProductVo(Long id, String name,String description, Double price, int stock, String image, CategoryVo category ) {
		this(name,description,price,stock,image, category );
		this.id = id;

	}
	
	public ProductVo(String name,String description, Double price, int stock, String image, CategoryVo category ) {
		super();
		this.name = name;
		this.description=description;
		this.price = price;
		this.stock=stock;
		this.image = image;
		this.category=category;
	}
}