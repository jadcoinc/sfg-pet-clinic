package guru.springframework.sfgpetclinic.controllers.vets;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guru.springframework.sfgpetclinic.services.VetService;

@Controller
public class VetsController {

    private final VetService vetService;
    
    public VetsController(VetService vetService) {
        super();
        this.vetService = vetService;
    }

    @RequestMapping(value = {"/vets", "/vets.html", "/vets/index", "/vets/index.html"}, method = RequestMethod.GET)
    public String listVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }

}
