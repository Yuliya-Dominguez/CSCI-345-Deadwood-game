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
    private Image playerIc;
    private String[] diceIc = new String[]{"b", "c", "g", "o", "p", "r", "v", "w", "y"};
    private ArrayList<Image> diceImg;
    Player player = new Player();

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

        Day day = new Day();
        int[] scenesDrawn = day.getScenesDrawn();

        for (int i = 0; i < scenesDrawn.length; i++) {
            int sceneNum = scenesDrawn[i];
            if (sceneNum < 10) {
                ImageIcon crd = new ImageIcon("Images/cards/0" + sceneNum + ".png");
                card = crd.getImage();
                cards.add(card);
            }
            else {
                ImageIcon crd = new ImageIcon("Images/cards/" + sceneNum + ".png");
                card = crd.getImage();
                cards.add(card);
            }
        }

        diceImg = new ArrayList<>();

        for (int j = 1; j <= 4; j++){

            ImageIcon pIcon = new ImageIcon("Images/dice/" + diceIc[j-1] + j + ".png");
            //ImageIcon pIcon = new ImageIcon("Images/dice/r2.png");
            playerIc = pIcon.getImage();
            diceImg.add(playerIc);
        }
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        g.drawImage(board, 0, 0, this);
        
        for (int i = 0; i < 10; i++) {

            //get area of the set to place a card at
            int x = BoardData.getSetArea(i).getX();
            int y = BoardData.getSetArea(i).getY();

            Image crd = cards.get(i);
            g.drawImage(crd, x, y, this);
        }

        /*
        //Player player = new Player();
        //int x = player.playerCoordinates[0];
        //int y = player.playerCoordinates[1];
        //int plnums = Main.getPlayersNum();
        //List<Player> players = Main.gamePlayers;
        for (Player player:players) {
            for (int j = 0; j < plnums; j++){
                Image dice = diceImg.get(j);
                g.drawImage(dice, x, y, this);
            }
        }*/

        //need to implement a way to track player's location
        int[] x = new int[]{51, 49, 1111, 637}; //this is temporary player's location
        int[] y = new int[]{261, 356, 469, 22}; //this is temporary player's location

        for (int j = 0; j < 4; j++){
            Image dice = diceImg.get(j);
            g.drawImage(dice, x[j], y[j], this);
        }
    }

}