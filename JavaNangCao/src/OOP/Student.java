package OOP;

public class Student extends Person {
	private int classs;

	public Student() {

	}

	public Student(int age, String name) {
		super(age, name);
	}

	public int setName(int age) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}

	public int getClasss() {
		return classs;
	}

	public void setClasss(int classs) {
		this.classs = classs;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	public String getName(int a) {
		return null;

	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return super.getAge();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "con";
	}

	@Override
	String string1() {
		return getName() + getAge() + getClasss();

	}

}
