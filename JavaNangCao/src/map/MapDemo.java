package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("Bao", 20);
		map.put("Khanh", 18);
		map.put(null, 10);

//		System.out.println(map.get(null));

		Set<String> keySet = map.keySet();
		for (String string : keySet) {
			System.out.println(map.get(string));
		}

		System.out.println("===================");

		for (Entry<String, Integer> s : map.entrySet()) {
			System.out.println(s.getKey());
			System.out.println(s.getValue());
		}
	}
}
