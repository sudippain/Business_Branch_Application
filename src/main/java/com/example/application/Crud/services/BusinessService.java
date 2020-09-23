package com.example.application.Crud.services;

import java.util.List;

import com.example.application.Crud.exception.BusinessAlreadyExistsException;
import com.example.application.Crud.exception.BusinessNotFoundException;
import com.example.application.Crud.model.Business;


public interface BusinessService {

	boolean saveBusiness(Business business) throws BusinessAlreadyExistsException;

	boolean updateBusiness(Business business, int id) throws BusinessNotFoundException;

	List<Business> searchByBusinessName(String serchBusinessName) throws BusinessNotFoundException;

	List<Business> searchByPan(String searchByPan) throws BusinessNotFoundException;
	
}
