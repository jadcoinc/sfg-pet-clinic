package guru.springframework.sfgpetclinic.services;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Vet;

public interface VerService {


	Vet findByLastName(String lastName);
	
	Vet byndById(Long id);
	
	Vet save(Vet Vet);
	
	Set<Vet> findAll();
}
