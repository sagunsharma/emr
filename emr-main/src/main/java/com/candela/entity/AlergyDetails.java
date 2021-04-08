package com.candela.entity;

import java.sql.Timestamp;

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
@Table(name = "emr_patient_alergy_details")
@NoArgsConstructor
@AllArgsConstructor
public class AlergyDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "patientid")
    String patientId;
    @Column(name = "alergy_name")
    String alergyName;
    @Column(name = "details")
    String details;
    @Column(name = "timeperiod")
    Timestamp timePeriod;
    boolean active;
}
