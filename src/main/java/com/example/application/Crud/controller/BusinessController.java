package com.example.application.Crud.controller;

import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.Crud.exception.BusinessAlreadyExistsException;
import com.example.application.Crud.exception.BusinessNotFoundException;
import com.example.application.Crud.model.Business;
import com.example.application.Crud.services.BusinessService;




@RestController
@RequestMapping("/business")
public class BusinessController {

	@Autowired
	private BusinessService businessService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addBusiness(@RequestBody Business business) {
		try {
			businessService.saveBusiness(business);
			return new ResponseEntity<Business>(business, HttpStatus.CREATED);
		} catch (BusinessAlreadyExistsException e) {
			return new ResponseEntity<String>("{ \"message\": \"" + e.getMessage() + "\"}", HttpStatus.CONFLICT);
		}
		catch(Exception e){
			return new ResponseEntity<String>("{ \"message\": \"" + e.getMessage() + "\"}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateBusiness(@RequestBody Business business,@PathVariable int id) {
		try {
			businessService.updateBusiness(business,id);
			return new ResponseEntity<Business>(business, HttpStatus.OK);
		} catch (BusinessNotFoundException e) {
			return new ResponseEntity<String>("{ \"message\": \"" + e.getMessage() + "\"}", HttpStatus.CONFLICT);
		}
		catch(Exception e){
			return new ResponseEntity<String>("{ \"message\": \"" + e.getMessage() + "\"}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/searchByName/{serchBusinessName}")
	public ResponseEntity<?> serachByBusinessName(@PathVariable String serchBusinessName) {
		
		try {
			List<Business> blist = businessService.searchByBusinessName(serchBusinessName);
			return new ResponseEntity<List<Business>>(blist, HttpStatus.OK);
		} catch(Exception e){
			return new ResponseEntity<String>("{ \"message\": \"" + e.getMessage() + "\"}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/searchByPan/{searchByPan}")
	public ResponseEntity<?> serachByPan(@PathVariable String searchByPan) {
	
		try {
			List<Business> blist = businessService.searchByPan(searchByPan);
			return new ResponseEntity<List<Business>>(blist, HttpStatus.OK);
		} catch(Exception e){
			return new ResponseEntity<String>("{ \"message\": \"" + e.getMessage() + "\"}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
