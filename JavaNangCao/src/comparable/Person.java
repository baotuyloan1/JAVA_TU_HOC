package comparable;

import java.util.Objects;

public class Person implements Comparable<Person> {
	protected int age;
	private String name;

	public Person() {
	}

	public Person(int age, String name) {
		this.age = age;
		this.name = name;

	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return name + age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	@Override
	public int compareTo(Person o) {
		//sắp xếp theo age
//		if (this.age > o.getAge()) {
//			return -1;
//		} else if (this.age < o.getAge()) {
//			return 1;
//		} else
//			return 0;
		
		//theo name
//		return -this.name.compareTo(o.getName()); //ngược
		return this.name.compareTo(o.getName()); // tăng dần

	}

}
