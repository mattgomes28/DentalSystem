package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Matheus on 04/11/2016.
 */
public abstract class ButtonListener extends MouseAdapter implements ActionListener{

    private JButton button;

    public ButtonListener(JButton button){

        // Just set the fields
        this.button = button;
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
