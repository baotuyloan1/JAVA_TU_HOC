package OOP;

public class Teacher extends Person {

	private String subject;

	public Teacher() {

	}

	public Teacher(String name, int age1) {
		super(age1, name);

	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	String string1() {

		return getName() + getAge() + getSubject();
	}

}
