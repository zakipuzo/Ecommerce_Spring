package ma.pfa.springsecurity.presentation;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ma.pfa.springsecurity.domaine.RoleVo;
import ma.pfa.springsecurity.domaine.UserVo;
import ma.pfa.springsecurity.domaine.CategoryVo;
import ma.pfa.springsecurity.service.ICategoryService;
import ma.pfa.springsecurity.service.IUserService;

@Controller
public class AdminController {

	@Autowired
	private ICategoryService service;


	@RequestMapping(value = { "/admin/dashbord" }, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/dashbord");
		
		List<CategoryVo> list = service.getCategories(); 

		modelAndView.addObject("categories", list);

	
		return modelAndView;
	}
}