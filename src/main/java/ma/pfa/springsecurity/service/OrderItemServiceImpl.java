package ma.pfa.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.pfa.springsecurity.aop.Admin1Profile;
import ma.pfa.springsecurity.dao.OrderItemRepository;
import ma.pfa.springsecurity.domaine.OrderItemConverter;
import ma.pfa.springsecurity.domaine.OrderItemVo;
import ma.pfa.springsecurity.domaine.UserVo;
import ma.pfa.springsecurity.service.model.OrderItem;
import ma.pfa.springsecurity.service.model.User;

@Service
@Transactional
public class OrderItemServiceImpl implements IOrderItemService {
	@Autowired
	private OrderItemRepository OrderItemRepository;
	@Override
	public List<OrderItemVo> getOrderItems() {
		List<OrderItem> list = OrderItemRepository.findAll();
		return OrderItemConverter.toListVo(list);
	}
	@Override
	public void save(OrderItemVo OrderItem) {
		OrderItemRepository.save(OrderItemConverter.toBo(OrderItem));
	}
	@Override
	public OrderItemVo getOrderItemById(Long id) {
		boolean trouve = OrderItemRepository.existsById(id);
		if (!trouve)
			return null;
		return OrderItemConverter.toVo(OrderItemRepository.getOne(id));
	}
	@Override
	@Admin1Profile
	public void delete(Long id) {
		OrderItemRepository.deleteById(id);
	}
	 
	@Override
	public List<OrderItemVo> findAll(int pageId, int size) {
		Page<OrderItem> result = OrderItemRepository.findAll(PageRequest.of(pageId, size, Direction.ASC, "name"));
		return OrderItemConverter.toListVo(result.getContent());
	}
	@Override
	public List<OrderItemVo> sortBy(String fieldName) {
		return OrderItemConverter.toListVo(OrderItemRepository.findAll(Sort.by(fieldName)));
	}
 
}
