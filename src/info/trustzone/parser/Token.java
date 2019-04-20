package info.trustzone.parser;

public class Token {
	private int pValue;
	private String pString;
	
	Token( int aValue, String aString ) {
		this.pValue = aValue;
		this.pString = aString;
	}
	
	public int value() {
		return this.pValue;
	}
	
	public String string() {
		return this.pString;
	}
}
