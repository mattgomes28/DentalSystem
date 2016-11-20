package UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Matheus on 11/11/2016.
 *
 * This class is mainly used as a dummy
 * in GridBagLayout to push elements.
 */
public class TransPanel extends JPanel{

    private Color color;

    public TransPanel(){
        super();
        this.setBackground(new Color(255,255,255,0));
    }

    public TransPanel(Color c){
        super();
        color = c;
        this.setBackground(color);
    }
}
