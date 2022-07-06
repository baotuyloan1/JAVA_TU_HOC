package exception;

public class TestCompileEx extends Exception{
	private String titile;
	
	public TestCompileEx(String title) {
		this.titile = title;
	}

	public String getTitile() {
		return titile;
	}

	public void setTitile(String titile) {
		this.titile = titile;
	}
	
	
}
