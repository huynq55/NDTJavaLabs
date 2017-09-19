import java.util.Map;
import java.util.Hashtable;

public class MapExample {
	public static void main(String[] args) {
		Map<teger, String> map = new Hashtable<Integer, String>();
		// Hashtable<Integer, String> map = new Hashtable<Integer, String>();
		map.put(3, "Nguyen Van A");
		map.put(1, "Nguyen Van B");
		map.put(2, "Nguyen Van C");
		map.put(4, "Nguyen Van X");
		
		System.out.println(map.get(3));
		
		map.put(3, "Nguyen Thi A");
		System.out.println(map.get(3));
		
		
	}
	
	
	
}