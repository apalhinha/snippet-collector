package info.trustzone.parser;

public class Token {
	private String pRead;
	private String pResult;
	
	public Token( String aread, String aresult ) {
		this.pRead = aread;
		this.pResult = aresult;
	}
	
	/**
	 * Fixed name of a given token
	 * @return The string that the parser will return upon finding the "read" string
	 */
	public String result() {
		return this.pResult;
	}
	
	/**
	 * Text string defining the text to be searched
	 * @return The string that the parser should identify when reading
	 */
	public String read() {
		return this.pRead;
	}
}
