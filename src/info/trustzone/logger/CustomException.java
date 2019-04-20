package info.trustzone.logger;

public class CustomException extends Exception {
	private String msg="";
	private static final long serialVersionUID = 1L;
	
	public CustomException (String amessage) {
		msg=amessage;
	}
	
	public String toString() {
		return "Fantastic error: " + msg;
	}

}
