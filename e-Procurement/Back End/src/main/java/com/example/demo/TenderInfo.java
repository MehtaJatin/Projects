package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tenderinfo")
public class TenderInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idtenderinfo")
	private int id;
	
	@Column(name= "tenderid")
	private String tenderid;
	
	@Column(name= "tendername")
	private String tendername;
	
	@Column(name= "department")
	private String department;
	
	@Column(name= "publishdate")
	private String publishdate;
	
	@Column(name= "opendate")
	private String opendate;
	
	@Column(name= "closingdate")
	private String closingdate;
	
	@Column(name= "classification")
	private String classification;
	
	@Column(name="status")
	private String status;
	
	@Column(name="specification")
	private String specification;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="base")
	private String base;
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenderid() {
		return tenderid;
	}

	public void setTenderid(String tenderid) {
		this.tenderid = tenderid;
	}

	public String getTendername() {
		return tendername;
	}

	public void setTendername(String tendername) {
		this.tendername = tendername;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}

	public String getOpendate() {
		return opendate;
	}

	public void setOpendate(String opendate) {
		this.opendate = opendate;
	}

	public String getClosingdate() {
		return closingdate;
	}

	public void setClosingdate(String closingdate) {
		this.closingdate = closingdate;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	@Override
	public String toString() {
		return "TenderInfo [id=" + id + ", tenderid=" + tenderid + ", tendername=" + tendername + ", department="
				+ department + ", publishdate=" + publishdate + ", opendate=" + opendate + ", closingdate="
				+ closingdate + ", classification=" + classification + "]";
	}
	
	
	
	

}
