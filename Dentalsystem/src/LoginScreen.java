import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Matheus on 02/11/2016.
 */
public class LoginScreen extends JFrame {

    private JPanel contentPane;
    private JTextArea username;
    private JPasswordField password;
    private JButton login, forgot;
    private JLabel  usernameLabel, passwordLabel;
    private int width, height;

    public LoginScreen(int w, int h){

        // Instance variables
        this.width = w;
        this.height = h;

        final Color bgBlue = new Color(112, 205, 255);
        final Color white  = new Color(255, 255, 255);

        // The actual container
        //GridBagLayout layout = new GridBagLayout();
        FlowLayout layout = new FlowLayout();
        contentPane = new GradientPanel(layout, width, height, 0, 50, bgBlue, 0, height, white);
        contentPane.setPreferredSize(new Dimension(width, height));


        // Create buttons and labels for input
        usernameLabel = new JLabel("Username: ");
        username = new JTextArea();
        username.setColumns(20);

        passwordLabel = new JLabel("Password: ");
        password = new JPasswordField();
        password.setColumns(20);

        login = new MenuButton(30, 50, "Login", white);
        forgot = new MenuButton(30, 50, "Forgot Password", white);


        // GridBagConstraints for laying out components
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(20,20,20,20);


        contentPane.add(username);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(contentPane);
        this.pack();
        this.setVisible(true);

    }
}
