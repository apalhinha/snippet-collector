package info.trustzone.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.*;

import info.trustzone.logger.CustomException;
//import info.trustzone.logger.MyLog;

public class Lex {
	private String sInputString = "";
	private String sText;
	private ArrayList<Token> pTokens = new ArrayList<Token>();
	private int pIndex;
	private String sOtherToken="other";
	
	public Lex(String otherToken) {
		sOtherToken=otherToken;
	}
	
	/**
	 * Set a code for CR-LF
	 * The code must be a new one, not in use
	 * @param aresult The text code to be returned as Token when a Cr'Lf is found
	 * @throws CustomException if the code was already in use, or CrLf was already defined
	 */
	public void setCrLf(String aresult) throws CustomException {
		Token t;
		Iterator<Token> i = pTokens.iterator();
		if (sOtherToken == aresult) throw new CustomException("Result '" + aresult + "' reused");
		while (i.hasNext()) {
			t = (Token) i.next();
			if (t.read() == "\r\n") throw new CustomException("Redefined symbol CRLF");
			if (t.read() == "\n") throw new CustomException("Redefined symbol LF");
			if (t.result() == aresult) throw new CustomException("Result '" + aresult + "' reused");
		}
		pTokens.add(new Token("\r\n", aresult));
		pTokens.add(new Token("\n", aresult));
	}
	
	/**
	 * Set a given string to be found, along with the respective returning code (result).
	 * The string may contain a regex expression
	 * @param aread String to be identified by the parser, when reading the input
	 * @param aresult Code to be returned whenever the string is found
	 * @throws CustomException In case the code is already in use, or the string is already defined
	 */
	public void setRegex(String aread, String aresult) throws CustomException {
		Token t;
		Iterator<Token> i = pTokens.iterator();
		if (sOtherToken == aresult) throw new CustomException("Result '" + aresult + "' reused");
		while (i.hasNext()) {
			t = (Token) i.next();
			if (t.read() == aread) throw new CustomException("Redefined symbol '" + aread + "'");
			if (t.result() == aresult) throw new CustomException("Result '" + aresult + "' reused");
		}
		pTokens.add(new Token(aread, aresult));		
	}
	
	/**
	 * Same as setText, defines a string to be found. Internally the API will concatenate
	 * 'not followed by letter or digit'. Use for straight tokens
	 * @param astring String to be identified by the parser
	 * @param acode Code to be returned whenever the string is found
	 * @return The code that was set (parameter)
	 * @throws CustomException In case the code is already in use, or the string is already defined
	 */
	public void setToken(String aread, String aresult) throws CustomException {
		Token t;
		Iterator<Token> i = pTokens.iterator();
		if (sOtherToken == aresult) throw new CustomException("Result '" + aresult + "' reused");
		while (i.hasNext()) {
			t = (Token) i.next();
			if (t.read() == "("+aread+")(?![a-zA-Z_0-9])") throw new CustomException("Redefined symbol '" + aread + "'");
			if (t.result() == aresult) throw new CustomException("Result '" + aresult + "' reused");
		}
		pTokens.add(new Token("(" + aread + ")(?![a-zA-Z_0-9])", aresult));		
	}

	/**
	 * Get the current version of the parser
	 * @return Implemented version
	 */
	public int numVersion() {
		return 1;
	}

	public String nextSymbol() {
		Token t;
		Iterator<Token> i = pTokens.iterator();
		Pattern pattern;
		Matcher matcher;
		
//		pattern = Pattern.compile("ab.*");
//		matcher = pattern.matcher("xabc");
//		if (matcher.matches()) {
//			System.out.println("Yes");
//		} else {
//			System.out.println("Not matches");
//		}
		
		if (pIndex+1 > sInputString.length()) return "EOF";
		
		while (i.hasNext()) {
			t = (Token) i.next();
			pattern = Pattern.compile(t.read());
			matcher = pattern.matcher(sInputString.substring(pIndex));
			if (matcher.find()) {
				if (matcher.start()==0) {
					sText = matcher.group();
					pIndex += sText.length();
					return t.result();
				}
			}
		}
		
		sText = sInputString.substring(pIndex, pIndex+1);
		pIndex++;
		return sOtherToken;

	}
	
	public String currentText() {
		return sText;
	}
	
	/**
	 * Define the string for parsing
	 * @param astring containing the text to be parsed
	 */
	public void setInputString(String astring) {
		sInputString = astring;
		pIndex = 0;
	}
	
	public String getInput() {
		return sInputString;
	}
}
