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
import ma.pfa.springsecurity.dao.CategoryRepository;
import ma.pfa.springsecurity.domaine.CategoryConverter;
import ma.pfa.springsecurity.domaine.CategoryVo;
import ma.pfa.springsecurity.domaine.ProductConverter;
import ma.pfa.springsecurity.domaine.ProductVo;
import ma.pfa.springsecurity.service.model.Category;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	private CategoryRepository CatRepository;

	@Override
	public List<CategoryVo> getCategories() {
		List<Category> list = CatRepository.findAll();
		return CategoryConverter.toListVo(list);
	}

	@Override
	public void save(CategoryVo Category) {
		CatRepository.save(CategoryConverter.toBo(Category));
	}

	@Override
	public CategoryVo getCategoryById(Long id) {
		boolean trouve = CatRepository.existsById(id);
		if (!trouve)
			return null;
		return CategoryConverter.toVo(CatRepository.getOne(id));
	}

	@Override
	@Admin1Profile
	public void delete(Long id) {
		CatRepository.deleteById(id);
	}

	@Override
	public List<CategoryVo> findByName(String name) {
		List<Category> list = CatRepository.findByName(name);
		return CategoryConverter.toListVo(list);
	}

	@Override
	public List<CategoryVo> findAll(int pageId, int size) {
		Page<Category> result = CatRepository.findAll(PageRequest.of(pageId, size, Direction.ASC, "name"));
		return CategoryConverter.toListVo(result.getContent());
	}

	@Override
	public List<CategoryVo> sortBy(String fieldName) {
		return CategoryConverter.toListVo(CatRepository.findAll(Sort.by(fieldName)));
	}

	@Override
	public List<ProductVo> searchByCategory(Long id) {
		return ProductConverter.toListVo(CatRepository.findByCategory(id));

	}
 
}
