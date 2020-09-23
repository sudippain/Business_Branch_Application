package com.example.application.Crud.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.Crud.exception.BranchAlreadyExistsException;
import com.example.application.Crud.exception.BranchNotFoundException;
import com.example.application.Crud.exception.BusinessAlreadyExistsException;
import com.example.application.Crud.exception.BusinessNotFoundException;
import com.example.application.Crud.model.Branch;
import com.example.application.Crud.model.Business;
import com.example.application.Crud.repo.BranchRepo;
import com.example.application.Crud.repo.BusinessRepo;


@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchRepo branchRepo;

	@Autowired
	private BusinessRepo businessRepo;
	/**
	 * @param userRepo
	 */
	public BranchServiceImpl(BranchRepo branchRepo) {
		super();
		this.branchRepo = branchRepo;
	}

	@Override
	public boolean saveBranch(Branch branch,int id) throws BranchAlreadyExistsException, BusinessNotFoundException {
		Optional<Business> existingBusiness = businessRepo.findById(id);
		if(existingBusiness.isPresent()) {
		Optional<Branch> existingBranch = branchRepo.findById(branch.getBranch_id());
		branch.setBusiness(existingBusiness.get());
		if (existingBranch.isPresent()) {
			throw new BranchAlreadyExistsException("Branch with id already exists");
		}
		branchRepo.save(branch);
		
	}
		else {
			throw new BusinessNotFoundException("Business donot exist's using this id");
		}
		return true;
	}

	@Override
	public boolean updateBranch(Branch branch, int bs_id, int br_id) throws BranchNotFoundException, BusinessNotFoundException {
		Optional<Business> existingBusiness = businessRepo.findById(bs_id);
		
		if (existingBusiness.isPresent()) {
			Optional<Branch> existingBranch = branchRepo.findById(br_id);
			if(existingBranch.isPresent()) {
				branch.setBranch_id(br_id);
				branchRepo.save(branch);
			}
			else {
				throw new BranchNotFoundException("There is no branch with this id");
			}
			
		}
		else {
			throw new BusinessNotFoundException("There is no business with this id");
		}
		
		return true;
	}

	@Override
	public List<Branch> searchByAddress(String address) throws BranchNotFoundException {
		
		List<Branch> list1 = branchRepo.findByAddress(address);
		if(list1.size()==0) {
			throw new  BranchNotFoundException("There is no branch with this address");
		}
	
		return list1;
	}

	@Override
	public List<Branch> searchByActiveInd(String status) throws BranchNotFoundException {
		List<Branch> list1 = branchRepo.findByActiveInd(status);
		if(list1.size()==0) {
			throw new  BranchNotFoundException("There is no branch with this status");
		}
	
		return list1;
	}

	@Override
	public List<Branch> searchByCreateDate(String createDate) throws BranchNotFoundException, ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf1.parse(createDate);
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
		
		List<Branch> list1 = branchRepo.FindByCreateDate(sqlStartDate);
		if(list1.size()==0) {
			throw new  BranchNotFoundException("There is no branch with this status");
		}
	
		return list1;
	}
}
