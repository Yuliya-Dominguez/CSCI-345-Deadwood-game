import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.util.*;
 
public class View extends JPanel{

    private Image board;
    private Image card;
    private ArrayList<Image> cards;

    @Override //Set new dimensions to make scroll bar work
    public Dimension getPreferredSize() {
        return new Dimension(1200, 900);
    }

    public View() { //Constructor
        super();
        setBackground(Color.WHITE);
        addImage();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Deadwood");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1500,900);

            View images = new View();

            //add horizontal and vertical scroll bars (for small screens)
            JScrollPane scrollPane = new JScrollPane(images);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            //add user functions panel for the player's actions
            JPanel userFunctionsPanel = new JPanel();
            userFunctionsPanel.setBackground(Color.white);
            userFunctionsPanel.setLayout(new FlowLayout());

            JButton button1 = new JButton("Button 1");//replace with any player actions buttons
            JButton button2 = new JButton("Button 2");
            userFunctionsPanel.add(button1);
            userFunctionsPanel.add(button2);

            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
            frame.getContentPane().add(userFunctionsPanel, BorderLayout.EAST);

            frame.setVisible(true);
        });
    }

    // Gotta randomize image selection

    //Add images to the array list for drawing with paintComponent()
    private void addImage() {

        ImageIcon brd = new ImageIcon("Images/board.jpeg");
        board = brd.getImage();
        //board = getScaledImage(board, 900, 655);

        cards = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            if (i < 10) {
                ImageIcon crd = new ImageIcon("Images/cards/0" + i + ".png");
                card = crd.getImage();
                //card = getScaledImage(card, 154, 86);
                cards.add(card);
            }
            else {
                ImageIcon crd = new ImageIcon("Images/cards/10.png");
                card = crd.getImage();
                //card = getScaledImage(card, 154, 86);
                cards.add(card);
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(board, 0, 0, this);

        Day day = new Day();
        int[] scenesDrawn = day.getScenesDrawn();
        
        for (int i = 0; i < scenesDrawn.length; i++) {

            //get area of the set to place a card at
            int x = BoardData.getSetArea(i).getX();
            int y = BoardData.getSetArea(i).getY();

            Image crd = cards.get(i);
            g.drawImage(crd, x, y, this);
        }
    }

}