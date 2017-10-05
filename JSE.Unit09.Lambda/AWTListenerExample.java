import java.awt.Frame;
import java.awt.Button;
import javax.swing.JOptionPane;

public class AWTListenerExample {
  public static void main(String[] args) {
    Frame screen = new Frame();

    Button button = new Button("Press me");
    screen.add(button);

    button.addActionListener(
        e ->
            JOptionPane.showMessageDialog(
                null,
                "Info Box: Welcome to Java by Example",
                "Java Sample",
                JOptionPane.INFORMATION_MESSAGE));
    screen.setSize(250, 400);
    screen.setVisible(true);
  }
}
