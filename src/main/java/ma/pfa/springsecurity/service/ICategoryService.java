package ma.pfa.springsecurity.service;

import java.util.List;

import ma.pfa.springsecurity.domaine.CategoryVo;
import ma.pfa.springsecurity.domaine.ProductVo;
public interface ICategoryService {
	List<CategoryVo> getCategories();
	
	void save(CategoryVo category);
	CategoryVo getCategoryById(Long id);
	void delete(Long id);
	List<CategoryVo> findByName(String name);
	//Pour la pagination
	List<CategoryVo> findAll(int pageId, int size);
	//pour le tri
	List<CategoryVo> sortBy(String fieldName);
	List<ProductVo> searchByCategory(Long id);
	
}
