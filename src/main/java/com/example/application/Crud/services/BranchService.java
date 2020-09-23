package com.example.application.Crud.services;

import java.text.ParseException;
import java.util.List;

import com.example.application.Crud.exception.BranchAlreadyExistsException;
import com.example.application.Crud.exception.BranchNotFoundException;
import com.example.application.Crud.exception.BusinessAlreadyExistsException;
import com.example.application.Crud.exception.BusinessNotFoundException;
import com.example.application.Crud.model.Branch;
import com.example.application.Crud.model.Business;

public interface BranchService {

	

	boolean saveBranch(Branch branch,int id) throws BranchAlreadyExistsException, BusinessNotFoundException;

	boolean updateBranch(Branch branch, int bs_id, int br_id) throws BranchNotFoundException, BusinessNotFoundException;

	List<Branch> searchByAddress(String address) throws BranchNotFoundException;

	List<Branch> searchByActiveInd(String status) throws BranchNotFoundException;

	List<Branch> searchByCreateDate(String createDate) throws BranchNotFoundException, ParseException;

}
