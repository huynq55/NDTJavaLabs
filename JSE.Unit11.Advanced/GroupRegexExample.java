import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupRegexExample {

  public static void main(String[] args) {
    Pattern pattern = Pattern.compile("\\w+(\\s)(.*)", Pattern.UNICODE_CHARACTER_CLASS);
    String text = "tôi học java";
    Matcher matcher = pattern.matcher(text);

    // kiểm tra xem string có match hoàn toàn hay không
    System.out.println(matcher.matches());

    System.out.println(matcher.group(1));
    System.out.println(matcher.group(2));
  }

}
