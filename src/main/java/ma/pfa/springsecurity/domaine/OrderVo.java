package ma.pfa.springsecurity.domaine;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderVo {
	private Long id;
	private UserVo user;
	private int status;
	private LocalDateTime date;
	

	public OrderVo(Long id, UserVo user, int status, LocalDateTime date) {
		this.id = id;
		this.user = user;
		this.status = status;
		this.date = date;
	}

	public OrderVo(UserVo user, int status, LocalDateTime date) {
	 
		this.user = user;
		this.status = status;
		this.date = date;
	}
	

	public OrderVo() {
	}


}