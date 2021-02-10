package com.hcl.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="PET")
public class Pet implements Serializable{
	@Id
	@Column(name="PET_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	
	@Column(name="PET_NAME")
	@NotBlank(message = "Name not be empty")
	private String pname;
	
	@Column(name="PET_BREED")
	private String petbreed;
	
	@Column(name="PET_AGE")
	private int age;
	
	@Column(name="PRICE")
	@NotNull
	private float price;
	
	
	
	@Column(name="GENDER")
	private String gender;
	@ManyToOne
	@JoinColumn(name = "User_id")
	private User user;

	public Pet() {
		
	}
	
	

	

	public Pet(int pid, String pname, String petbreed, int age, float price, String gender, User user) {
		this.pid = pid;
		this.pname = pname;
		this.petbreed = petbreed;
		this.age = age;
		this.price = price;
		this.gender = gender;
		this.user = user;
	}





	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPetbreed() {
		return petbreed;
	}

	public void setPetbreed(String petbreed) {
		this.petbreed = petbreed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

	public float getPrice() {
		return price;
	}



	public void setPrice(float price) {
		this.price = price;
	}



	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
