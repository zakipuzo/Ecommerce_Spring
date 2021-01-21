package ma.pfa.springsecurity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ma.pfa.springsecurity.domaine.CategoryVo;
import ma.pfa.springsecurity.domaine.OrderItemVo;
import ma.pfa.springsecurity.domaine.OrderVo;
import ma.pfa.springsecurity.domaine.ProductVo;
import ma.pfa.springsecurity.domaine.RoleVo;
import ma.pfa.springsecurity.domaine.UserVo;
import ma.pfa.springsecurity.service.ICategoryService;
import ma.pfa.springsecurity.service.IOrderItemService;
import ma.pfa.springsecurity.service.IOrderService;
import ma.pfa.springsecurity.service.IProductService;
import ma.pfa.springsecurity.service.IUserService;

@SpringBootApplication
public class Pfa_APP implements CommandLineRunner {

	@Autowired
	private IUserService userService;
	@Autowired
	private IProductService productService;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IOrderItemService orderItemService;

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
 		userService.cleanDataBase();
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

		List<UserVo> listusers= userService.getAllUsers();
		

		CategoryVo cat1=new CategoryVo("Téléphone");
		CategoryVo cat2=new CategoryVo("TV");
		CategoryVo cat3=new CategoryVo("PC Portable");
		categoryService.save(cat1);
		categoryService.save(cat2);
		categoryService.save(cat3);

		List<CategoryVo> listcat= categoryService.getCategories();
		

		ProductVo p1=new ProductVo("camera","amera ksqfs fdsfdsj fsdf",  2500d, 5, "url",listcat.get(0));
		ProductVo p2=new ProductVo("STv","amera ksqfs fdsfdsj fsdf",  1300d, 5, "url", listcat.get(1));
		ProductVo p3=new ProductVo("Samsung","amera ksqfs fdsfdsj fsdf",  3400d, 5, "url", listcat.get(1));
		ProductVo p4 =new ProductVo("Chaomi","amera ksqfs fdsfdsj fsdf",  9650d, 5, "url", listcat.get(2));
		
		
		productService.save(p1);  
		productService.save(p2);  
		productService.save(p3);  
		productService.save(p4); 
		
		List<ProductVo> listprod= productService.getProducts();
		

		 OrderVo o =new OrderVo (listusers.get(1), 0);

		orderService.save(o);
		List<OrderVo> listorder= orderService.getOrders();
		
		OrderItemVo oi=new OrderItemVo(listorder.get(0), listprod.get(0),4);
		 

		orderItemService.save(oi);
	}

}
