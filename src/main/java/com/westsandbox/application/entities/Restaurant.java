package com.westsandbox.application.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Restaurant implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int restId;
	private String restName;
	private String restZip;
	private String restCity;
	private String restPhoneNumber;
	
	@ManyToMany(mappedBy = "restaurants")
	private Collection<Guest> guests;
	
	public int getRestId() {
		return restId;
	}
	public void setRestId(int restId) {
		this.restId = restId;
	}
	public String getRestName() {
		return restName;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}
	public String getRestZip() {
		return restZip;
	}
	public void setRestZip(String restZip) {
		this.restZip = restZip;
	}
	public String getRestCity() {
		return restCity;
	}
	public void setRestCity(String restCity) {
		this.restCity = restCity;
	}
	public String getRestPhoneNumber() {
		return restPhoneNumber;
	}
	public void setRestPhoneNumber(String restPhoneNumber) {
		this.restPhoneNumber = restPhoneNumber;
	}
	public Collection<Guest> getGuests() {
		return guests;
	}
	public void setGuests(Collection<Guest> guests) {
		this.guests = guests;
	}
	public Restaurant(String restName, String restZip, String restCity, String restPhoneNumber) {
		super();
		this.restName = restName;
		this.restZip = restZip;
		this.restCity = restCity;
		this.restPhoneNumber = restPhoneNumber;
	}
	public Restaurant() {
		super();
	}
	@Override
	public String toString() {
		return "Restaurant [restId=" + restId + ", restName=" + restName + ", restZip=" + restZip + ", restCity="
				+ restCity + ", restPhoneNumber=" + restPhoneNumber + "]";
	}
	
	
}
