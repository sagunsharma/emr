package com.candela.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "emr_patientdetails")
@NoArgsConstructor
@AllArgsConstructor
public class PatientDetails implements Cloneable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    @Column(name = "mailid")
    String mailId;
    @Column(name = "phoneno")
    String phoneNo;
    String gender;
    String dob;
    int age;
    String height;
    String weight;
}
