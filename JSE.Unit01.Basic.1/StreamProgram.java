import java.util.Arrays;

public class StreamProgram {
	public static void main(String[] args) {
		System.out.println("The number of arguments is " + args.length);
		
		Arrays.stream(args).forEach((String value) -> {
			System.out.println("Value is " + value);
		});
	}
	
}