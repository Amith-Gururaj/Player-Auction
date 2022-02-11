package amith.auction.players.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController 
{
	@ExceptionHandler
	public ResponseEntity<ExceptionEntity> handleDataNotFoundException(DataNotFoundException e)
	{
		ExceptionEntity error = new ExceptionEntity();
		error.setMessage(e.getMessage());
		error.setStatuscode(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ExceptionEntity>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionEntity> handleLimitExceededException(LimitExceededException e)
	{
		ExceptionEntity error = new ExceptionEntity();
		error.setMessage(e.getMessage());
		error.setStatuscode(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ExceptionEntity>(error,HttpStatus.NOT_FOUND);
	}
}
