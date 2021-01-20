package ma.pfa.springsecurity.service;
import java.util.List;

import ma.pfa.springsecurity.domaine.ProductVo;
public interface IProductService {
	List<ProductVo> getProducts();
	void save(ProductVo product);
	ProductVo getProductById(Long id);
	void delete(Long id);
	List<ProductVo> findByPrice(Double salary);
	List<ProductVo> findByName(String designation);
	List<ProductVo> findByPriceAndName(Double salary, String fonction);
	ProductVo getEmpHavaingMaxSalary();
	//Pour la pagination
	List<ProductVo> findAll(int pageId, int size);
	//pour le tri
	List<ProductVo> sortBy(String fieldName);
}
