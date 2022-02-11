package amith.auction.teams.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ExceptionEntity> handleResourceNotFoundException(ResourceNotFoundException e)
	{
		ExceptionEntity error = new ExceptionEntity();
		error.setMessage(e.getMessage());
		error.setStatuscode(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ExceptionEntity>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionEntity> handleResourceAlreadyExistException(ResourceAlreadyExistException e)
	{
		ExceptionEntity error = new ExceptionEntity();
		error.setMessage(e.getMessage());
		error.setStatuscode(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ExceptionEntity>(error,HttpStatus.NOT_FOUND);
	}
}
