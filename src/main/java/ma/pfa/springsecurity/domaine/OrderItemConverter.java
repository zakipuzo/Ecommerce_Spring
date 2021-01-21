package ma.pfa.springsecurity.domaine;

import java.util.ArrayList;
import java.util.List;

import ma.pfa.springsecurity.service.model.OrderItem;

public class OrderItemConverter {
	public static OrderItemVo toVo(OrderItem bo) {
		if (bo == null || bo.getId() ==null)
			return null;
		OrderItemVo vo = new OrderItemVo();
		vo.setId(bo.getId());
		vo.setOrder(OrderConverter.toVo(bo.getOrder())); 
		vo.setProduct(ProductConverter.toVo(bo.getProduct()));
		vo.setQuantity(bo.getQuantity());
		return vo;
	}
	public static OrderItem toBo(OrderItemVo vo) {
		OrderItem bo = new OrderItem();
		bo.setId(vo.getId());
		bo.setId(vo.getId());
		bo.setOrder(OrderConverter.toBo(vo.getOrder())); 
		bo.setProduct(ProductConverter.toBo(vo.getProduct()));
		bo.setQuantity(vo.getQuantity());;
		return bo;
	}
	public static List<OrderItemVo> toListVo(List<OrderItem> listBo) {
		List<OrderItemVo> listVo = new ArrayList<>();
		for (OrderItem OrderItem : listBo) {
			listVo.add(toVo(OrderItem));
		}
		return listVo;
	}
}
