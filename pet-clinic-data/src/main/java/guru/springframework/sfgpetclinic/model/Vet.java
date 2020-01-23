package guru.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {
	
	private Set<Speciality> specialities = new HashSet<>();

	public Set<Speciality> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(Set<Speciality> specialities) {
		this.specialities = specialities;
	}

	@Override
	public String toString() {
//		return "Vet [specialities=" + specialities + "]";
		return "Vet [name=" + super.getFirstName() + super.getLastName() + ", specialities=" + specialities + "]";
	}

}
