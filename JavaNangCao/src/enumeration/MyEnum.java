package enumeration;

public enum MyEnum {
	CAFE("cafe","đắng"),TEA("tra","thơm"),COCA("coca","ngọt");
	private String ten;
	private String taste;

	private MyEnum(String ten, String taste) {
		this.ten = ten;
		this.taste = taste;
	}
	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	
	public void toStringg() {
		System.out.println(this.ten + this.taste);
	}
	
	
	
	
	
	

}
