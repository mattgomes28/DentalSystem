import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by Matheus on 27/10/2016.
 */
public class WindowTest extends JFrame {

    private JPanel contentPane;
    private JPanel topMenu;
    private JPanel header;
    private JPanel dummy;
    private JButton home, appointments, healthCare,
                    patients, contact;


    public WindowTest(final int w,final int h) {
        super();

        // Colours we'll need to paint the UI (RGB format)
        final Color lightBlue = new Color(200, 200, 255);
        final Color bgBlue = new Color(112, 205, 255);
        final Color grey = new Color(128, 128, 128, 40);
        final Color white = new Color(255,255,255);
        final Color transWhite = new Color(255,255,255, 100);

        // Gradient drawing in this area
        FlowLayout layout = new FlowLayout(FlowLayout.LEADING, 0, 0);
        JPanel contentPane = new JPanel(layout) {
            public void paintComponent(Graphics g) {

                super.paintComponent(g);
                Graphics2D gb = (Graphics2D) g;
                gb.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                GradientPaint gp = new GradientPaint(0, 100, bgBlue, 0, h, white);
                gb.setPaint(gp);
                gb.fillRect(0, 0, w, h);

            }
        };
        contentPane.setPreferredSize(new Dimension(w, h));




        try{
            File imgFile = new File(getClass().getResource("header.jpg").toURI());
            Image headerImg = ImageIO.read(imgFile);
            header = new ImagePanel(headerImg);

            contentPane.add(header);
        }
        catch (Exception e){
            System.out.println("Failed to load image");
        }




        // Top menu stuff here
        topMenu = new JPanel(new GridLayout(1,5));
        topMenu.setBackground(new Color(0,0,0));
        System.out.println(topMenu.getSize());

        // Creating menu items
        home = new MenuButton(300, 75, "Home", transWhite);
        appointments = new MenuButton(300, 75, "Appointments", transWhite);
        patients = new MenuButton(300, 75, "Patients", transWhite);
        healthCare = new MenuButton(300, 75, "Health Care", transWhite);
        contact = new MenuButton(300, 75, "Contact", transWhite);

        topMenu.add(home);
        topMenu.add(appointments);
        topMenu.add(patients);
        topMenu.add(healthCare);
        topMenu.add(contact);
        topMenu.revalidate();

        topMenu.setPreferredSize(new Dimension(w, 60));
        contentPane.add(topMenu);


        // Dummy here for the rest of the screen
        JPanel mainContent = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        mainContent.setBackground(new Color(0,0,0,0));


        // The Two Columns of Main Page
        JPanel left = new JPanel(),
               right = new JPanel();

        int insetSize = 20;
        Color borderC = new Color(76, 178, 252),
              contentC = new Color(230,244,254);
        Dimension colDim = new Dimension(w/2-2*insetSize, 500);


        left.setPreferredSize(colDim);
        left.setBackground(contentC);
        left.setBorder(BorderFactory.createLineBorder(borderC, 2));

        right.setPreferredSize(colDim);
        right.setBackground(contentC);
        right.setBorder(BorderFactory.createLineBorder(borderC, 2));

        // Adding both columns to the panel
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weighty = 1;
        gbc.insets = new Insets(insetSize,insetSize,insetSize,insetSize);
        mainContent.add(left, gbc);

        gbc.gridx = 1;
        mainContent.add(right, gbc);


        contentPane.add(mainContent);


        // Main window settings
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(contentPane);
        this.pack();
        this.revalidate();
        this.setResizable(false);
        this.setVisible(true);
    }
}
