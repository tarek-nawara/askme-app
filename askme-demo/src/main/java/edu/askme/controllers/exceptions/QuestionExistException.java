package edu.askme.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT, reason="Question already exist")
public class QuestionExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5364845805724565876L;

}
