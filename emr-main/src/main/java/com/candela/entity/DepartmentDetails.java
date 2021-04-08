package com.candela.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "emr_departmentdetails")
@NoArgsConstructor
public class DepartmentDetails {
    @Id
    String id;
    String name;
    String departmentcode;
    int amount;
    
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "departmentDoctor")
//    private List<DoctorDetails> doctorDetails;
//    
//    @OneToOne(fetch = FetchType.LAZY, mappedBy = "departmentUser")
//    private User userDepartment;
//
//    public DepartmentDetails(String name) {
//        this.name = name;
//    }
//    public DepartmentDetails(String id, String name) {
//        this.id = id;
//        this.name = name;
//    }
}
