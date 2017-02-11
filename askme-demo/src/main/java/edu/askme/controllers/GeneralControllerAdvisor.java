package edu.askme.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.askme.controllers.feedback.FeedBack;
import edu.askme.controllers.feedback.ResponseStatus;
import edu.askme.controllers.exceptions.QuestionExistException;
import edu.askme.controllers.exceptions.QuestionNotFoundException;
import edu.askme.controllers.exceptions.UserExistException;
import edu.askme.controllers.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GeneralControllerAdvisor {

	@ExceptionHandler(UserNotFoundException.class)
	public FeedBack<UserNotFoundException> userNotFoundExceptionHandler(UserNotFoundException ex) {
		return new FeedBack<UserNotFoundException>(ResponseStatus.USER_NOT_FOUND, ex);
	}

	@ExceptionHandler(UserExistException.class)
	public FeedBack<UserExistException> userExistExceptionHandler(UserExistException ex) {
		return new FeedBack<UserExistException>(ResponseStatus.USER_EXIST, ex);
	}

	@ExceptionHandler(QuestionNotFoundException.class)
	public FeedBack<QuestionNotFoundException> questionNotFoundExceptionHandler(QuestionNotFoundException ex) {
		return new FeedBack<QuestionNotFoundException>(ResponseStatus.QUESTION_NOT_FOUND, ex);
	}

	@ExceptionHandler(QuestionExistException.class)
	public FeedBack<QuestionExistException> quetionExistExceptionHandler(QuestionExistException ex) {
		return new FeedBack<QuestionExistException>(ResponseStatus.QUESTION_EXIST, ex);
	}
	
	@ExceptionHandler(Exception.class)
	public FeedBack<Exception> generalExceptionHandler(Exception ex) {
		return new FeedBack<Exception>(ResponseStatus.EXCEPTION, ex);
	}
}
