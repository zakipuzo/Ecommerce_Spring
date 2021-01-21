package ma.pfa.springsecurity.domaine;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItemVo {
	 
	private Long id; 
    private OrderVo order; 
	private ProductVo product;

	private int quantity;


	public OrderItemVo( OrderVo order, ProductVo product, int quantity) {
		 
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}
	  

	public OrderItemVo(Long id, OrderVo order, ProductVo product, int quantity) {
		this.id = id;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}

}