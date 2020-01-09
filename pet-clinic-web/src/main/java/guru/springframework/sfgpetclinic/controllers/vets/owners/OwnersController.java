package guru.springframework.sfgpetclinic.controllers.vets.owners;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/owners")
public class OwnersController {

	@RequestMapping(value = {"", "/", "/index", "index.html"}, method = RequestMethod.GET)
	public String listOwners(Model model) {
		model.addAttribute("ownersText", "List of Owners");
		return "owners/index";
	}
	
}
