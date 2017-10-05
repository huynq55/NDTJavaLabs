import java.awt.event.WindowListener;
import java.awt.Frame;
import java.awt.event.WindowEvent;

interface WindowClosing extends WindowListener {
  
  public default void windowOpened(WindowEvent e) {}
  
  public default void windowActivated(WindowEvent e) {}
  
  public default void windowClosed(WindowEvent e) {}
  
//  public default void windowClosing(WindowEvent e) {}
  
  public default void windowDeactivated(WindowEvent e) {}
  
  public default void windowDeiconified(WindowEvent e) {}
  
  public default void windowIconified(WindowEvent e) {}

}

public class AWTListenerExample1 {
  public static void main(String[] args) {
    Frame screen = new Frame();
    screen.addWindowListener((WindowClosing) (e) -> System.exit(1));
  }
}