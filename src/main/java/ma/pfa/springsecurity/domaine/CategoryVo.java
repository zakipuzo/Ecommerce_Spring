package ma.pfa.springsecurity.domaine;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryVo {
	private Long id;
	private String name; 
	 
	public CategoryVo(Long id, String name) {
		this(name);
		this.id = id;
	}
	
	public CategoryVo(String name) {
		super();
		this.name = name; 
	}
}