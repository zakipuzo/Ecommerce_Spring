package ma.pfa.springsecurity.domaine;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserVo {
	private Long id;
	@Length(min = 3, message = "*Your name must have at least 3 characters")
	@NotEmpty(message = "*Please provide an  name")
	private String name;

	@Length(min = 5, message = "*Your username must have at least 5 characters")
	@NotEmpty(message = "*Please provide an user name")
	private String username;

	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	private String password;
	private List<RoleVo> roles = new ArrayList<RoleVo>();

	public UserVo(String name,String username, String password,List<RoleVo> roles) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.roles=roles;
	}
}