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
import ma.pfa.springsecurity.dao.ProductRepository;
import ma.pfa.springsecurity.domaine.ProductConverter;
import ma.pfa.springsecurity.domaine.ProductVo;
import ma.pfa.springsecurity.service.model.Product;

@Service("productService")
@Transactional
public class ProductServiceImpl implements IProductService {
	@Autowired
	private ProductRepository productRepository;
	@Override
	public List<ProductVo> getProducts() {
		List<Product> list = productRepository.findAll();
		return ProductConverter.toListVo(list);
	}
	@Override
	public void save(ProductVo product) {
		productRepository.save(ProductConverter.toBo(product));
	}
	@Override
	public ProductVo getProductById(Long id) { 
		boolean trouve = productRepository.existsById(id);
		if (!trouve)
			return null;
		return ProductConverter.toVo(productRepository.getOne(id));
	}
	@Override
	@Admin1Profile
	public void delete(Long id) {
		productRepository.deleteById(id);
	}
	@Override
	public List<ProductVo> findByPrice(Double salaty) {
		List<Product> list = productRepository.findByPrice(salaty);
		return ProductConverter.toListVo(list);
	}
	@Override
	public List<ProductVo> searchProduct(String fonction) {
		List<Product> list = productRepository.search(fonction);
		return ProductConverter.toListVo(list);
	}
	@Override
	public List<ProductVo> findByPriceAndName(Double salary, String fonction) {
		List<Product> list = productRepository.findByPriceAndName(salary, fonction);
		return ProductConverter.toListVo(list);
	}
	@Override
	public ProductVo getEmpHavaingMaxSalary() {
		return ProductConverter.toVo(productRepository.getEmpHavaingMaxSalary());
	}
	@Override
	public List<ProductVo> findAll(int pageId, int size) {
		Page<Product> result = productRepository.findAll(PageRequest.of(pageId, size, Direction.ASC, "name"));
		return ProductConverter.toListVo(result.getContent());
	}
	@Override
	public List<ProductVo> sortBy(String fieldName) {
		return ProductConverter.toListVo(productRepository.findAll(Sort.by(fieldName)));
	}

	@Override
	public List<ProductVo> getLastestProducts() {
		 
		return ProductConverter.toListVo(productRepository.lastest());
	}
}
