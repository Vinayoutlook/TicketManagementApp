package in.app.exception;

public class TicketNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TicketNotFoundException(String message) {
		super(message);
	}
}
