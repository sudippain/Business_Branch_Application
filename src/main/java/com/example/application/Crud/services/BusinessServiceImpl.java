package com.example.application.Crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.Crud.exception.BusinessAlreadyExistsException;
import com.example.application.Crud.exception.BusinessNotFoundException;
import com.example.application.Crud.model.Business;
import com.example.application.Crud.repo.BusinessRepo;


@Service
public class BusinessServiceImpl implements BusinessService {

	
	@Autowired
	private BusinessRepo businessRepo;

	/**
	 * @param userRepo
	 */
	public BusinessServiceImpl(BusinessRepo businessRepo) {
		super();
		this.businessRepo = businessRepo;
	}

	@Override
	public boolean saveBusiness(Business business) throws BusinessAlreadyExistsException {
		Optional<Business> existingBusiness = businessRepo.findById(business.getBusiness_id());
		if (existingBusiness.isPresent()) {
			throw new BusinessAlreadyExistsException("Business with id already exists");
		}
		businessRepo.save(business);
		return true;
	}

	@Override
	public boolean updateBusiness(Business business, int id) throws BusinessNotFoundException {
		
		Optional<Business> existingBusiness = businessRepo.findById(id);
		if (existingBusiness.isPresent()) {
			business.setBusiness_id(id);
			businessRepo.save(business);
		}
		else {
			throw new BusinessNotFoundException("There is no business with this id");
		}
		
		return true;
	}

	@Override
	public List<Business> searchByBusinessName(String serchBusinessName) throws BusinessNotFoundException {
		
		List<Business> list = businessRepo.findByBusinessName(serchBusinessName);
		if(list.size()==0) {
			throw new  BusinessNotFoundException("There is no business with this Name");
		}
	
		return list;
	}

	@Override
	public List<Business> searchByPan(String searchByPan) throws BusinessNotFoundException {
		
		
		
		List<Business> list1 = businessRepo.findByPan(searchByPan);
		if(list1.size()==0) {
			throw new  BusinessNotFoundException("There is no business with this Pan Id");
		}
	
		return list1;
	}
	
	
	

}
