package exception;

public class TryCatch {

	public static void main(String[] args) {
		int[] mang = {1,2};
		
		try {	
			System.out.println(mang[2]);
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Lỗi" + e.toString());
		} catch (Exception e) {
//			System.out.println("Lỗi 2" + e.toString());
		}finally {
//			System.out.println("finally");
		}
		System.out.println("Ket thuc");

	}

}
