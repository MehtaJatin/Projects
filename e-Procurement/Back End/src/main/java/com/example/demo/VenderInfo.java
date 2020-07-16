package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="venderinfo")
public class VenderInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@javax.persistence.Column(name= "idvenderinfo")
	private int id;
	
	@javax.persistence.Column(name= "email")
	private String email;
	
	@javax.persistence.Column(name= "cemail")
	private String cemail;
	
	@javax.persistence.Column(name="pass")
	private String pass;
	
	@javax.persistence.Column(name= "phnumber")
	private String phnumber;
	
	@javax.persistence.Column(name= "cname")
	private String cname;
	
	@javax.persistence.Column(name= "regno")
	private String regno;
	
	@javax.persistence.Column(name= "regaddr")
	private String regaddr;
	
	@javax.persistence.Column(name= "citizen")
	private String citizen;
	
	@javax.persistence.Column(name= "city")
	private String city;
	
	@javax.persistence.Column(name= "state")
	private String state;
	
	@javax.persistence.Column(name= "pincode")
	private String pincode;
	
	@javax.persistence.Column(name= "pannumber")
	private String pannumber;
	
	@javax.persistence.Column(name= "eyear")
	private String eyear;
	
	@javax.persistence.Column(name= "name")
	private String name;
	
	@javax.persistence.Column(name= "dob")
	private String dob;
	
	@javax.persistence.Column(name= "des")
	private String des;
	
	@javax.persistence.Column(name= "phone")
	private String phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPhnumber() {
		return phnumber;
	}

	public void setPhnumber(String phnumber) {
		this.phnumber = phnumber;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getRegaddr() {
		return regaddr;
	}

	public void setRegaddr(String regaddr) {
		this.regaddr = regaddr;
	}

	public String getCitizen() {
		return citizen;
	}

	public void setCitizen(String citizen) {
		this.citizen = citizen;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPannumber() {
		return pannumber;
	}

	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}

	public String getEyear() {
		return eyear;
	}

	public void setEyear(String eyear) {
		this.eyear = eyear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
