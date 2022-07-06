package Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DemoSet {
	public static void main(String[] args) {
		Set<String> setString  = new HashSet<String>();
		
		setString.add("B");
		setString.add("C");
		setString.add("A");
		setString.add("D");
		setString.add("G");
		
		for (String string : setString) {
			System.out.println(string);
		}
		
		Iterator<String> itr = setString.iterator();
		while (itr.hasNext()) {
			String string = (String) itr.next();
			if(string.equals("B")) {
				itr.remove();
			}
		}
		setString.add("E");
		for (String string : setString) {
			System.out.println(string);
		}
		
//		setString.remove("A");
//		for (String string : setString) {
//			System.out.println(string);
//		}
		
		
 		
	}
}
