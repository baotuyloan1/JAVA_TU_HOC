package vd.enumeration;

public class TestEnum {

	public static void main(String[] args) {
		System.out.println(RolerUser.ROLE_ADMIN.name());
		
		for (RolerUser role : RolerUser.values()) {
			System.out.println(role.name());
		}
		
		Person p = new Person();
		p.setRole(RolerUser.ROLE_ADMIN);
		RolerUser.ROLE_ADMIN.setId(10);
		p.getRole().setId(100);
		System.out.println(RolerUser.ROLE_ADMIN.getId());
		
		
		if (p.getRole() == RolerUser.ROLE_ADMIN) {
			System.out.println("OK");
		}
		System.out.println(RolerUser.ROLE_ADMIN.getId());
		if(p.getRole().getId() == RolerUser.ROLE_ADMIN.getId()) {
			System.out.println("ROLE ADMIN");
		}
		
		if(p.getRole().name() == "ROLE_ADMIN") {
			System.out.println("bi lo");
		}
	}

}
