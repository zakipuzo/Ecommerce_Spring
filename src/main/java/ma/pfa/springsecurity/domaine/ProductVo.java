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
	public ProductVo() {
		super();
	}
	public ProductVo(Long id, String name,String description, Double price, int stock, String image) {
		this(name,description,price,stock,image);
		this.id = id;
	}
	
	public ProductVo(String name,String description, Double price, int stock, String image) {
		super();
		this.name = name;
		this.description=description;
		this.price = price;
		this.stock=stock;
		this.image = image;
	}
}