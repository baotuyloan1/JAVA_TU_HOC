package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		list.add(new Person(1, "bao"));
		list.add(new Person(5, "khanh"));
		list.add(new Person(2, "khanh"));
		list.add(new Person(3, "c"));
		list.add(new Person(7, "v"));
		list.add(new Person(2, "a"));
		list.add(new Person(6, "n"));

		System.out.println("trước khi sắp xêpws");
		for (Person person : list) {
			System.out.println(person.getAge() + person.getName());

		}
		System.out.println("Sau khu sắp xếp");
		// cách 1
		Collections.sort(list, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				if (o1.getName().compareTo(o2.getName()) > 0) {
					return 1;
				} else if (o1.getName().compareTo(o2.getName()) < 0) {
					return -1;
				} else {
					if (o1.getAge() > o2.getAge()) {
						return 1;
					} else if (o1.getAge() < o2.getAge()) {
						return -1;
					} else {
						return 0;
					}
				}
			}

		});
		for (Person person : list) {
			System.out.println(person.getAge() + person.getName());

		}

//		Collections.sort(list, new MyCompare());

	}

}

class MyCompare implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		if (o1.getAge() > o2.getAge()) {
			return 1;
		} else if (o1.getAge() < o2.getAge()) {
			return -1;
		} else {
			return 0;
		}

	}

}
