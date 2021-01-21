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
import ma.pfa.springsecurity.dao.OrderRepository;
import ma.pfa.springsecurity.domaine.CatConverter;
import ma.pfa.springsecurity.domaine.CatVo;
import ma.pfa.springsecurity.service.model.Order;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {
	@Autowired
	private OrderRepository OrderRepository;
	@Override
	public List<CatVo> getOrders() {
		List<Order> list = OrderRepository.findAll();
		return CatConverter.toListVo(list);
	}
	@Override
	public void save(CatVo Order) {
		OrderRepository.save(CatConverter.toBo(Order));
	}
	@Override
	public CatVo getCatById(Long id) {
		boolean trouve = OrderRepository.existsById(id);
		if (!trouve)
			return null;
		return CatConverter.toVo(OrderRepository.getOne(id));
	}
	@Override
	@Admin1Profile
	public void delete(Long id) {
		OrderRepository.deleteById(id);
	}
	@Override
	public List<CatVo> findByName(String name) {
		List<Order> list = OrderRepository.findByName(name);
		return CatConverter.toListVo(list);
	} 
	@Override
	public List<CatVo> findAll(int pageId, int size) {
		Page<Order> result = OrderRepository.findAll(PageRequest.of(pageId, size, Direction.ASC, "name"));
		return CatConverter.toListVo(result.getContent());
	}
	@Override
	public List<CatVo> sortBy(String fieldName) {
		return CatConverter.toListVo(OrderRepository.findAll(Sort.by(fieldName)));
	}
 
}
