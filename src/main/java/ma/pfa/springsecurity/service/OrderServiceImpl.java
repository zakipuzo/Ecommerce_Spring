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
import ma.pfa.springsecurity.dao.UserOrderRepository;
import ma.pfa.springsecurity.domaine.OrderConverter;
import ma.pfa.springsecurity.domaine.OrderVo;
import ma.pfa.springsecurity.domaine.UserVo;
import ma.pfa.springsecurity.service.model.Userorder;
import ma.pfa.springsecurity.service.model.User;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {
	@Autowired
	private UserOrderRepository OrderRepository;
	@Override
	public List<OrderVo> getOrders() {
		List<Userorder> list = OrderRepository.findAll();
		return OrderConverter.toListVo(list);
	}
	@Override
	public void save(OrderVo Order) {
		OrderRepository.save(OrderConverter.toBo(Order));
	}
	@Override
	public OrderVo getOrderById(Long id) {
		boolean trouve = OrderRepository.existsById(id);
		if (!trouve)
			return null;
		return OrderConverter.toVo(OrderRepository.getOne(id));
	}
	@Override
	@Admin1Profile
	public void delete(Long id) {
		OrderRepository.deleteById(id);
	}
 
	@Override
	public List<OrderVo> findAll(int pageId, int size) {
		Page<Userorder> result = OrderRepository.findAll(PageRequest.of(pageId, size, Direction.ASC, "name"));
		return OrderConverter.toListVo(result.getContent());
	}
	@Override
	public List<OrderVo> sortBy(String fieldName) {
		return OrderConverter.toListVo(OrderRepository.findAll(Sort.by(fieldName)));
	}
 
}
