package info.trustzone.parser;

import java.util.ArrayList;
import java.util.Iterator;

import info.trustzone.logger.CustomException;
import info.trustzone.logger.MyLog;

public class Lex {
	private String sInputString = "";
	private String sText;
	private ArrayList<String> pTokens = new ArrayList<String>();
	private int pIndex;
	private int iOtherToken;
	
	public Lex(int otherToken) {
		iOtherToken=otherToken;
	}
	
	public int setCrLf(int acode) throws CustomException {
		Iterator i = pTokens.iterator();
		while (i.hasNext()) {
			
			i.next();
		}
		return acode;
	}

	public int numVersion() {
		return 1;
	}

	public int nextSymbol() {
//		System.out.println("index=" + pIndex + ", len=" + sInputString.length());
		if (pIndex+1 > sInputString.length()) return -1;
		sText = sInputString.substring(pIndex, pIndex+1);
		pIndex++;
//		System.out.println("Index=" + pIndex);
		return iOtherToken;
	}
	
	public String currentText() {
		return sText;
	}
	
	public void setInputString(String astring) {
		sInputString = astring;
		pIndex = 0;
	}
	
	public String getInput() {
		return sInputString;
	}
}
