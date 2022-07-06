package comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		list.add(new Person(20,"Bảo"));
		list.add(new Person(30,"Bảo 3"));
		list.add(new Person(10,"Bảo 1"));
		list.add(new Person(40,"Bảo 4"));
		list.add(new Person(50,"Bảo 5"));
		System.out.println("trước khi Sắp xếp theo ID: ");
		for (Person person : list) {
			System.out.println(person.getAge());
		}
		
//		System.out.println("sau khi Sắp xếp theo ID: ");
//		Collections.sort(list);
//		for (Person person : list) {
//			System.out.println(person.getAge());
//		}
		
		System.out.println("sau khi Sắp xếp theo tên: ");
		Collections.sort(list);
		for (Person person : list) {
			System.out.println(person.getName());
		}
	}

}
