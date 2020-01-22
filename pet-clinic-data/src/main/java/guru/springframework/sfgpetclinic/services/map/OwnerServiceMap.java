package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetTypeService petTypeSetvice;
	private final PetService petService;
	
    public OwnerServiceMap(PetTypeService petTypeSetvice, PetService petService) {
		super();
		this.petTypeSetvice = petTypeSetvice;
		this.petService = petService;
	}

	@Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
    	
    	if (object != null) {	
    		if (object.getPets() != null) {
    			// Owner has at least 1 pet
    			object.getPets().forEach(pet -> {
    				if (pet.getPetType() != null) {
    					// Pet's pet type is not null
    					if (pet.getPetType().getId() == null) {
    						// If pet type is is null, persist pet type
    						pet.setPetType(petTypeSetvice.save(pet.getPetType()));
    					}
    				} else {
    					throw new RuntimeException("Pet Type is required");
    				}
    				
    				if (pet.getId() == null) {
    					// If pet is is null, it's a new pet. Persist it
    					Pet savedPet = petService.save(pet);
    					// Add newly persisted pet's id to a pet in Owner's HashSet
    					pet.setId(savedPet.getId());
    				}
    			});
    		}
            return super.save(object);
    	} else {
            return null;
    	}
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        // TODO Auto-generated method stub
        return null;
    }

}
