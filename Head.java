import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class Head extends JPanel {
    
    private boolean mouseInside = false; //mouseEntered component = true; else false;
    public Head() {
        this.setPreferredSize(new Dimension(500, 500));
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.addMouseListener(new MyMouseListener());
    }
    
    private class MyMouseListener extends MouseAdapter {
        //if implementing interface MouseListener, the contract states you must implement all methods of the interface 
        //MouseAdapter is an abstract superclass which implements MouseListener--therefore not a requirement to implement all methods in the subclass;
        //alternately you can use default methods in interface to achieve the same result
        @Override public void mouseEntered(MouseEvent me) {
            mouseInside = true; repaint();
        }
        @Override public void mouseExited(MouseEvent me) {
            mouseInside = false; repaint();   
        }
    }
       
    
    @Override public void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // no jaggies
        
        g2.setStroke(new BasicStroke(3.0f));
        Ellipse2D.Double outline = new Ellipse2D.Double(100,100,300,300);
        g2.draw(outline);
        
        if(mouseInside) {
            Ellipse2D.Double leftEye = new Ellipse2D.Double(143, 200, 50, 25);
            g2.draw(leftEye);
            Ellipse2D.Double rightEye = new Ellipse2D.Double(308, 200, 50, 25);
            g2.draw(rightEye);
            Arc2D.Double smile = new Arc2D.Double(150, 150, 200, 220, 180, 180, Arc2D.CHORD);
            //g2.rotate(Math.toRadians(180));
            g2.draw(smile);
        } else {
            Line2D.Double leftEye = new Line2D.Double(150, 215, 180, 215);
            g2.draw(leftEye);
            Line2D.Double rightEye = new Line2D.Double(320, 215, 350, 215);
            g2.draw(rightEye);
            Line2D.Double mouth = new Line2D.Double(190, 320, 300, 300);
            g2.draw(mouth);
        }
    }
}
