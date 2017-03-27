package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address{

	@Column 
   	private String street;

	@Column 
   	private String city;

   	public Address(String street, String city){
   		this.street = street;
   		this.city = city;
   	}

   	public Address(){
   		
   	}

   	public String getStreet(){
		return this.street;   		
   	}

   	public void setStreet(String street){
   		this.street = street;
   	}

   	public String getCity(){
   		return this.city;
   	}

   	public void setCity(String city){
   		this.city = city;
   	}
}