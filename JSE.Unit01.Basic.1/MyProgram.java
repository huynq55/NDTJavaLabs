public class MyProgram {
	public static void main(String[] args) {
		System.out.println("The number of arguments is " + args.length);
		for (int i = 0; i < args.length; i++) {
			System.out.println("Value at " + i + " is " + args[i]);
		}
	}
}