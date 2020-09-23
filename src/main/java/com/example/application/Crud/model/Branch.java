package com.example.application.Crud.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Branch_Master")
public class Branch {

	@Id

	int branch_id;
	
	String branch_address;
	String branch_contact;
	String active_ind;
	Date created_date ;
	Date updated_date;
	

	 @ManyToOne
	    @JoinColumn(name = "business_id")
    private Business business;

	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Branch(int branch_id, int business_id, String branch_address, String branch_contact, String active_ind,
			Date created_date, Date updated_date) {
		super();
		this.branch_id = branch_id;
		
		this.branch_address = branch_address;
		this.branch_contact = branch_contact;
		this.active_ind = active_ind;
		this.created_date = created_date;
		this.updated_date = updated_date;
		
	}

	public Branch(int branch_id, int business_id, String branch_address, String branch_contact, String active_ind,
			Date created_date, Date updated_date, Business business) {
		super();
		this.branch_id = branch_id;
		
		this.branch_address = branch_address;
		this.branch_contact = branch_contact;
		this.active_ind = active_ind;
		this.created_date = created_date;
		this.updated_date = updated_date;
		this.business = business;
	}

	public int getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}




	public String getBranch_address() {
		return branch_address;
	}

	public void setBranch_address(String branch_address) {
		this.branch_address = branch_address;
	}

	public String getBranch_contact() {
		return branch_contact;
	}

	public void setBranch_contact(String branch_contact) {
		this.branch_contact = branch_contact;
	}

	public String getActive_ind() {
		return active_ind;
	}

	public void setActive_ind(String active_ind) {
		this.active_ind = active_ind;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}

	
	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	@Override
	public String toString() {
		return "Branch [branch_id=" + branch_id + ",  branch_address=" + branch_address
				+ ", branch_contact=" + branch_contact + ", active_ind=" + active_ind + ", created_date=" + created_date
				+ ", updated_date=" + updated_date + ", business=" + business + "]";
	}
	
	
}
