import javax.swing.*;
import java.awt.*;

/**
 * Created by Annie on 21/11/2016.
 */
public class HealthcarePlanPage {

    public static void showHealthcarePlanPage(final JPanel mainContent, int w, int h) {

        // Create colors needed for this page
        final Color borderC = new Color(76, 178, 252);
        final Color contentC = new Color(230, 244, 254);

        // Remove everything from main content
        mainContent.removeAll();

        // Create the layout stuff here
        GridBagConstraints gbc = new GridBagConstraints();
        mainContent.setBackground(new Color(0, 0, 0, 0));
        mainContent.setPreferredSize(new Dimension(w, h));

        // Create the left panel buttons here - MAIN BUTTONS
        JButton register = new JButton("Add a Health care plan");
        JButton delete = new JButton("Delete a Health care Plan");
        JButton modify = new JButton("Modify a Health care plan");

        // Left and right main panels to hold content
        JPanel left = new JPanel(new GridBagLayout());
        JPanel right = new JPanel(); // undefined layout, need decide

        left.setBackground(contentC);
        left.setBorder(BorderFactory.createLineBorder(borderC, 2));
        right.setBackground(contentC);
        right.setBorder(BorderFactory.createLineBorder(borderC, 2));

        left.setPreferredSize(new Dimension((int) (0.33*w), h));
        right.setPreferredSize(new Dimension((int) (0.66*w), h));

        // Start adding stuff to the left menu
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 20, 0, 20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        left.add(register, gbc);
        gbc.gridy = 1;
        left.add(delete, gbc);
        gbc.gridy = 2;
        left.add(modify, gbc);

        // Then add the main stuff
        GridBagConstraints mainGbc = new GridBagConstraints(); // new one so values dont get messed
        mainGbc.anchor = GridBagConstraints.FIRST_LINE_START;
        mainGbc.gridx = 0;
        mainGbc.gridy = 0;

        mainContent.add(left);
        mainContent.add(right);
        mainContent.revalidate();

    }
}
