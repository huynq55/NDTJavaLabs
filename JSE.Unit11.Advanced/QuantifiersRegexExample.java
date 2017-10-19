import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuantifiersRegexExample {

  public static void main(String[] args) {
    Pattern pattern = Pattern.compile("(t?)(\\S+)(\\S+)(.*)", Pattern.UNICODE_CHARACTER_CLASS);

    String text = "tớ học java";
    Matcher matcher = pattern.matcher(text);
    System.out.println(text + "---->" + matcher.matches());
    System.out.println(matcher.group(1));
    System.out.println(matcher.group(2));
    System.out.println(matcher.group(3));
    System.out.println(matcher.group(4));

    text = "cậu học java";
    matcher = pattern.matcher(text);
    System.out.println(text + "---->" + matcher.matches());
    System.out.println(matcher.group(1));
    System.out.println(matcher.group(2));
    System.out.println(matcher.group(3));
    System.out.println(matcher.group(4));

    text = "tttôi học java";
    matcher = pattern.matcher(text);
    System.out.println(text + "---->" + matcher.matches());
    System.out.println(matcher.group(1));
    System.out.println(matcher.group(2));
    System.out.println(matcher.group(3));
    System.out.println(matcher.group(4));

    text = "t học java";
    matcher = pattern.matcher(text);
    System.out.println(text + "---->" + matcher.matches());
  }

}
