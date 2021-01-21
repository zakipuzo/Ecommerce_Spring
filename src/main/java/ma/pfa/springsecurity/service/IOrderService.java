package ma.pfa.springsecurity.service;
import java.util.List;

import ma.pfa.springsecurity.domaine.OrderVo;
import ma.pfa.springsecurity.service.model.User;
public interface IOrderService {

	List<OrderVo> getOrders();
	
	void save(OrderVo order);
	OrderVo getOrderById(Long id);
	void delete(Long id);
 
	List<OrderVo> findAll(int pageId, int size);
	//pour le tri
	List<OrderVo> sortBy(String fieldName);
}
