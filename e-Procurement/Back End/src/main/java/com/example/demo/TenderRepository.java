package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TenderRepository extends JpaRepository<TenderInfo,Integer> {

	
	public List<TenderInfo> findByClassification(String classi);
	public TenderInfo findByTenderid(String t);
	public List<TenderInfo> findByStatus(String sta);
	
	
	@Query(value="SELECT * FROM tenderinfo WHERE closingdate > :actdate",nativeQuery=true)
    public List<TenderInfo> findByDate(@Param("actdate") String date);
}
