import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class CollectionsExample2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		Collections.addAll(list, "Tu", "An", "Hoa", "Binh");
		Collections.sort(list);
		for (String item: list) {
			System.out.print(item + ", ");
		}
		System.out.println();
		System.out.println("Vi tri thu " + Collections.binarySearch(list, "Hoa"));
		
	}
	
	
}