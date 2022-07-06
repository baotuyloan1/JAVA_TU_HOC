package Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
			if(itr.next().equals("A")) {
				itr.remove();
			}
		}
//		for (String string : list) {
//			System.out.println(string);
//		}
	}

}
