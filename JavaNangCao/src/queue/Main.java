package queue;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		queue.add("A");
		queue.add("C");
		queue.add("B");
		queue.add("D");
		queue.add("B");
		queue.remove("D");
		for (String string : queue) {
			System.out.println(string);
		}
	}

}
