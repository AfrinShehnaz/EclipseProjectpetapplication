package com.hcl.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.pojo.User;
import com.hcl.pojo.Pet;
@Repository
@Transactional
public class PetDaoImpl implements PetDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public String addPet(Pet pet, User user) {
		// TODO Auto-generated method stub
		String message = "Sucessfully Registered";
		//pet.setUser(user);
		Session session = sessionFactory.getCurrentSession();
		if (session != null) {
			session.save(pet);
			return message;
		}
		return "Not Registered";
	}
		
	

	@Override
	public List<Pet> displayPets(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String sql = "from Pet p where p.user.id=:uid";
		List<Pet> mypet = session.createQuery(sql).setParameter("uid", user.getUserid()).list();
		return mypet;
	}

	@Override
	public Pet buyPet(int pid, User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Pet pet = (Pet) session.get(Pet.class, pid);
		if (pet != null) {
			pet.setUser(user);
			session.save(pet);
			Pet updated_pet = (Pet) session.get(Pet.class, pid);
			return updated_pet;
		}

		return null;
	}

	@Override
	public List<Pet> displayPetsAvailable() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String sql = "from pet p ";
		List<Pet> availPets = session.createQuery(sql).list();
		return availPets;
	}
		

}
