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
import ma.pfa.springsecurity.domaine.CategoryVo;
import ma.pfa.springsecurity.domaine.ProductVo;
import ma.pfa.springsecurity.service.ICategoryService;
import ma.pfa.springsecurity.service.exception.BusinessException;

@Controller
//@RequestMapping("/admin/category")
@ControllerAdvice

public class CategoryController {

	@Autowired
	private ICategoryService service;

	@ExceptionHandler(value = BusinessException.class)
	public String exception(Model m) {
		m.addAttribute("excep", true);
		List<CategoryVo> list = service.getCategories();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		m.addAttribute("userName", "Welcome " + auth.getName());
		m.addAttribute("list", list);
		return "/admin/category/list";
	}


	@RequestMapping(value = {"/category/{id}"})
	public String getById(@PathVariable(required = false) Long id, Model m) {
	  
		//System.out.println("hhhhh "+id);
		if(id!=null){
			try{

			CategoryVo category = service.getCategoryById(id); 
			List<CategoryVo> lst = service.getCategories(); 
			m.addAttribute("categories", lst);
			List<ProductVo> list = service.searchByCategory(id);
			m.addAttribute("category", category.getName()); 
			m.addAttribute("products", list); 
			if(category!=null){

			
					m.addAttribute("category", category); 
			return "/category";
			}

			}catch(Exception e){

			}
	  
		}
		 
		return "/index";
	}

 
	@RequestMapping("/category/add")
	public String showform(Model m) {
		m.addAttribute("categoryVo", new CategoryVo());
		return "/admin/category/createoredit";
	}

	@RequestMapping(value = "/category/save", method = RequestMethod.POST)
	@LogExecutionTime
	@Tracabilite
	public String save(@ModelAttribute("categoryVo") CategoryVo category) {
		service.save(category);
		return "redirect:/admin/category/list";
	}

	@RequestMapping("/category/list")
	@LogExecutionTime
	@Tracabilite
	public String categoryList(Model m) {
		List<CategoryVo> list = service.getCategories();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		m.addAttribute("userName", "Welcome " + auth.getName());
		m.addAttribute("categories", list);
		return "/category/list";
	}

	@RequestMapping(value = "/category/edit/{id}")
	@Tracabilite
	public String edit(@PathVariable Long id, Model m) {
		CategoryVo category = service.getCategoryById(id);
		m.addAttribute("categoryVo", category);
		return "/admin/category/edit";
	}
	@Tracabilite
	@RequestMapping(value = "/category/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("categoryVo") CategoryVo category) {
		service.save(category);
		return "redirect:/admin/category/view";
	}
	@Tracabilite
	@Admin1Profile
	@RequestMapping(value = "/category/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id) {
		service.delete(id);
		return "redirect:/admin/category/list";
	}
 

	 
	 
}