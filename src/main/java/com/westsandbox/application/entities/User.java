package com.westsandbox.application.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private UserType userType;
	// @ManyToMany
	// @JoinTable(name = "GUEST_RESTAURANT", joinColumns =
	// 	@JoinColumn(name = "ID_GUEST"), inverseJoinColumns = 
	// 	@JoinColumn(name = "ID_REST"))
	// private Collection<Restaurant> restaurants;
	
	public enum UserType {
		STUDENT, COUNSELOR, PARENT
	}

	public User(String firstName, String lastName, String email, String password, UserType userType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userType = userType;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + " password=" + "]";
	}
	
	public User() {
		super();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

	
}
