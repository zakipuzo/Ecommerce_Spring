package ma.pfa.springsecurity.domaine;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderVo {
	private Long id;
	private UserVo user;
	private int orderstatus;
	

	public OrderVo(Long id, UserVo user, int orderstatus) {
		this.id = id;
		this.user = user;
	}

	public OrderVo(UserVo user, int orderstatus) {
	 
		this.user = user;
		this.orderstatus = orderstatus;
	}
	

	public OrderVo() {
	}


}