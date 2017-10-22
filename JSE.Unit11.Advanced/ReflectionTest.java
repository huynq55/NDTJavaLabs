import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class TotalCaculator {

  private final static int TOTAL = 3;

  private int getTotal(int value) {
    return TOTAL + value;
  }

  @Test(34)
  long getTotal(short value) {
    return TOTAL + value;
  }

  @Test(100)
  private void print(short value) {
    System.out.println("gia tri them vao la: " + value);
  }
}

public class ReflectionTest {

  static void explore(Object obj) {
    Class clazz = obj.getClass();
    System.out.println("clazz name: " + clazz.getName());

    try {
      Field field = clazz.getDeclaredField("TOTAL");
      field.setAccessible(true);
//      System.out.println("total value is " + field.get(obj));
//      field.set(obj, 25);
//      System.out.println("total value is 2 " + field.get(obj));
      Field modifiersField = Field.class.getDeclaredField("modifiers");
      modifiersField.setAccessible(true);
      modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
      field.setInt(obj, 23);
      System.out.println("modified value of the total field is " + field.get(obj));
    } catch (NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace();
    }

    try {
      Method method = clazz.getDeclaredMethod("getTotal", new Class[]{int.class});
      method.setAccessible(true);
      System.out.println("method return value = " + method.invoke(obj, new Object[]{5}));
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    try {
      Object obj = TotalCaculator.class.newInstance();
      explore(obj);
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
  }

}
