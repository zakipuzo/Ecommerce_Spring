package ma.pfa.springsecurity.service;
import java.util.List;

import ma.pfa.springsecurity.domaine.CatVo;
import ma.pfa.springsecurity.service.model.User;
public interface IOrderService {

	List<CatVo> getOrders();
	
	void save(CatVo product);
	CatVo getOrderById(Long id);
	void delete(Long id);
	List<CatVo> findByUser(User user);
	//Pour la pagination
	List<CatVo> findAll(int pageId, int size);
	//pour le tri
	List<CatVo> sortBy(String fieldName);
}
