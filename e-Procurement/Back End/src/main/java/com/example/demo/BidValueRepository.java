package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BidValueRepository extends JpaRepository<BidValue,Integer>
{
	@Query(value="SELECT * FROM bidtable WHERE closingdate < :actdate",nativeQuery=true)
    public List<BidValue> findresult(@Param("actdate") String date);

}
