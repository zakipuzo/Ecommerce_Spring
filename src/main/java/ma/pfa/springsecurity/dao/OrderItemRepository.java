package ma.pfa.springsecurity.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.pfa.springsecurity.service.model.OrderItem;

 
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

	 
}
