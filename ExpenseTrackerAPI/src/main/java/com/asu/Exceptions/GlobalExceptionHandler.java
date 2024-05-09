package com.asu.Exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.asu.model.ErrorObject;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ExpenseNotFoundException.class)
	public ResponseEntity<ErrorObject> handleExpenseNotFound(ExpenseNotFoundException e) {
		ErrorObject eo = new ErrorObject();
		eo.setMessage(e.getMessage());
		eo.setStatusCode(HttpStatus.NOT_FOUND.value());
		eo.setTimeStamp(new Date());
		return new ResponseEntity<>(eo, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorObject> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException e) {
		ErrorObject eo = new ErrorObject();
		eo.setMessage(e.getMessage());
		eo.setStatusCode(HttpStatus.BAD_REQUEST.value());
		eo.setTimeStamp(new Date());
		return new ResponseEntity<ErrorObject>(eo, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorObject> handleGeneralException(Exception e) {
		ErrorObject eo = new ErrorObject();
		eo.setMessage(e.getMessage());
		eo.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		eo.setTimeStamp(new Date());
		return new ResponseEntity<>(eo, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/*
	 * protected ResponseEntity<Object>
	 * handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders
	 * headers, HttpStatus status, WebRequest request) {
	 * 
	 * Map<String, Object> body = new HashMap<>(); body.put("timestamp", new
	 * Date()); body.put("statusCode", HttpStatus.BAD_REQUEST.value());
	 * 
	 * List<String> errors =
	 * ex.getBindingResult().getFieldErrors().stream().map(FieldError::
	 * getDefaultMessage) .collect(Collectors.toList());
	 * 
	 * body.put("messages", errors);
	 * 
	 * return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST); }
	 */
}
