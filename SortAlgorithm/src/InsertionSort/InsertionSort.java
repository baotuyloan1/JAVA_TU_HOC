package InsertionSort;

public class InsertionSort {

	public static int[] sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i - 1; j > 0; j--) {
				int temp = array[i];
				if (array[j] > temp) {
					array[j+1] = array[j];
					array[j] = array[i];
				} 
			}
		}
		return array;

	}

	public static void main(String[] args) {
//		int[] array = new int[] { 5, 2, 6, 8, 1, 3, 4 };
//		int[] sortedArray = sort(array);
////		for (int i = 0; i < sortedArray.length; i++) {
////			System.out.println(sortedArray[i]);
////		}
//		for (int i : sortedArray) {
//			System.out.println(i);
//		}
		
		int j = 1;
		for(;j<5;j++) {
			System.out.println(j);
		}
	}
}
