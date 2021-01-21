package ma.pfa.springsecurity.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import ma.pfa.springsecurity.domaine.CategoryVo;
import ma.pfa.springsecurity.service.ICategoryService;


public class Helper {

    @Autowired
    private ICategoryService service;
    
    public  List<CategoryVo> categories(){
        List<CategoryVo> list = service.getCategories(); 
      
        return  list;
    }
    
}
