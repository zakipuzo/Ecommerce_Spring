package ma.pfa.springsecurity.domaine;

import java.util.ArrayList;
import java.util.List;

import ma.pfa.springsecurity.service.model.Order;

public class OrderConverter {
	public static OrderVo toVo(Order bo) {
		if (bo == null || bo.getId() ==null)
			return null;
		OrderVo vo = new OrderVo();
		vo.setId(bo.getId());
		vo.setName(bo.getName()); 
		return vo;
	}
	public static Order toBo(OrderVo vo) {
		Order bo = new Order();
		bo.setId(vo.getId());
		bo.setName(vo.getName()); 
		return bo;
	}
	public static List<OrderVo> toListVo(List<Order> listBo) {
		List<OrderVo> listVo = new ArrayList<>();
		for (Order Order : listBo) {
			listVo.add(toVo(Order));
		}
		return listVo;
	}
}
