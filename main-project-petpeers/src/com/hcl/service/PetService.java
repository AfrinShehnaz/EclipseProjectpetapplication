package com.hcl.service;

import java.util.List;

import com.hcl.pojo.User;
import com.hcl.pojo.Pet;

public interface PetService {

	String addPet(Pet pet,User user);
	List<Pet> displayPets(User user);
	Pet buyPet(int pid,User user);
	List<Pet> displayPetsAvailable();
}
