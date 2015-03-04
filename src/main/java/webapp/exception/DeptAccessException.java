package webapp.exception;

public class DeptAccessException extends RuntimeException {
	
	public DeptAccessException() {
		super();
	}
	
	public DeptAccessException(String message) {
		super(message);
	}
	public DeptAccessException(Throwable e) {
		super(e);
	}
	
	public DeptAccessException(String message, Throwable e) {
		super(message, e);
		
	}

}
