package info.trustzone.parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SnippetTest {

	@Test
	void testSnippetSnippetPart() {
		SnippetPart snippetPart = new SnippetPart("one");
		Snippet snippet = new Snippet(snippetPart);
		
		assertEquals(1, snippet.getList().size());
		snippetPart = snippet.getList().get(0);
		assertEquals(1, snippetPart.getList().size());
	}

	@Test
	void testSnippet() {
		Snippet snippet = new Snippet();
		assertEquals(0, snippet.getList().size());
	}

	@Test
	void testAddLine() {
		Snippet snippet = new Snippet();
		snippet.addLine("one");
		assertEquals(1, snippet.getList().size());
	}

	@Test
	void testAddLine_twolines() {
		Snippet snippet = new Snippet();
		SnippetPart snippetPart;
		snippet.addLine("one");
		snippet.addLine("two");
		assertEquals(1, snippet.getList().size());
		snippetPart = snippet.getList().get(0);
		assertEquals(2, snippetPart.getList().size());
	}

	@Test
	void testAddPart_only() {
		Snippet snippet = new Snippet();
		SnippetPart snippetPart = new SnippetPart();
		snippetPart.add("one");
		snippetPart.add("two");

		snippet.addPart(snippetPart);
		
		assertEquals(1, snippet.getList().size());
		snippetPart = snippet.getList().get(0);
		assertEquals(2, snippetPart.getList().size());
	}

	@Test
	void testAdd_Line_PartData() {
		SnippetPart snippetPart;
		Snippet snippet = new Snippet();
		
		snippet.addLine("one");
		snippetPart = new SnippetPart("aaa");
		snippetPart.add("bbb");
		snippet.addPart(snippetPart);
		
		assertEquals(2, snippet.getList().size());
		snippetPart = snippet.getList().get(0);
		assertEquals(1, snippetPart.getList().size());
		snippetPart = snippet.getList().get(1);
		assertEquals(2, snippetPart.getList().size());
	}

	@Test
	void testAdd_Line_PartEmpty() {
		Snippet snippet = new Snippet();
		SnippetPart snippetPart = new SnippetPart();
		snippet.addLine("one");
		snippet.addLine("two");
		snippet.addPart(snippetPart);
		
		assertEquals(2, snippet.getList().size());
		
		snippetPart = snippet.getList().get(0);
		assertEquals(2, snippetPart.getList().size());
		snippetPart = snippet.getList().get(1);
		assertEquals(0, snippetPart.getList().size());
	}

	@Test
	void testAddPart() {
		Snippet snippet = new Snippet(new SnippetPart("aaa"));
		assertEquals(1, snippet.getList().size());
		assertEquals(1, snippet.getList().get(0).getList().size());
	}

}
