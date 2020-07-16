package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bidtable")
public class BidValue {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idbidtable")
	private int id;
	
	@Column(name="tendervender")
	private String tendervender;
	
	public String getTendervender() {
		return tendervender;
	}
	public void setTendervender(String tendervender) {
		this.tendervender = tendervender;
	}
	@Column(name= "venderid")
	private String venderid;
	
	@Column(name= "tenderid")
	private String tenderid;
	
	@Column(name= "bidvalue")
	private int bidvalue;
	
	@Column(name="closingdate")
	private String closingdate;
	
	
	public String getClosingdate() {
		return closingdate;
	}
	public void setClosingdate(String closingdate) {
		this.closingdate = closingdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVenderid() {
		return venderid;
	}
	public void setVenderid(String venderid) {
		this.venderid = venderid;
	}
	public String getTenderid() {
		return tenderid;
	}
	public void setTenderid(String tenderid) {
		this.tenderid = tenderid;
	}
	public int getBidvalue() {
		return bidvalue;
	}
	public void setBidvalue(int bidvalue) {
		this.bidvalue = bidvalue;
	}
	
	
}
