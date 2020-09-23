package com.example.application.Crud.exception;

public class BusinessAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2547317032607976157L;

	/**
	 * @param arg0
	 */
	public BusinessAlreadyExistsException(String message) {
		super(message);
	}

}