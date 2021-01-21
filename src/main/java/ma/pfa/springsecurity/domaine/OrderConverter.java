package ma.pfa.springsecurity.domaine;

import java.util.ArrayList;
import java.util.List;

import ma.pfa.springsecurity.service.model.Userorder;

public class OrderConverter {
	public static OrderVo toVo(Userorder bo) {
		if (bo == null || bo.getId() ==null)
			return null;
		OrderVo vo = new OrderVo();
		vo.setId(bo.getId());
		vo.setOrderstatus(bo.getOrderstatus()); 
		//vo.setUser(UserConverter.toVo(bo.getUser()));
	//	vo.setOrderdate(bo.getOrderdate());
		return vo;
	}
	public static Userorder toBo(OrderVo vo) {
		Userorder bo = new Userorder();
		bo.setId(vo.getId());
		bo.setOrderstatus(vo.getOrderstatus()); 
	//	bo.setUser(UserConverter.toBo(vo.getUser()));
	//	bo.setOrderdate(vo.getOrderdate());
		return bo;
	}
	public static List<OrderVo> toListVo(List<Userorder> listBo) {
		List<OrderVo> listVo = new ArrayList<>();
		for (Userorder Order : listBo) {
			listVo.add(toVo(Order));
		}
		return listVo;
	}
}
