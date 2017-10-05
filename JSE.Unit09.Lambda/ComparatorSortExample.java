import java.util.Arrays;


public class ComparatorSortExample {


  public static void main(String[] args) {

    Integer[] values = {12, 345, 34, 7, 9, 12, 9};

    Arrays.sort(values, (Integer o1, Integer o2) -> {
      return o2 - o1;
    });

    for (Integer ele : values) {
      System.out.print(ele + ", ");
    }


  }


}
