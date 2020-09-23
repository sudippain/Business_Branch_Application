package com.example.application.Crud.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.application.Crud.model.Business;

@Repository
public interface BusinessRepo extends JpaRepository<Business, Integer> {

	
	@Query("select bs from Business bs where bs.business_name like %:keyword%")
	List<Business> findByBusinessName(@Param("keyword") String serchBusinessName);
	@Query("select bs from Business bs where bs.pan = :panKey")
	List<Business> findByPan(@Param("panKey") String searchByPan);

	

}
