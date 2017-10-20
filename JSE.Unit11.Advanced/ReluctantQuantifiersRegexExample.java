import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReluctantQuantifiersRegexExample {

  public static void main(String[] args) {
    String text = "xxxjavaxxxxxxjava";
    Pattern pattern = Pattern.compile(".*?va");
    Matcher matcher = pattern.matcher(text);
    System.out.println("reluctant---->" + matcher.find());
    System.out.println(text.substring(matcher.start(), matcher.end()));

    System.out.println("reluctant---->" + matcher.find(matcher.end()));
    System.out.println(text.substring(matcher.start(), matcher.end()));
  }
}
