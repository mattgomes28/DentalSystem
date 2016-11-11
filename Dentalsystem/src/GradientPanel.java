import javax.swing.*;
import java.awt.*;

/**
 * Created by Matheus on 09/11/2016.
 */
public class GradientPanel extends JPanel {

    private int x1, x2, y1, y2;
    private int width, height;
    private Color c1, c2;

    public GradientPanel(LayoutManager layout, int w, int h, int x1, int y1, Color c1, int x2, int y2,Color c2 ){

        // Initialise with layout manager
        super(layout);

        // Assign the instance variables for the gradient
        this.x1 = x1;
        this.y1 = y1;

        this.x2 = x2;
        this.y2 = y2;

        this.c1 = c1;
        this.c2 = c2;

        // Width and height
        this.width = w;
        this.height = h;

    }

    /*
    This is where the magic happens. Overriding the
    paintComponent method to draw the gradient on the
    background of the JPanel.
     */
    protected void paintComponent(Graphics g) {

        // Overriding drawing bit
        super.paintComponent(g);
        Graphics2D gb = (Graphics2D) g;
        gb.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        GradientPaint gp = new GradientPaint(x1, y1, c1, x2, y2, c2);
        gb.setPaint(gp);
        gb.fillRect(0,0, width, height);
    }
}
