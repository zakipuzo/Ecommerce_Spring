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
public class Order {
	@Id
	@GeneratedValue
    private Long id;  

    @ManyToOne
    @JoinColumn(name = "fk_user")
	private User user;
    private int status;
      
    @OneToMany(mappedBy = "order")
    private List<OrderItem> items = new ArrayList<OrderItem>();
 
    public Order( User user, int status) {
      
        this.user = user;
        this.status = status;
    }
	 

 
}