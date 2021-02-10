package com.hcl.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="USER")
public class User implements Serializable {

	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userid;
	
	
	@Column(name="EMAIL")
	@NotBlank(message = "Email not be empty")
	private String email;
	
	
	@Column(name="NAME")
	@NotEmpty(message="Name should not be blank")
	private String name;
	
	
	@Column(name="PASSWORD")
	@NotBlank(message = "Password must not be blank")
	@Size(min = 8, message = "Password contains minimum 8 charecters")
    private String password;
	
	/*@Column(name="ADDRESS")
	private String address;*/
	
	@OneToMany
	@JoinColumn(name = "User_id")
	private List<Pet> myPets;

	public User() {
	}


	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}
	

	/*public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
*/

	public List<Pet> getMyPets() {
		return myPets;
	}


	public void setMyPets(List<Pet> myPets) {
		this.myPets = myPets;
	}


public User(Integer userid, String email, String name, String password, List<Pet> myPets){
		super();
		this.userid = userid;
		this.email = email;
		this.name = name;
		this.password = password;
		//this.address = address;
		this.myPets = myPets;
	}


	
	
	
	

}
