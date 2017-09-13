public class MethodExample {
  private static int add(int... values) {
    int total = 0;
    for (int element: values) {
      total += element;
    }
    return total;
  }
  
  public static void main(String[] args) {
    // System.out.println("4 + 7 = " + add(4, 7));
    
    // int value1 = Integer.parseInt(args[0]);
    // int value2 = Integer.parseInt(args[1]);
    
    // int[] a = {4, 7, 5, 12, 6, 9};
    System.out.println(add(4, 7, 5, 12, 6, 9));
    
    
    
  }
  
  
}