
public class Person {
	public static class Kid{
		private int tuoi;
		
		
		public int getTuoi() {
			return tuoi;
		}


		public void setTuoi(int tuoi) {
			this.tuoi = tuoi;
		}


		public void hello() {
			System.out.println("Hello"+tuoi);
		}
	}
	
	public static void main(String[] args) {
		Person.Kid kid = new Person.Kid();
		kid.setTuoi(10);
		kid.hello();
		

	}
	
	
	
}
