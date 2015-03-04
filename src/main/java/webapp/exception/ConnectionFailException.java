package webapp.exception;

public class ConnectionFailException extends RuntimeException {
	
	public ConnectionFailException() {
		super();
	}
	
	public ConnectionFailException(String message) {
		super(message);
	}
	
	public ConnectionFailException(String message, Throwable e) {
		super(message, e);
	}

}
