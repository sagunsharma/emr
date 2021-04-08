package com.candela.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "emr_doctordetails")
@NoArgsConstructor
public class DoctorDetails {
    @Id
    String id;
    String name;
    String graduation;
    String experience;
    @Column(name = "department_id")
    String departmentId;
    String notes;
    int status;
    @Column(name = "phoneno")
    String phoneNo;
    @Column(name = "mailid")
    String mailId;
    @Column(name = "alternatemailid")
    String alternateMailId;
    int amount;
    String specialisation;
    String gender;
    @Column(name = "registrationno")
    String registrationNo;

////    TODO: Revert to lazy if not required
//    @ManyToOne(fetch = FetchType.LAZY)
////    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
//    DepartmentDetails departmentDoctor;
//
//    @OneToOne(fetch = FetchType.LAZY, mappedBy = "doctorUser")
//    private User userDoctor;
//
//    public DoctorDetails(String name) {
//        this.name = name;
//    }
}
