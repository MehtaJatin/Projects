package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenderRepository extends JpaRepository<VenderInfo,Integer>{

	public VenderInfo findByName(String v);
}
