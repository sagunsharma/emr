package com.candela.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emr_encounters")
public class ProcessEncounter 
{
	
	private int id;
	 

	 @Id 
	 @GeneratedValue(strategy = GenerationType.SEQUENCE)
	 @Column(name = "details")
private	String details;
	
@Column(name = "patientid")
private	String patientid;
	
	@Column(name = "updatedat")
     private Date updatedat;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getPatientid() {
		return patientid;
	}

	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}

	public Date getUpdatedat() {
		return updatedat;
	}

	public void setUpdatedat(Date updatedat) {
		this.updatedat = updatedat;
	}

	public ProcessEncounter(int id, String details, String patientid, Date updatedat) {
		super();
		this.id = id;
		this.details = details;
		this.patientid = patientid;
		this.updatedat = updatedat;
	}

	public ProcessEncounter() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
}
 

	