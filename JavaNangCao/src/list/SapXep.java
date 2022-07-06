package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SapXep {
	public static void main(String[] args) {
		List<String> listString = new ArrayList<String>();
		
		listString.add("a");
		listString.add("c");
		listString.add("b");
		listString.add("d");
		
		for (String string : listString) {
			System.out.println(string);
		}
		System.out.println("Sorted: AES");
		Collections.sort(listString);
		for (String string : listString) {
			System.out.println(string);
		}
		
		List<Integer> listIntegers = new ArrayList<Integer>();
		listIntegers.add(4);
		listIntegers.add(3);
		listIntegers.add(3);
		listIntegers.add(7);
		listIntegers.add(4);
		System.out.println("");
		for (Integer integer : listIntegers) {
			System.out.println(integer);
		}
		System.out.println("Sorted : AES");
		Collections.sort(listIntegers);
		for (Integer integer : listIntegers) {
			System.out.println(integer);
		}
		
		
	}
}
