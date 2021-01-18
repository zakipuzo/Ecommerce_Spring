package ma.cigma.springsecurity.service;
import java.util.List;

import ma.cigma.springsecurity.domaine.CatVo;
public interface ICatService {
	List<CatVo> getCategories();
	
	void save(CatVo emp);
	CatVo getCatById(Long id);
	void delete(Long id);
	List<CatVo> findByName(String name);
	//Pour la pagination
	List<CatVo> findAll(int pageId, int size);
	//pour le tri
	List<CatVo> sortBy(String fieldName);
}
