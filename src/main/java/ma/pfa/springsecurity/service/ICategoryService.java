package ma.pfa.springsecurity.service;
import java.util.List;

import ma.pfa.springsecurity.domaine.CatVo;
public interface ICategoryService {
	List<CatVo> getCategories();
	
	void save(CatVo product);
	CatVo getCatById(Long id);
	void delete(Long id);
	List<CatVo> findByName(String name);
	//Pour la pagination
	List<CatVo> findAll(int pageId, int size);
	//pour le tri
	List<CatVo> sortBy(String fieldName);
}
