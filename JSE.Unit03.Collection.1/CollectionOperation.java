import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.IntSummaryStatistics;
import java.util.Consumer;

public class CollectionOperation {
	
	public static int huyInt(Integer value) {
		return value.intValue();
	}
	
	public static void main(String[] args) {
		List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(4, 7, 1, 3, 8, 9, 2, 6, 10));
		Comparator<Integer> comparator = Integer::compare;
		Collections.sort(listOfIntegers, comparator);
		
		listOfIntegers.forEach(i -> {
			System.out.print(i + ", ");
		});
		System.out.println();
		
		// listOfIntegers.stream().filter(v -> v > 5).forEach(v -> {
			// System.out.print(v + ", ");
		// });
		// System.out.println();
		
		// Integer[] values = listOfIntegers.stream().filter(v -> v > 5).toArray(size -> new Integer[size]);
		// Arrays.stream(values).forEach(v -> System.out.print(v + ", "));
		// System.out.println();
		
		// Collector<Integer, ?, IntSummaryStatistics> collector = Collectors.summarizingInt(CollectionOperation::huyInt);
		
		// thac mac cho nay: tai sao summarizingInt nhan functional interface ToIntFunction<T> voi ham applyAsInt(T value)
		// ma o day intValue lai la ham khong nhan tham so: intValue() => khong tuong thich ma van chay duoc
		// lab03 slide 14
		Collector<Integer, ?, IntSummaryStatistics> collector = Collectors.summarizingInt(Integer::intValue);
		IntSummaryStatistics summaryStatistics = listOfIntegers.stream().collect(collector);
		System.out.println("Total: " + summaryStatistics.getSum());
		System.out.println("Overage = " + summaryStatistics.getAverage());
		
		int sum = listOfIntegers.stream().reduce(0, (x, y) -> x + y);
		int sum1 = listOfIntegers.stream().reduce(0, Integer::sum);
		
		System.out.println("sum: " + sum + " sum1: " + sum1);
		
		
		
		Consumer<Integer> myConsumer = n -> {
			System.out.println("User input value = " + n);
			if (n < 5) {
				System.out.println("
				
			}
			
			
			
		}
	}
}