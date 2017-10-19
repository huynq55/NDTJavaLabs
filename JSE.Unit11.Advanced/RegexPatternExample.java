import com.sun.org.apache.xpath.internal.SourceTree;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPatternExample {

  public static void main(String[] args) {
    Pattern pattern = Pattern.compile("\\d+");
    String text = "1 + 1 bang 2";
    Matcher matcher = pattern.matcher(text);

    Integer start = 0;
    Integer end;
    long startTime = System.nanoTime();
    for (int i = 0; i < 1000000; i++) {
      while (matcher.find(start)) {
        start = matcher.start();
        end = matcher.end();
//        System.out.println("number: " + text.substring(start, end));
        start = end;
      }
      start = 0;
    }
    System.out.println("time 1: " + (System.nanoTime() - startTime));

    startTime = System.nanoTime();
    for (int i = 0; i < 1000000; i++) {
      while (matcher.find()) {
        start = matcher.start();
        end = matcher.end();
//        System.out.println("number: " + text.substring(start, end));
//        start = end;
      }
      matcher.reset();
    }
    System.out.println("time 2: " + (System.nanoTime() - startTime));
  }

}
