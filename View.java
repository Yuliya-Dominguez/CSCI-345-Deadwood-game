import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image; 
 
public class View{

    private static JFrame frame;
    private static JPanel backgroundPanel;
    private static JPanel imagePanel;

    public static void createAndShowGUI() {
        
        frame = new JFrame("Deadwood");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 900);

        //Create the background panel for the the board image
        backgroundPanel = new JPanel();
        //backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.setLayout(new GridBagLayout());

        ImageIcon backgroundImage = new ImageIcon("Images/board.jpeg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        //backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        backgroundPanel.add(backgroundLabel);
        
        /*    @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load and draw the background image
                ImageIcon backgroundImage = new ImageIcon("Images/board.jpeg");
                Image image = backgroundImage.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            }
        };
        backgroundPanel.setLayout(new BorderLayout());*/

        //Panel for the user functions
        JPanel userFunctionsPanel = new JPanel();
        userFunctionsPanel.setBackground(Color.white);
        userFunctionsPanel.setLayout(new FlowLayout());

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        userFunctionsPanel.add(button1);
        userFunctionsPanel.add(button2);

        //Panel for images on top of the background
        imagePanel = new JPanel();
        imagePanel.setOpaque(false);
        imagePanel.setLayout(null);
        //imagePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        //imagePanel.add(backgroundPanel);//

        ImageIcon imageIcon1 = new ImageIcon("Images/cards/01.png");
        ImageIcon imageIcon2 = new ImageIcon("Images/cards/02.png");

        JLabel imageLabel1 = new JLabel(imageIcon1);
        JLabel imageLabel2 = new JLabel(imageIcon2);

        //imagePanel.setLayout(null);
        imageLabel1.setBounds(21, 69, 205, 115);
        //imageLabel1.setBounds(19, 63, 205, 115);
        //imageLabel2.setBounds(22, 685, 205, 115);
        //imageLabel2.setBounds(27, 732, 205, 115);
        imageLabel2.setBounds(27, 500, 205, 115);

        imagePanel.add(imageLabel1);
        imagePanel.add(imageLabel2);

        //backgroundPanel.add(imagePanel);
        //backgroundPanel.add(imagePanel, BorderLayout.CENTER);

        //Create the main container panel with a BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(backgroundPanel, BorderLayout.CENTER);
        mainPanel.add(imagePanel, BorderLayout.CENTER);
        mainPanel.add(userFunctionsPanel, BorderLayout.EAST);

        frame.setContentPane(mainPanel);
        //frame.getContentPane().add(mainPanel);
        //frame.pack();
        frame.setVisible(true);
    }

    private static void addImagesToPanel() {

        BoardData boardData = new BoardData();

        for (int i = 1; i <= 2; i++) {
            ImageIcon cardImage = new ImageIcon("Images/cards/0" + i + ".png");
            JLabel imageLabel = new JLabel(cardImage);

            //int x = boardData.getSetArea(i).getX();
            //int y = boardData.getSetArea(i).getY();
            //int h = boardData.getSetArea(i).getH();
            //int w = boardData.getSetArea(i).getW();
            int x = 21;
            int y = 69;
            int h = 115;
            int w = 205;

            imageLabel.setBounds(x, y, w, h);

            imagePanel.add(imageLabel);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }
}