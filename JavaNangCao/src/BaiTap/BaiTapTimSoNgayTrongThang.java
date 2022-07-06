package BaiTap;

import java.util.Scanner;

public class BaiTapTimSoNgayTrongThang {
	public static void main(String[] args) {
		int thang, nam;
		Scanner s = new Scanner(System.in);
		System.out.println("Nhập vào tháng: ");
		thang = s.nextInt();
		System.out.println("Nhập vào năm: ");
		nam = s.nextInt();
		
		switch (thang) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("Có 31 ngày");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("có 30 ngày");
			break;
		case 2:
			if (nam % 4 == 0 && nam % 100 != 0 || nam % 400 == 0) {
				System.out.println("Có 29 ngày");
			}else {
				System.out.println("có 28 ngày");
			}
			break;
		default:
			System.out.println("Nhập dữ liệu sai");
			break;
		}
		int a= 0;
		
	}
}
