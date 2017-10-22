import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnotationTest {

  public static void main(String[] args) throws IllegalAccessException, InstantiationException {
    Method[] methods = TotalCaculator.class.getDeclaredMethods();
    TotalCaculator obj = TotalCaculator.class.newInstance();

    Arrays.stream(methods).forEach(method -> {
      Test test = method.getAnnotation(Test.class);
      if (test == null) {
        return;
      }

      System.out.println("test method: " + method.getName());
      try {
        method.setAccessible(true);
        System.out.println(method.invoke(obj, new Object[]{test.value()}));
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      }
    });
  }
}
