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
	@Length(min = 3, message = "*Le nom doit avoir plus de 3 caractères")
	@NotEmpty(message = "*Ce champ est requis")
	private String name;

	@Length(min = 5, message = "*Le nom doit avoir plus de 5 caractères")
	@NotEmpty(message = "*Ce champ est requis")
	private String username;

	@Length(min = 5, message = "*Le nom doit avoir plus de 5 caractères")
	@NotEmpty(message = "*Ce champ est requis")
	private String password;
	private List<RoleVo> roles = new ArrayList<RoleVo>();

	public UserVo(String name,String username, String password,List<RoleVo> roles) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.roles=roles;
	}
}