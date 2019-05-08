package info.trustzone.parser;

import java.util.ArrayList;

public class Snippet {
		private ArrayList<SnippetPart> pList = new ArrayList<SnippetPart>();
		
		public Snippet (SnippetPart apart) {
			pList.add(apart);
		}
		
		public Snippet () {
		}

		public ArrayList<SnippetPart> getList() {
			return pList;
		}
		
		public void addLine (String aline) {
			SnippetPart aPart;
			if (pList.isEmpty()) {
				aPart = new SnippetPart(aline);
				pList.add(aPart);
			} else {
				aPart = pList.get(pList.size()-1);
				aPart.add(aline);
			}
		}
		
		public void addPart (SnippetPart snippetPart) {
			pList.add(snippetPart);
		}

}
