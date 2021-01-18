package ma.cigma.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.cigma.springsecurity.aop.Admin1Profile;
import ma.cigma.springsecurity.dao.CatRepository;
import ma.cigma.springsecurity.domaine.CatConverter;
import ma.cigma.springsecurity.domaine.CatVo;
import ma.cigma.springsecurity.service.model.Category;

@Service
@Transactional
public class CatServiceImpl implements ICatService {
	@Autowired
	private CatRepository CatRepository;
	@Override
	public List<CatVo> getCategories() {
		List<Category> list = CatRepository.findAll();
		return CatConverter.toListVo(list);
	}
	@Override
	public void save(CatVo Category) {
		CatRepository.save(CatConverter.toBo(Category));
	}
	@Override
	public CatVo getCatById(Long id) {
		boolean trouve = CatRepository.existsById(id);
		if (!trouve)
			return null;
		return CatConverter.toVo(CatRepository.getOne(id));
	}
	@Override
	@Admin1Profile
	public void delete(Long id) {
		CatRepository.deleteById(id);
	}
	@Override
	public List<CatVo> findByName(String name) {
		List<Category> list = CatRepository.findByName(name);
		return CatConverter.toListVo(list);
	} 
	@Override
	public List<CatVo> findAll(int pageId, int size) {
		Page<Category> result = CatRepository.findAll(PageRequest.of(pageId, size, Direction.ASC, "name"));
		return CatConverter.toListVo(result.getContent());
	}
	@Override
	public List<CatVo> sortBy(String fieldName) {
		return CatConverter.toListVo(CatRepository.findAll(Sort.by(fieldName)));
	}
 
}
