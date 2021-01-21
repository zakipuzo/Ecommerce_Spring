package ma.pfa.springsecurity.presentation;

import java.util.Arrays;

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
import ma.pfa.springsecurity.service.IUserService;

@Controller
public class LoginController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = {  "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}



	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	 
		if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
			modelAndView.addObject("admin", auth.getName());
		}

		return modelAndView;
	}

	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(Model m) {
		
	
		m.addAttribute("userVo", new UserVo());
		ModelAndView modelAndView = new ModelAndView(); 
		modelAndView.setViewName("register");
		return modelAndView;
	}


	
	@RequestMapping(value = "/newregistration", method = RequestMethod.POST)
	public String newregistration(@Valid @ModelAttribute("userVo") UserVo user, BindingResult br) {
		
		 
		if(br.hasErrors())  
        {  

            return "register";  
		}  
		else{
			try{
				RoleVo roleClient = userService.getRoleByName("CLIENT"); 
			user.setRoles(Arrays.asList(roleClient));
			userService.save(user);
			}
			catch(TransactionException e){
				
			}
			
		   System.out.println(user);
	   
		   
		   return "redirect:/";
		}
	
	}

	 

	
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		modelAndView.addObject("userLogIn", auth.getName());
		modelAndView.setViewName("welcome");
		return modelAndView;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView methodForAdmin() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		modelAndView.addObject("userName", "Welcome " + auth.getName());
		modelAndView.addObject("adminMessage", "Content Available Only for Admins with ADMIN Role");
		modelAndView.setViewName("/admin/admin");
		return modelAndView;
	}
	
	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public ModelAndView methodForClient() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		modelAndView.addObject("userName", "Welcome " + auth.getName());
		modelAndView.addObject("clientMessage", "Content Available Only for Clients with CLIENT Role");
		modelAndView.setViewName("client/client");
		return modelAndView;
	}

	@RequestMapping(value = "/access-denied", method = RequestMethod.GET)
	public ModelAndView accessdenied() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("access-denied");
		return modelAndView;
	}
}