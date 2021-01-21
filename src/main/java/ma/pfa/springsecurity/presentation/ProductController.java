package ma.pfa.springsecurity.presentation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ma.pfa.springsecurity.aop.Admin1Profile;
import ma.pfa.springsecurity.aop.LogExecutionTime;
import ma.pfa.springsecurity.aop.Tracabilite;
import ma.pfa.springsecurity.domaine.ProductVo;
import ma.pfa.springsecurity.service.IProductService;
import ma.pfa.springsecurity.service.exception.BusinessException;

@Controller
//@RequestMapping("/admin/product")
@ControllerAdvice

public class ProductController {

	@Autowired
	private IProductService service;

	@ExceptionHandler(value = BusinessException.class)
	public String exception(Model m) {
		m.addAttribute("excep", true);
		List<ProductVo> list = service.getProducts();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		m.addAttribute("userName", "Welcome " + auth.getName());
		m.addAttribute("list", list);
		return "/admin/product/list";
	}


	@RequestMapping(value = {"/product/{id}"})
	public String getById(@PathVariable(required = false) Long id, Model m) {
	  
		//System.out.println("hhhhh "+id);
		if(id!=null){
			try{

			ProductVo product = service.getProductById(id); 
			if(product!=null){
					m.addAttribute("product", product); 
			return "/product";
			}

			}catch(Exception e){

			}
	  
		}
		 
		return "/index";
	}

	//
	//SEARCH
	//
	@RequestMapping(value = {"/search"})
	public String search(  Model m) {
		List<ProductVo> list = service.searchProduct("pro");
	 
			m.addAttribute("products", list); 
		System.out.println(list);

		return "/search";
	}
	

	@RequestMapping("/form")
	public String showform(Model m) {
		m.addAttribute("productVo", new ProductVo());
		return "/admin/product/edit";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@LogExecutionTime
	@Tracabilite
	public String save(@ModelAttribute("productVo") ProductVo product) {
		service.save(product);
		return "redirect:/admin/product/list";
	}

	@RequestMapping("/list")
	@LogExecutionTime
	@Tracabilite
	public String viewproduct(Model m) {
		List<ProductVo> list = service.getProducts();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		m.addAttribute("userName", "Welcome " + auth.getName());
		m.addAttribute("list", list);
		return "/admin/product/list";
	}

	@RequestMapping(value = "/edit/{id}")
	@Tracabilite
	public String edit(@PathVariable Long id, Model m) {
		ProductVo product = service.getProductById(id);
		m.addAttribute("productVo", product);
		return "/admin/product/edit";
	}
	@Tracabilite
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("productVo") ProductVo product) {
		service.save(product);
		return "redirect:/admin/product/view";
	}
	@Tracabilite
	@Admin1Profile
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id) {
		service.delete(id);
		return "redirect:/admin/product/list";
	}

	@RequestMapping("/product/salary/{salary}")
	public String getByPrice(@PathVariable Double salary, Model m) {
		List<ProductVo> list = service.findByPrice(salary);
		m.addAttribute("list", list);
		return "/admin/product/list";
	}

	

	/**
	 * Chercher la liste des productloyés ayant la même fonction
	 */
	@RequestMapping("/product/fonction/{fonction}")
	public String getByFonction(@PathVariable String fonction, Model m) {
		List<ProductVo> list = service.searchProduct(fonction);
		m.addAttribute("list", list);
		return "/admin/product/list";
	}

	/**
	 * Chercher la liste des productloyés ayant le même salaire et la même fonction
	 */
	@RequestMapping("/product/salary_and_fonction/{salary}/{fonction}")
	public String getBySalaryAndFonction(@PathVariable Double salary, @PathVariable String fonction, Model m) {
		List<ProductVo> list = service.findByPriceAndName(salary, fonction);
		m.addAttribute("list", list);
		return "/admin/product/list";
	}

	/**
	 * Chercher l'productloyé qui le grand salaire
	 */
	@RequestMapping("/max_salary")
	public String getMaxSalary(Model m) {
		ProductVo productVo = service.getEmpHavaingMaxSalary();
		List<ProductVo> list = new ArrayList<>();
		list.add(productVo);
		m.addAttribute("list", list);
		return "/admin/product/view";
	}

	/**
	 * Afficher la liste des productloyés en utilisant la pagination
	 */
	@RequestMapping("/pagination/{pageid}/{size}")
	public String pagination(@PathVariable int pageid, @PathVariable int size, Model m) {
		List<ProductVo> list = service.findAll(pageid, size);
		m.addAttribute("list", list);
		return "/admin/product/view";
	}

	/**
	 * Trier les productloyés par le nom de champs qu'on passe dans l'URL
	 */
	@RequestMapping("/sort/{fieldName}")
	public String sortBy(@PathVariable String fieldName, Model m) {
		List<ProductVo> list = service.sortBy(fieldName);
		m.addAttribute("list", list);
		return "/admin/product/view";
	}
}