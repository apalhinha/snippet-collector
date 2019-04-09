package info.trustzone.parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LexTest_Nextsymbol {

	@Test
	void test() {
		Lex a = new Lex();
		assertEquals("", a.nextsymbol());
	
	}

}
