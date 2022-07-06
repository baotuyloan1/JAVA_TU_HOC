package vd.enumeration;

public enum RolerUser {
	ROLE_ADMIN(1), ROLE_MEMBER(2);
	private int id;
	
	private RolerUser(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
