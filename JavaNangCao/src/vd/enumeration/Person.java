package vd.enumeration;

public class Person {
	protected int age;
	private String name;
	private RolerUser role;

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

	public RolerUser getRole() {
		return role;
	}

	public void setRole(RolerUser role) {
		this.role = role;
	}
	

}
