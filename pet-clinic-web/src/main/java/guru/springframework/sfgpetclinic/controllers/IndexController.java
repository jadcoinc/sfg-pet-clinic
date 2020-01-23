package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	@RequestMapping(value= {"", "/", "index", "index.html"}, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("welcome", "Index Page");
		return "index";
	}
	
    @RequestMapping(value="/oups", method=RequestMethod.GET)
    public String oupsHandler(Model model) {
    	return "notimplemented";
    }
	
}
