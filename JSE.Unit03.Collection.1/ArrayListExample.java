import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

public class ArrayListExample {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		Collections.addAll(list, args);
		
		// for (int i = 0; i < list.size(); i++) {
			// System.out.println("Element at " + i + " is " + list.get(i));
			
		// }
		
		IntStream.range(0, list.size()).forEach(i -> {
			System.out.println("Element at " + i + " is " + list.get(i));
		});
		
	}
	
}