import javax.swing.*;
import java.awt.*;

/**
 * Created by Matheus on 02/11/2016.
 */
public class LoginScreen extends JFrame {

    private JPanel contentPane;
    private JPanel logoPanel;
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
        GridBagLayout layout = new GridBagLayout();
        contentPane = new GradientPanel(layout, width, height, 0, 50, bgBlue, 0, height, white);
        contentPane.setPreferredSize(new Dimension(width, height));

        // Create the logo panel
        logoPanel = new ImagePanel(UsefulFunctions.getImage("logo.png"));
        logoPanel.setBackground(new Color(255,255,255,0));


        // Create buttons and labels for input
        usernameLabel = new JLabel("Username: ");
        username = new JTextArea();
        username.setColumns(20);

        passwordLabel = new JLabel("Password: ");
        password = new JPasswordField();
        password.setColumns(20);

        login = new MenuButton(100, 30, "Login", white);
        forgot = new MenuButton(150, 30, "Forgot Password", white);


        // GridBagConstraints for laying out components
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(20,20,20,20);


        // First add the logo to the top
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.5;
        contentPane.add(new TransPanel(), c);

        c.gridx = 1;
        c.weightx = 0;
        contentPane.add(logoPanel, c);

        c.gridx = 2;
        c.weightx = 1;
        contentPane.add(new TransPanel(), c);


        // Now add the labels and text fields to container
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.5;
        contentPane.add(usernameLabel, c);

        c.gridx = 1;
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(username, c);

        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 0.5;
        contentPane.add(passwordLabel, c);

        c.gridx = 1;
        c.weightx = 1;
        contentPane.add(password, c);


        // The buttons (Login and Forgot password)
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 3;
        c.weightx = 0.5;
        contentPane.add(login, c);

        c.gridx = 1;
        contentPane.add(forgot, c);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(contentPane);
        this.pack();
        this.setVisible(true);

    }
}
