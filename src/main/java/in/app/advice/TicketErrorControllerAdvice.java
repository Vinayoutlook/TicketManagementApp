package in.app.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.app.error.ErrorDetails;
import in.app.exception.TicketNotFoundException;

@RestControllerAdvice
public class TicketErrorControllerAdvice {

	@ExceptionHandler(TicketNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleTicketNotFound(TicketNotFoundException tf) {
		System.out.println("TicketErrorControllerAdvice.handleTicketNotFound()");

		ErrorDetails details = new ErrorDetails(LocalDateTime.now(),tf.getMessage(),"404-NotFound");

		return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllProblems(Exception e) {
		System.out.println("TicketErrorControllerAdvice.handleAllProblems()");
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(),e.getMessage(),"Problem in exeuction");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
