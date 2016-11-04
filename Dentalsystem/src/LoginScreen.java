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


    public LoginScreen(int width, int height){

        // Sorting out the content pane stuff
        contentPane = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        contentPane.setPreferredSize(new Dimension(300, 300));

        // Instantiating the fields
        username = new JTextArea();
        password = new JPasswordField();
        login = new JButton("Login");
        forgot = new JButton("Forgot My Password");
        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");

        username.setColumns(10);
        password.setColumns(10);
        password.setBorder(null);


        // Adding the stuff with constraints
        c.gridx = 1;
        c.gridy = 1;
        contentPane.add(usernameLabel, c);

        c.gridx = 2;
        c.gridy = 1;
        contentPane.add(username, c);

        c.gridx = 1;
        c.gridy = 2;
        contentPane.add(passwordLabel, c);

        c.gridx = 2;
        c.gridy = 2;
        contentPane.add(password, c);

        c.gridx = 1;
        c.gridy = 3;
        contentPane.add(login, c);

        c.gridx = 2;
        c.gridy = 3;
        contentPane.add(forgot, c);





        // Final touches to the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(contentPane);
        this.pack();
        this.repaint();


    }
}
