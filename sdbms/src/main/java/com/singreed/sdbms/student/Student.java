package com.singreed.sdbms.student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "student")
public class Student {
	
	@Id
	int id;
	
	@Column(name = "name")
	String name;
	
	@Column(name="phonenumber")
	String phonenumber;
	
	@Column(name="address")
	String address;
	
	@Column(name="bg")
	String bg;
	
	public Student(int id, String name, String phonenumber, String address, String bg) {
		super();
		this.id = id;
		this.name = name;
		this.phonenumber = phonenumber;
		this.address = address;
		this.bg = bg;
	}
	public Student() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBg() {
		return bg;
	}
	public void setBg(String bg) {
		this.bg = bg;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", phonenumber=" + phonenumber + ", address=" + address
				+ ", bg=" + bg + "]";
	}
	


}
