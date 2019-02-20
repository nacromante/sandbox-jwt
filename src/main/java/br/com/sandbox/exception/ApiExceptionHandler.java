package br.com.sandbox.exception;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(ApiExceptionHandler.class);
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException exception) {
		ErrorDetails error = new ErrorDetails(exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(ParameterInvalidException.class)
	public ResponseEntity<ErrorDetails> handleEntityNotFoundException(ParameterInvalidException exception, Locale locale) { 
		ErrorDetails errorDetails = new ErrorDetails(exception.getMessage());
		
		return ResponseEntity.badRequest().body(errorDetails);
	}
	
	@ExceptionHandler(ConversionFailedException.class)
	public ResponseEntity<ErrorDetails> handlerConversionFailedException(ConversionFailedException exception, Locale locale) {
		ErrorDetails error = new ErrorDetails(exception.getMessage());
		return ResponseEntity.badRequest().body(error);
	}
	@ExceptionHandler(ServiceDownException.class)
	public ResponseEntity<ErrorDetails> handlerConversionFailedException(ServiceDownException exception, Locale locale) {
		ErrorDetails error = new ErrorDetails(exception.getMessage());
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(error);
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<ErrorDetails> handlerConverterFailedException(NumberFormatException exception, Locale locale) {
		ErrorDetails error = new ErrorDetails(exception.getMessage());
		LOG.error("Error not expected ", exception);
		error = new ErrorDetails("Failed to convert value of null to required type Integer");
		return ResponseEntity.badRequest().body(error);
	}
}
