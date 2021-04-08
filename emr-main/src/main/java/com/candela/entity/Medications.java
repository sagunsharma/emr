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
@Table(name = "emr_medications")
@NoArgsConstructor
@AllArgsConstructor
public class Medications {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "patientid")
    String patientId;
    @Column(name = "medicationname")
    String medicationName;
    @Column(name = "strength")
    String strength;
    @Column(name = "timeperiod")
    Timestamp timePeriod;
    boolean active;
}
