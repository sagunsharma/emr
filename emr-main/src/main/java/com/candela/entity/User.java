package com.candela.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name="emr_userdetails")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NotNull
    String name;
    @Column(name="mailid") @NotNull
    String mailId;
    @NotNull
    String password;
    Timestamp lastlogin;
    int status;
    @Column(name="doctor_id")
    String doctorId;
    @Column(name="department_id")
    String departmentId;
	public int getStatus() {
		// TODO Auto-generated method stub
		return this.status;
	}
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
    
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
//    DoctorDetails doctorUser;
//    
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
//    DepartmentDetails departmentUser;
}
