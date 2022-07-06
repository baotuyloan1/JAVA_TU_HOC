package list;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Person p1 = new Person(20);
		Person p2 = new Person(30);
		
		ArrayList<Person> persons = new ArrayList<Person>();
		persons.add(p1);
		persons.add(p2);
		
		//muốn xóa được 2 đối tượng == nhau thì phải overide lại hàm equals
		persons.remove(new Person(20));
//		persons.remove(p2);
		for (Person person : persons) {
			System.out.println(person.getAge());
		}

	}

}
