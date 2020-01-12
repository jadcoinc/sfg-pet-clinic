package guru.springframework.sfgpetclinic.controllers.vets.owners;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guru.springframework.sfgpetclinic.services.OwnerService;

@Controller
@RequestMapping(value = "/owners")
public class OwnersController {

    private final OwnerService ownerService;

    public OwnersController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping(value = {"", "/", "/index", "index.html"}, method = RequestMethod.GET)
    public String listOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

}
