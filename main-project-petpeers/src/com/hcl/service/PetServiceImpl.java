package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dao.PetDao;
import com.hcl.pojo.User;
import com.hcl.pojo.Pet;

@Service
public class PetServiceImpl implements PetService {
	@Autowired
	PetDao petDao;

	public String addPet(Pet pet, User user) {
		// TODO Auto-generated method stub
		return petDao.addPet(pet, user);
	}

	public List<Pet> displayPets(User user) {
		// TODO Auto-generated method stub
		for (Pet pet : petDao.displayPets(user)) {
			System.out.println("In Pet Service - " + pet.getPetbreed());
		}
		return petDao.displayPets(user);

	}

	public Pet buyPet(int pid, User user) {
		// TODO Auto-generated method stub
		return petDao.buyPet(pid, user);
	}

	public List<Pet> displayPetsAvailable() {
		// TODO Auto-generated method stub
		return petDao.displayPetsAvailable();
	}

}
