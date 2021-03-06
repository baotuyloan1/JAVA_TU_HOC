package OOP;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
//		Person p1 = new Person();
//		p1.setName("Thành");
//		System.out.println(p1.toString());
//		
//		Student s1  = new Student();
//		s1.setName("Thành");
//		s1.getAge();
//		s1.setAge(30);
//		s1.getAge();
//		System.out.println(s1.toString());

//		Person p = new Person();

		// đa hình
		// chỉ gọi được những phương thức có tram hàm cha
		Person p1 = new Student();

		Person s = new Student();

		Teacher t = new Teacher();
//		inputInfo(p);
//		output(p);
//		inputInfo(t);
//		output(t);
		inputInfo(s);
		inputInfo(t);
		toString(s);
		toString(t);

	}

	public static void inputInfo(Person p) {

		System.out.println("Nhập thông tin");
		System.out.println("Nhập tên:");
//		String name = new Scanner(System.in).nextLine();
//		int age = new Scanner(System.in).nextInt();

		p.setName(new Scanner(System.in).nextLine());
		p.setAge(new Scanner(System.in).nextInt());

		if (p instanceof Student) {
			Student s = (Student) p;
			System.out.println("Nhập lớp:");
			s.setClasss(new Scanner(System.in).nextInt());
		} else if (p instanceof Teacher) {
			Teacher t = (Teacher) p;
			System.out.println("Nhập môn học:");
			t.setSubject(new Scanner(System.in).nextLine());
		}

	}

	public static void output(Person p) {
		if (p instanceof Student) {
			Student s = (Student) p;
			System.out.println(s.getName() + s.getAge() + s.getClasss());
		} else if (p instanceof Teacher) {
			Teacher t = (Teacher) p;
			System.out.println(p.getName() + p.getAge() + t.getSubject());
		} else {
			System.out.println(p.getName() + p.getAge());
		}

	}

	public static void toString(Person p) {
		System.out.println(p.string1());
	}

}
