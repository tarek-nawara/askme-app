package edu.askme.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT, reason="User Already Exist")
public class UserExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 698263150203058811L;

}
