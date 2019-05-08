package info.trustzone.parser;

import java.util.ArrayList;
//import java.util.Iterator;

public class SnippetPart {
	private ArrayList<String> pLines = new ArrayList<String>();

	public SnippetPart () {
	}

	public SnippetPart (String aline) {
		pLines.add(aline);
	}
	
	public ArrayList<String> getList() {
		return pLines;
	}
	
	public void add (String aline) {
		pLines.add(aline);
	}
}
