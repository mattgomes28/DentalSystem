import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Matheus on 04/11/2016.
 */
public class ButtonListener extends MouseAdapter implements ActionListener{

    private Container content; // Content to add
    private JButton button;
    private Container target;  // Container target to change

    public ButtonListener(JButton button, Container content, Container target){

        // Just set the fields
        this.button = button;
        this.content = content;
        this.target = target;

    }

    /*
     This function will set the button
     back to normal color, size etc.
     Overrides the default behaviour.
     */
    public void normalize(){
        button.getParent().revalidate();
        button.getParent().repaint();
    }


    /*
    What happens when the mouse clicks a button.
     */
    public void actionPerformed(ActionEvent e) {

        // Add the direct page thing here.
        System.out.println("Added some content");

        target.removeAll();
        target.add(content);
        target.revalidate();

    }


    public void mouseEntered(MouseEvent e){
        normalize();
    }
    public void mouseExited(MouseEvent e){
        normalize();
    }
    public void mousePressed(MouseEvent e){
        normalize();
    }
    public void mouseReleased(MouseEvent e){
        normalize();
    }
    public void mouseClicked(MouseEvent e){
        normalize();
    }
    public void mouseMoved(MouseEvent e){
        normalize();
    }
    public void mouseDragged(MouseEvent e){
        normalize();
    }


}
