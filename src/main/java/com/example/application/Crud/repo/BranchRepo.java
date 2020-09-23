package com.example.application.Crud.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.application.Crud.model.Branch;
import com.example.application.Crud.model.Business;

@Repository
public interface BranchRepo extends JpaRepository<Branch, Integer> {

	@Query("select br from Branch br where br.branch_address = :addressKey")
	List<Branch> findByAddress(@Param("addressKey") String address);
	
	@Query("select br from Branch br where br.active_ind = :statusKey")
	List<Branch> findByActiveInd(@Param("statusKey") String status);
	

}
