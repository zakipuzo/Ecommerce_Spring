package ma.pfa.springsecurity.domaine;

import java.util.ArrayList;
import java.util.List;

import ma.pfa.springsecurity.service.model.Category;

public class CategoryConverter {
	public static CategoryVo toVo(Category bo) {
		if (bo == null || bo.getId() ==null)
			return null;
		CategoryVo vo = new CategoryVo();
		vo.setId(bo.getId());
		vo.setName(bo.getName()); 
		return vo;
	}
	public static Category toBo(CategoryVo vo) {
		Category bo = new Category();
		bo.setId(vo.getId());
		bo.setName(vo.getName()); 
		return bo;
	}
	public static List<CategoryVo> toListVo(List<Category> listBo) {
		List<CategoryVo> listVo = new ArrayList<>();
		for (Category Category : listBo) {
			listVo.add(toVo(Category));
		}
		return listVo;
	}
}
