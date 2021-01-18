package ma.cigma.springsecurity.domaine;

import java.util.ArrayList;
import java.util.List;

import ma.cigma.springsecurity.service.model.Category;

public class CatConverter {
	public static CatVo toVo(Category bo) {
		if (bo == null || bo.getId() ==null)
			return null;
		CatVo vo = new CatVo();
		vo.setId(bo.getId());
		vo.setName(bo.getName()); 
		return vo;
	}
	public static Category toBo(CatVo vo) {
		Category bo = new Category();
		bo.setId(vo.getId());
		bo.setName(vo.getName()); 
		return bo;
	}
	public static List<CatVo> toListVo(List<Category> listBo) {
		List<CatVo> listVo = new ArrayList<>();
		for (Category Category : listBo) {
			listVo.add(toVo(Category));
		}
		return listVo;
	}
}
