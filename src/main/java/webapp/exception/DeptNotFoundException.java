package webapp.exception;

public class DeptNotFoundException extends RuntimeException {
	
	public DeptNotFoundException() {
		super();
	}
	
	public DeptNotFoundException(String message) {
		super(message);
	}
	
	public DeptNotFoundException(String message, Throwable e) {
		super(message, e);
	}

}
