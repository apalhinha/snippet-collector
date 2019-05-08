package info.trustzone.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

class SnippetPartTest {

	@Test
	void testTwoLines() {
		String s;
		SnippetPart snippetPart = new SnippetPart("one");
		snippetPart.add("two");
		Iterator<String> i = snippetPart.getList().iterator();
		s = i.next();
		assertEquals("one", s);
		s = i.next();
		assertEquals("two", s);
		assertEquals(2, snippetPart.getList().size());
	}

	@Test
	void testEmpty() {
		SnippetPart snippetPart = new SnippetPart();
		assertEquals(true, snippetPart.getList().isEmpty());
		assertEquals(0, snippetPart.getList().size());
	}

	@Test
	void testNonEmpty() {
		SnippetPart snippetPart = new SnippetPart("one");
		assertEquals(false, snippetPart.getList().isEmpty());
	}

}
