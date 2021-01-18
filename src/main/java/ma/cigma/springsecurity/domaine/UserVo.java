package ma.cigma.springsecurity.domaine;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserVo {
	private Long id;
	private String name;
	private String username;
	private String password;
	private List<RoleVo> roles = new ArrayList<RoleVo>();

	public UserVo(String username, String password, String name,List<RoleVo> roles) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.roles=roles;
	}
}