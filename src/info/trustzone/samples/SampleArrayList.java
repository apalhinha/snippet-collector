package info.trustzone.samples;

//s ArrayList
import java.util.ArrayList;

public class SampleArrayList {

	public void CreateAdd() {
		//s ArrayList, filename, lists, array
		ArrayList<String> alist = new ArrayList<String>();
		alist.add("aa");
		alist.add("bb");
		System.out.println( alist.get(0) ); // aa
		System.out.println( alist.size() ); // 2
	}
	
	
}
