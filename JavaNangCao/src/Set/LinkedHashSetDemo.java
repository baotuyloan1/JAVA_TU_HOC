package Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {

	public static void main(String[] args) {
		
		
	Set<String> setString  = new LinkedHashSet<String>();
		
		setString.add("B");
		setString.add("C");
		setString.add("A");
		setString.add("D");
		setString.add("B");
		setString.remove(new String("B"));
		
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
		
//		
//		setString.remove("A");
//		for (String string : setString) {
//			System.out.println(string);
//		}
//		
//		
//		
//		Set<Person> set = new LinkedHashSet<Person>();
//		
//		set.add(new Person(10,"A"));
//		set.add(new Person(30,"C"));
//		set.add(new Person(20,"B"));
//		set.add(new Person(5,"D"));
//		set.add(new Person(10,"A"));
//		
//		for (Person person : set) {
//			System.out.println(person.getAge());
//		}
	}

}
