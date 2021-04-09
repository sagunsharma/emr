package com.candela.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.candela.entity.ProcessEncounter;
@Repository
public interface EmrEncountersRepo extends JpaRepository<ProcessEncounter, Integer>
{

	ProcessEncounter findAllById(int id);
	ProcessEncounter findByPatientId(String id);
	


	
  
 

}
