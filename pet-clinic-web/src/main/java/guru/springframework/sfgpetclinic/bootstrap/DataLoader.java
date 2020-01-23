package guru.springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.PetServiceMap;
import guru.springframework.sfgpetclinic.services.map.PetTypeMapService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger("DataLoader.class");
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialityService;
    private final PetServiceMap petService;
    
    public DataLoader(OwnerService ownerService, VetService vetService, 
    				PetTypeService petTypeService, SpecialtyService specialityService, PetServiceMap petService) {
		this.vetService = vetService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
		this.petService = petService;
    }
    
    @Override
    public void run(String... args) throws Exception {
 
    	int count = petTypeService.findAll().size();
    	
    	if (count == 0) {
    		loadData();
    	}
    }

	private void loadData() {
		// Load Pet Types
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);
        
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);
        
        LOGGER.info("");
        ((PetTypeMapService) petTypeService).findAll().forEach(element -> LOGGER.info("> {}", element.toString()));
        LOGGER.info("***** Loaded pet types...");
    	
        
        
        // Load specialties
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);
        
        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);
                
        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);
        
        LOGGER.info("");
        ((SpecialityMapService) specialityService).findAll().forEach(element -> LOGGER.info("> {}", element.toString()));
        LOGGER.info("***** Loaded specialities...");
        
        
        
    	// Load Owner 1
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel Ave");
        owner1.setCity("Miami");
        owner1.setTelephone("1231231234");
        ownerService.save(owner1);
        
        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);
        
        // Load Owner 2
        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickerel Ave");
        owner2.setCity("Miami");
        owner2.setTelephone("1231231234");
        ownerService.save(owner2);
        
        Pet fionasPet = new Pet();
        fionasPet.setPetType(savedCatPetType);
        fionasPet.setOwner(owner2);
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setName("Just Cat");
        owner2.getPets().add(fionasPet);
        
        LOGGER.info("");
        ((OwnerServiceMap) ownerService).findAll().forEach(element -> LOGGER.info("> {}", element.toString()));
        LOGGER.info("***** Loaded owners...");
        
        
    	// Load Vet 1
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);
        
        // Load Vet 2
        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);
        vet2.getSpecialities().add(savedDentistry);
        vetService.save(vet2);
        
        LOGGER.info("");
        ((VetServiceMap) vetService).findAll().forEach(element -> LOGGER.info("> {}", element.toString()));
        LOGGER.info("***** Loaded vets...");
	}
}
