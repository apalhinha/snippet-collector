package info.trustzone.parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LexTest {

	@Test
	void testVersion() {
		Lex a = new Lex(0);
		assertEquals(1, a.numVersion());
	}

	@Test
	void testNextSymbolEmpty() {
		Lex a = new Lex(0);
		assertEquals(-1, a.nextSymbol());
	}
	
	@Test
	void testNextSymbolOther() {
		int res;
		Lex a = new Lex(0);
		a.setInputString("abc");
		res=a.nextSymbol();
		assertEquals(0, res);
		assertEquals("a", a.currentText());
		
		res=a.nextSymbol();
		assertEquals(0, res);
		assertEquals("b", a.currentText());
		
		res=a.nextSymbol();
		assertEquals(0, res);
		assertEquals("c", a.currentText());
		
		res=a.nextSymbol();
		assertEquals(-1, res);
	}
	
	@Test
	void testReadString() {
		String res;
		Lex a = new Lex( 0 );
		a.setInputString("my text");
		res=a.getInput();
		assertEquals("my text", res);
	}
	
	

}
