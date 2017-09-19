import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class LinkedListExample2 {
	public static void main(String[] args) {
		List<String> list = new LinkedList<String>(Arrays.asList(args));
		
		list.forEach(value -> {
			System.out.println(value);
			
		});
		
		
	}
	
	
	
}