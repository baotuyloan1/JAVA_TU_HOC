package SearchBinary;

public class SearchBinary {

	public static boolean binarySearch(int a[], int x) {
		int right = a.length - 1;
		int left = 0;

		while (left <= right) {
			int mid = (right + left) / 2;
			if (a[mid] == x) {
				return true;
			} else if (a[mid] < x) {
				left = mid + 1;
			} else if (a[mid] > x) {
				right = mid - 1;
			}
		}
		return false;
	}

//	public static boolean binarySearchDeQuy(int a[], int x, int left, int right) {
//		int mid = (left + right) / 2;
//		if (x == a[mid]) {
//			return true;
//		} else if (x < a[mid]) {
//			binarySearchDeQuy(a, x, left, mid - 1);
//		}
//		else {
//			binarySearchDeQuy(a, x, mid + 1, right);
//		}
//		if (left > right)
//			return false;
//
//	}

	public static void sort(int a[]) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}

	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 7, 5, 78, 8, 10, 3 };
		sort(a);
		for (int i : a) {
			System.out.println(i);
		}

//		System.out.println(binarySearchDeQuy(a, 100, 0, a.length - 1));

	}

}
