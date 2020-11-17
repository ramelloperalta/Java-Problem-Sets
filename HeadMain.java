import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
/**
 * 
 */
public class HeadMain extends JPanel
{
  public static void main(String[] args){
    JFrame frame = new JFrame("Head");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLayout(new GridLayout(2, 2));
    for(int i = 0; i < 4; i++) {
            frame.add(new Head());
        }
    frame.pack();
    frame.setVisible(true);   
  }
}
