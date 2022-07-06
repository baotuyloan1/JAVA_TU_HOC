package SelectionSort;

import java.util.Iterator;

public class SelectionSort {
	public static int[] sort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				int temp = 0;
				if (array[i] < array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;

	}

	public static void main(String[] args) {
		int[] array = new int[] { 5, 2, 6, 8, 1, 3, 4 };
		int[] sortedArray = sort(array);
//		for (int i = 0; i < sortedArray.length; i++) {
//			System.out.println(sortedArray[i]);
//		}
		for (int i : sortedArray) {
			System.out.println(i);
		}
	}
}
