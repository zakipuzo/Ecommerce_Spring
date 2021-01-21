package ma.pfa.springsecurity.service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class OrderItem {
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "fk_order")
    private Order order;
	 
	@ManyToOne
    @JoinColumn(name = "fk_product")
	private Product product;

	private int quantity;

	 

	public OrderItem(  Order order, Product product, int quantity) {
	 
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}
 
 

 
}