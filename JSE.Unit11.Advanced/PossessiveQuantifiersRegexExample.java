import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PossessiveQuantifiersRegexExample {

  public static void main(String[] args) {
    String text = "xxxjavaxxxxxxjava";
    Pattern pattern = Pattern.compile(".*+va");
    Matcher matcher = pattern.matcher(text);
    System.out.println("possessive---->" + matcher.find());
  }
}
