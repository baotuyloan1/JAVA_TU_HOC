
public class Main {

	public static void main(String[] args) {
		Student a = new Student();
		Teacher t = new Teacher();
		
		a.setName("bao");
		a.setClasses(12);
		
		toString1(a);
		t.setName("huy");
		t.setSubject("Toan");
		toString1(t);
		
	}
	
	public static void toString1(Person a) {
		if (a instanceof Student) {
			Student s = (Student)a;
			System.out.println(s.getName() + s.getClasses());
		}else if (a instanceof Teacher) {
			Teacher t = (Teacher)a;
			System.out.println(t.getName() + t.getSubject());
		}
	}

	

	

	

}
