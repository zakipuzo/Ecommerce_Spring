package ma.pfa.springsecurity.service.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity(name = "userorder")
public class Userorder {
	@Id
	@GeneratedValue
    private Long id;  

    @ManyToOne
    @JoinColumn(name = "fk_user")
	private User user;
    private int orderstatus;
      
    @OneToMany(mappedBy = "order")
    private List<OrderItem> items = new ArrayList<OrderItem>();
 
    public Userorder( User user, int orderstatus ) {
      
        this.user = user;
        this.orderstatus = orderstatus;
    }


    public Userorder() {
    }

	 

 
}