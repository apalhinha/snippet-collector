package info.trustzone.parser_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import info.trustzone.parser.Token;

class TokenTest {

	@Test
	void testToken() {
		Token t = new Token("aaa", "A");
		assertNotNull(t);
	}

	@Test
	void testResult() {
		Token t = new Token("aaa", "A");
		assertEquals("A", t.result());
	}

	@Test
	void testRead() {
		Token t = new Token("aaa", "A");
		assertEquals("aaa", t.read());
	}

}
