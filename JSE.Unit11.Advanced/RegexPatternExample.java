import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPatternExample {

  public static void main(String[] args) {
    Pattern pattern = Pattern.compile("\\d+");

    String text = "1 + 1 bang 2";
    Matcher matcher = pattern.matcher(text);

    // kiem tra xem co find duoc it nhat 1 truong hop khong
    System.out.println(matcher.find());

    matcher.reset();
    while (matcher.find()) {
      System.out.println("number: " + text.substring(matcher.start(), matcher.end()));
    }

    Integer start = 0;
    while(matcher.find(start)) {
      System.out.println("number: " +text.substring(matcher.start(), matcher.end()));
      start = matcher.end();
    }
  }

}
