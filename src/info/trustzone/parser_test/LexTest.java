package info.trustzone.parser_test;

//import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//import info.trustzone.logger.AlreadyHandledException;
import info.trustzone.logger.CustomException;
import info.trustzone.logger.MyLog;
import info.trustzone.parser.Lex;

class LexTest {
	
	@Test
	void testInputFile() {
		String res;
		Lex l = new Lex("other");
		try {
			l.setToken("abc", "firstletters");
			l.setCrLf("crlf");
			l.setInputFile("test1.txt");
			res=l.nextSymbol();
			assertEquals("firstletters", res);
			res=l.nextSymbol();
			assertEquals("EOF", res);
		} catch (Exception e) {
			MyLog.exceptionTop(e, "Openning 'test1'");
		}
	}

	@Test
	void testInputFile_Missing() {
		Lex l = new Lex("other");
		assertThrows(Exception.class, ()->{
			l.setInputFile("inexistent-file.txt");
		});		
		assertTrue(true);
	}

	@Test
	void testParse_NameOtherToken() {
		String res;
		String s;
		Lex l = new Lex("other");
		try {
			//res=l.setCrLf(3);
			l.setToken("one", "one");
			l.setRegex("[a-zA-Z_][a-zA-Z0-9_]*", "name");
			l.setInputString("onez.one");
			// onez
			res = l.nextSymbol();
			assertEquals("name", res);
			s = l.currentText();
			assertEquals("onez", s);
			// .
			res = l.nextSymbol();
			assertEquals("other", res);
			s = l.currentText();
			assertEquals(".", s);
			// one
			res = l.nextSymbol();
			assertEquals("one", res);
			s = l.currentText();
			assertEquals("one", s);
			// EOF
			res = l.nextSymbol();
			assertEquals("EOF", res);
			
		} catch (CustomException e) {}
	}

	@Test
	void testParse_TokenOtherName() {
		String res;
		String s;
		Lex l = new Lex("other");
		try {
			//res=l.setCrLf(3);
			l.setToken("one", "c1");
			l.setRegex("[a-zA-Z_][a-zA-Z0-9_]*", "name");
			l.setInputString("one.onez");
			// one
			res = l.nextSymbol();
			assertEquals("c1", res);
			s = l.currentText();
			assertEquals("one", s);
			// .
			res = l.nextSymbol();
			assertEquals("other", res);
			s = l.currentText();
			assertEquals(".", s);
			// onez
			res = l.nextSymbol();
			assertEquals("name", res);
			s = l.currentText();
			assertEquals("onez", s);
			// EOF
			res = l.nextSymbol();
			assertEquals("EOF", res);
			
		} catch (CustomException e) {}
	}

	@Test
	void testParse_Token() {
		String res;
		String s;
		Lex l = new Lex("other");
		try {
			l.setCrLf("crlf");
			l.setToken("one", "c1");
			l.setRegex("[a-zA-Z_][a-zA-Z0-9_]*", "name");
			l.setInputString("one");
			res = l.nextSymbol();
			assertEquals("c1", res);
			s = l.currentText();
			assertEquals("one", s);
		} catch (CustomException e) {}
	}

	@Test
	void testParse1() {
		String res;
		String s;
		Lex a = new Lex("other");
		try {
			a.setRegex("x", "ax");
			a.setInputString("x");
			res = a.nextSymbol();
			assertEquals(res, "ax");
			s=a.currentText();
			assertEquals("x", s);
			res = a.nextSymbol();
			assertEquals("EOF", res);
		} catch (CustomException e) {}
	}
	
	
	@Test
	void testSetText() {
		Lex a = new Lex("other");
		try {
			a.setRegex("abc", "3letters");
			assertTrue(true);
		} catch (CustomException e) {}		
	}

	@Test
	void testSetText_RepeatText() {
		Lex a = new Lex("other");
		assertThrows(CustomException.class, ()->{
			a.setRegex("aa", "one");
			a.setRegex("aa", "two");
		});		
		assertTrue(true);
	}

	@Test
	void testSetText_RepeatCode() {
		Lex a = new Lex("other");
		assertThrows(CustomException.class, ()->{
			a.setRegex("aa", "1");
			a.setRegex("bb", "1");
		});		
		assertTrue(true);
	}

	@Test
	void testSetText_SameAsOther() {
		Lex a = new Lex("something");
		assertThrows(CustomException.class, ()->{
			a.setRegex("aa", "something");
		});		
		assertTrue(true);
	}
	
	@Test
	void testCrLf() {
		Lex a = new Lex("other");
		try {
			a.setCrLf("crlf");
			assertTrue(true);
		} catch (CustomException e) {}		
	}

	@Test
	void testCrLf_ErrorRedefine() {
		Lex a = new Lex("other");
		assertThrows(CustomException.class, ()->{
			a.setCrLf("crlf");
			a.setCrLf("newline");
		});		
		assertTrue(true);
	}

	@Test
	void testCrLf_ErrorSameAsOther() {
		Lex a = new Lex("other");
		assertThrows(CustomException.class, ()->{
			a.setCrLf("other");
		});		
		assertTrue(true);
	}

	@Test
	void testVersion() {
		Lex a = new Lex("other");
		assertEquals(1, a.numVersion());
	}

	@Test
	void testNextSymbolEmpty() {
		Lex a = new Lex("other");
		assertEquals("EOF", a.nextSymbol());
	}
	
	@Test
	void testNextSymbolOther() {
		String res;
		Lex a = new Lex("other");
		a.setInputString("abc");
		res=a.nextSymbol();
		assertEquals("other", res);
		assertEquals("a", a.currentText());
		
		res=a.nextSymbol();
		assertEquals("other", res);
		assertEquals("b", a.currentText());
		
		res=a.nextSymbol();
		assertEquals("other", res);
		assertEquals("c", a.currentText());
		
		res=a.nextSymbol();
		assertEquals("EOF", res);
	}
	
	@Test
	void testReadString() {
		String res;
		Lex a = new Lex( "other" );
		a.setInputString("my text");
		res=a.getInput();
		assertEquals("my text", res);
	}
	
	

}
