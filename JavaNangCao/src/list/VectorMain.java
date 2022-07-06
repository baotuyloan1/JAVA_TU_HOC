package list;

import java.util.List;
import java.util.Vector;

public class VectorMain {
	public static void main(String[] args) {
		Person p = new Person(1);

		List<Person> list = new Vector<Person>();

		list.add(p);
		list.remove(0);
		for (Person person : list) {
			
		}
	}
}
