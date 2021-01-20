package ma.pfa.springsecurity.domaine;

import lombok.Data;

@Data
public class CatVo {
	private Long id;
	private String name; 
	public CatVo() {
		super();
	}
	public CatVo(Long id, String name) {
		this(name);
		this.id = id;
	}
	
	public CatVo(String name) {
		super();
		this.name = name; 
	}
}