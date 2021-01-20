package ma.pfa.springsecurity;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ma.pfa.springsecurity.domaine.ProductVo;
import ma.pfa.springsecurity.domaine.RoleVo;
import ma.pfa.springsecurity.domaine.UserVo;
import ma.pfa.springsecurity.service.IProductService;
import ma.pfa.springsecurity.service.IUserService;

@SpringBootApplication
public class Pfa_APP implements CommandLineRunner {

	@Autowired
	private IUserService userService;
	@Autowired
	private IProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(Pfa_APP.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Override
	public void run(String... args) throws Exception {
	/*	userService.cleanDataBase();
		userService.save(new RoleVo("ADMIN"));
		userService.save(new RoleVo("CLIENT"));

		RoleVo roleAdmin = userService.getRoleByName("ADMIN");
		RoleVo roleClient = userService.getRoleByName("CLIENT");
		UserVo admin1 = new UserVo("Zakaria","admin1", "admin1", Arrays.asList(roleAdmin));
		UserVo admin2 = new UserVo("Zaki","admin2", "admin2", Arrays.asList(roleAdmin));
		UserVo client1 = new UserVo("Ahmed","client1", "client1", Arrays.asList(roleClient));
		userService.save(admin1);
		userService.save(client1);
		userService.save(admin2);

		// *************
		productService.save(new ProductVo("product1","ezez",  10000d, 5, "url")); */

	}

}
