package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Vet;

public interface VerService extends CrudService<Vet, Long> {

	Vet findByLastName(String lastName);

}
