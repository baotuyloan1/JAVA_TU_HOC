package exception;

public class Hello {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			chia2so(0, 0);
		} catch (MyException e) {
			System.out.println(e.getError());
		}
		
//		testRuntime();
		
		try {
			testCompile();
		} catch (TestCompileEx e) {
			// TODO Auto-generated catch block
			System.out.println(e.getTitile());
		}
		
		System.out.println("END");
		

	}
	
	public static void chia2so(int a, int b) throws MyException {
		try {
		int kq = a/b;
		System.out.println(kq);
		}catch(Exception e) {
			throw new MyException("Lỗi chia cho 0");
		}
	}
	
	public static void testRuntime() {
		throw new RuntimeException();
	}
	
	public static void testCompile() throws TestCompileEx {
		throw new TestCompileEx("Hello") ;
	}
	
	

}
