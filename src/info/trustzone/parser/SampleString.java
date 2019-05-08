package info.trustzone.parser;

public class SampleString {
	String s1;
	
	public SampleString(String value) {
		s1 = value;
	}
	
	public void CompareString() {

		//s Compare string
		System.out.println("\"a\" compareTo \"bbb\" :" + "a".compareTo("bbb"));
		System.out.println("  \"a\" compareTo \"a\" :" + "a".compareTo("a"));  
		System.out.println("\"bbb\" compareTo \"a\" :" + "bbb".compareTo("a"));
		
//		"a" compareTo "bbb" :-1
//		"a" compareTo "a"   :0
//		"bbb" compareTo "a" :1
	}
}
