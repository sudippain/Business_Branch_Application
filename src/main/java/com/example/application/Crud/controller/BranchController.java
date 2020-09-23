package com.example.application.Crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.Crud.exception.BranchAlreadyExistsException;
import com.example.application.Crud.exception.BranchNotFoundException;
import com.example.application.Crud.exception.BusinessAlreadyExistsException;
import com.example.application.Crud.exception.BusinessNotFoundException;
import com.example.application.Crud.model.Branch;
import com.example.application.Crud.model.Business;
import com.example.application.Crud.services.BranchService;
import com.example.application.Crud.services.BusinessService;

@RestController
@RequestMapping("/branch")
public class BranchController {

	@Autowired
	private BranchService branchService;
	
	@PostMapping("/add/{id}")
	public ResponseEntity<?> addBranch(@RequestBody Branch branch ,@PathVariable int id) {
		try {
			branchService.saveBranch(branch,id);
			return new ResponseEntity<Branch>(branch, HttpStatus.CREATED);
		} catch (BranchAlreadyExistsException e) {
			return new ResponseEntity<String>("{ \"message\": \"" + e.getMessage() + "\"}", HttpStatus.CONFLICT);
		}
		catch(Exception e){
			return new ResponseEntity<String>("{ \"message\": \"" + e.getMessage() + "\"}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
	
	@PutMapping("/update/{bs_id}/{br_id}")
	public ResponseEntity<?> updateBusiness(@RequestBody Branch branch,@PathVariable int bs_id,@PathVariable int br_id) {
		try {
			branchService.updateBranch(branch,bs_id,br_id);
			return new ResponseEntity<Branch>(branch, HttpStatus.OK);
		} catch (BranchNotFoundException e) {
			return new ResponseEntity<String>("{ \"message\": \"" + e.getMessage() + "\"}", HttpStatus.CONFLICT);
		}
		catch(Exception e){
			return new ResponseEntity<String>("{ \"message\": \"" + e.getMessage() + "\"}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/serach/ByBranchAddress/{address}")
	public ResponseEntity<?> serachByPan(@PathVariable String address) {
	 System.out.println(address);
		try {
			List<Branch> blist = branchService.searchByAddress(address);
			return new ResponseEntity<List<Branch>>(blist, HttpStatus.OK);
		} catch(Exception e){
			return new ResponseEntity<String>("{ \"message\": \"" + e.getMessage() + "\"}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/serach/ByActiveInd/{status}")
	public ResponseEntity<?> serachByActiveInd(@PathVariable String status) {
	
		try {
			List<Branch> blist = branchService.searchByActiveInd(status);
			return new ResponseEntity<List<Branch>>(blist, HttpStatus.OK);
		} catch(Exception e){
			return new ResponseEntity<String>("{ \"message\": \"" + e.getMessage() + "\"}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/serach/ByCreateDate/{createDate}")
	public ResponseEntity<?> SerachByCreateDate(@PathVariable String createDate) {
	
		try {
			List<Branch> blist = branchService.searchByCreateDate(createDate);
			return new ResponseEntity<List<Branch>>(blist, HttpStatus.OK);
		} catch(Exception e){
			return new ResponseEntity<String>("{ \"message\": \"" + e.getMessage() + "\"}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
