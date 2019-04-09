package info.trustzone.parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LexTest {

	@Test
	void testVersion() {
		Lex a = new Lex();
		assertEquals(1, a.numversion());
	}

	@Test
	void testNextSymbol() {
		Lex a = new Lex();
		assertEquals("", a.nextsymbol());
	
	}

}
