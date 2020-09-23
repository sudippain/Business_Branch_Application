package com.example.application.Crud.model;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Business_Master")
public class Business {

	@Id
	
	int business_id;
	String business_name;
	String contact_no;
	String pan;
    Date created_date;
    Date updated_date;
    
    @JsonIgnore
    @OneToMany(
    		fetch = FetchType.LAZY,
            mappedBy = "business"
        )
   
        private List<Branch> branches = new ArrayList<>();

	public Business() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Business(int business_id, String business_name, String contact_no, String pan, Date created_date,
			Date updated_date, List<Branch> branches) {
		super();
		this.business_id = business_id;
		this.business_name = business_name;
		this.contact_no = contact_no;
		this.pan = pan;
		this.created_date = created_date;
		this.updated_date = updated_date;
		this.branches = branches;
	}

	public int getBusiness_id() {
		return business_id;
	}

	public void setBusiness_id(int business_id) {
		this.business_id = business_id;
	}

	public String getBusiness_name() {
		return business_name;
	}

	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
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

	public List<Branch> getbranches() {
		return branches;
	}

	public void setbranches(List<Branch> branches) {
		this.branches = branches;
	}

	@Override
	public String toString() {
		return "Branch [business_id=" + business_id + ", business_name=" + business_name + ", contact_no=" + contact_no
				+ ", pan=" + pan + ", created_date=" + created_date + ", updated_date=" + updated_date + ", branches="
				+ branches + "]";
	}
    

	 public void addComment(Branch branch) {
		 branches.add(branch);
		 branch.setBusiness(this);
	    }
	 
	    public void removeComment(Branch branch) {
	    	branches.remove(branch);
	    	branch.setBusiness(null);
	    }
}
