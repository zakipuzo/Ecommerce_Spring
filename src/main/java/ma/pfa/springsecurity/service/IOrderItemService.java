package ma.pfa.springsecurity.service;
import java.util.List;

import ma.pfa.springsecurity.domaine.OrderItemVo;
import ma.pfa.springsecurity.service.model.User;
public interface IOrderItemService {

	List<OrderItemVo> getOrderItems();
	
	void save(OrderItemVo orderItem);
	OrderItemVo getOrderItemById(Long id);
	void delete(Long id); 
	//Pour la pagination
	List<OrderItemVo> findAll(int pageId, int size);
	//pour le tri
	List<OrderItemVo> sortBy(String fieldName);
}
