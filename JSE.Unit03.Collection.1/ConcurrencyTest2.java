import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ConcurrencyTest2 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Collections.addAll(list, 1, 3, 4, 2, 3, 6, 3, 3, 8);
		System.out.println("Before remove: size of list = " + list.size());
		
		// bi loi ConcurrentModificationException
		// list.forEach(v -> {
			// if (v == 3) list.remove(v);
		// });
		
		// remove voi iterator
		// Iterator iterator = list.iterator();
		// while (iterator.hasNext()) {
			// if ((Integer) iterator.next() == 3) iterator.remove();
		// }

		//remove voi remove if
		// list.removeIf(item -> item == 3);
		
		// remove voi singleton
		list.removeAll(Collections.singleton(3));
	
		System.out.println("After remove: size of list = " + list.size());
		
		
		
	}
	
}