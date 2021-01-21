package ma.pfa.springsecurity.service.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue
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

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles = new ArrayList<Role>();
}