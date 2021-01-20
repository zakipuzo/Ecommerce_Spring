package ma.pfa.springsecurity.domaine;

import java.util.ArrayList;
import java.util.List;

import ma.pfa.springsecurity.service.model.Product;

public class ProductConverter {
	public static ProductVo toVo(Product bo) {
		if (bo == null || bo.getId() ==null)
			return null;
		ProductVo vo = new ProductVo();
		vo.setId(bo.getId());
		vo.setName(bo.getName());
		vo.setDescription(bo.getDescription());
		vo.setPrice(bo.getPrice());
		vo.setStock(bo.getStock());
		vo.setImage(bo.getImage());
		return vo;
	}
	public static Product toBo(ProductVo vo) {
		Product bo = new Product();
		bo.setId(vo.getId());
		bo.setName(vo.getName());
		bo.setDescription(vo.getDescription());
		bo.setPrice(vo.getPrice());
		bo.setStock(vo.getStock());
		bo.setImage(vo.getImage());
		return bo;
	}
	public static List<ProductVo> toListVo(List<Product> listBo) {
		List<ProductVo> listVo = new ArrayList<>();
		for (Product product : listBo) {
			listVo.add(toVo(product));
		}
		return listVo;
	}
}
