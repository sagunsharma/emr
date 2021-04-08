package com.candela.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.candela.entity.emp;
	@Repository
	public interface emprepo extends JpaRepository<emp, Long> {

	}


