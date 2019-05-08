import info.trustzone.logger.MyLog;
import info.trustzone.parser.Lex;
import info.trustzone.samples.SampleString;

public class SnippetCollectorApp {

	public static void main(String[] args) {
		Lex l = new Lex("other");	
		String res;
		System.out.println("version: " + l.numVersion());
		
		SampleString s1 = new SampleString("Aaa");
		s1.CompareString();
		
		try {
			l.setToken("one", "a1");
			l.setRegex("[a-zA-Z_][a-zA-Z0-9_]*", "name");
			l.setInputString("one.onez");

			res = l.nextSymbol();
			System.out.println("Symbol 1 (expect a1): " + res + "["+l.currentText() +"]");
			res = l.nextSymbol();
			System.out.println("Symbol 2 (expect other): " + res + "["+l.currentText() +"]");
			res = l.nextSymbol();
			System.out.println("Symbol 3 (expect name): " + res + "["+l.currentText() +"]");
			
		} catch (Exception e) {
			MyLog.exceptionTop(e, null);
		}
		
	}

}
