package info.trustzone.parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LexTestVersion {

	@Test
	void testVersion() {
		Lex a = new Lex();
		assertEquals(1, a.numversion());
	}

}
