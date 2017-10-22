import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;

class TotalCaculator1 {

  public int TOTAL = 3;

  public long getTotal(short value) {
    return TOTAL + value;
  }

  public static String calculate() {
    return "Quang Huy";
  }

}

public class MethodHandlerExample {

  public static void main(String[] args) {
    Lookup lookup = MethodHandles.lookup();
    try {
      MethodHandle mh = lookup.findVirtual(TotalCaculator1.class, "getTotal",
          MethodType.methodType(long.class, short.class));
      try {
        Object obj = TotalCaculator1.class.newInstance();
        try {
          System.out.println(mh.invoke(obj, (short) 23));
        } catch (Throwable throwable) {
          throwable.printStackTrace();
        }
        mh = MethodHandles.insertArguments(mh, 1, (short) 10);
        try {
          System.out.printf("total = %d", mh.invoke(obj));
          System.out.println();
        } catch (Throwable throwable) {
          throwable.printStackTrace();
        }
      } catch (InstantiationException e) {
        e.printStackTrace();
      }
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    try {
      MethodHandle mh2 = lookup
          .findStatic(TotalCaculator1.class, "calculate", MethodType.methodType(String.class));
      try {
        System.out.println((String) mh2.invokeExact());
      } catch (Throwable throwable) {
        throwable.printStackTrace();
      }
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    try {
      Object obj = TotalCaculator1.class.newInstance();
      try {
        MethodHandle mh = lookup.findSetter(TotalCaculator1.class, "TOTAL", int.class);
        try {
          mh.invoke(obj, 15);
          mh = lookup.findVirtual(TotalCaculator1.class, "getTotal",
              MethodType.methodType(long.class, short.class));
          System.out.println(mh.invoke(obj, (short) 23));
        } catch (Throwable throwable) {
          throwable.printStackTrace();
        }

      } catch (NoSuchFieldException e) {
        e.printStackTrace();
      }
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }
}
