import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.*;
import java.util.*;
 
public class View extends JPanel{

    private Image board;
    private Image face;
    private Image card;
    private ArrayList<Image> cards;
    private Image playerIc;
    private String[] diceIc = new String[]{"b", "c", "g", "o", "p", "r", "v", "w", "y"};
    private ArrayList<Image> diceImg;
    static Player player = new Player();
    //static List<Player> players = Main.gamePlayers;
    int plnums = Main.getPlayersNum();
    static PlayersList players = new PlayersList();
    static List<Player> pllist = new ArrayList<Player>();

    @Override //Set new dimensions to make scroll bar work
    public Dimension getPreferredSize() {
        return new Dimension(1200, 900);
    }

    public View(List<Player> playerlList) { //Constructor
        super();
        setBackground(Color.WHITE);
        pllist = playerlList;
        addImage();
    }

    public static void createGUI(List<Player> list) {
        JFrame frame = new JFrame("Deadwood");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500,900);

        View images = new View(list);

        //add horizontal and vertical scroll bars (for small screens)
        JScrollPane scrollPane = new JScrollPane(images);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //add user functions panel for the player's actions
        JPanel userFunctionsPanel = new JPanel();
        userFunctionsPanel.setBackground(Color.white);
        userFunctionsPanel.setLayout(new FlowLayout());

        //JButton button1 = new JButton("Button 1");//replace with any player actions buttons
        JButton testButton = new JButton("MOVE!");
        testButton.setBounds(400, 70, 80, 50);
        testButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        userFunctionsPanel.add(testButton);
        JButton button2 = new JButton("Button 2");
        //userFunctionsPanel.add(button1);
        userFunctionsPanel.add(button2);

        int plx = list.get(0).playerCoordinates[0];
        int ply = list.get(0).playerCoordinates[1];
        player = list.get(0);
        pllist = list;

        TextField sampleText = new TextField("x = " + plx + ", y = " +ply, 20);
        //sampleText.setBounds(300, 150, 275, 25);
        userFunctionsPanel.add(sampleText, 1);

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(userFunctionsPanel, BorderLayout.EAST);

        frame.setVisible(true);
    }
    /*public static void main(String[] args) {

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

            //JButton button1 = new JButton("Button 1");//replace with any player actions buttons
            JButton testButton = new JButton("MOVE!");
            testButton.setBounds(400, 70, 80, 50);
            testButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   
                }
            });
            userFunctionsPanel.add(testButton);
            JButton button2 = new JButton("Button 2");
            //userFunctionsPanel.add(button1);
            userFunctionsPanel.add(button2);

            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
            frame.getContentPane().add(userFunctionsPanel, BorderLayout.EAST);

            frame.setVisible(true);
        });
    }*/

    // Gotta randomize image selection

    //Add images to the array list for drawing with paintComponent()
    private void addImage() {

        ImageIcon brd = new ImageIcon("Images/board.jpeg");
        board = brd.getImage();
        //board = getScaledImage(board, 900, 655);

        ImageIcon faceIm = new ImageIcon("Images/CardBack-small.jpeg");
        face = faceIm.getImage();

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

        //change j's to the player's rank
        for (int j = 1; j <= pllist.size()+1; j++){

            ImageIcon pIcon = new ImageIcon("Images/dice/" + diceIc[j-1] + j + ".png");
            //ImageIcon pIcon = new ImageIcon("Images/dice/r2.png");
            playerIc = pIcon.getImage();
            diceImg.add(playerIc);
        }


        //deal with face cards
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
        
        /*int x2 = player.playerCoordinates[0];
        int y2 = player.playerCoordinates[1];
        Image dice2 = diceImg.get(0);
        g.drawImage(dice2, x2, y2, this);*/
        int index = 0;

        for (Player player:pllist) {
            if ((player.isInTrailer) || (player.isInOffice)) {
                int x = player.playerCoordinates[0] + (index*5);
                int y = player.playerCoordinates[1] + (index*2);
                index++;

                Image dice = diceImg.get(index);
                g.drawImage(dice, x, y, this);
            } else {
                int x = player.playerCoordinates[0];
                int y = player.playerCoordinates[1];
                index++;

                Image dice = diceImg.get(index);
                g.drawImage(dice, x, y, this);
            }
        }

        //need to implement a way to track player's location
        /*int[] x1 = new int[]{51, 49, 1111, 637}; //this is temporary player's location
        int[] y1 = new int[]{261, 356, 469, 22}; //this is temporary player's location

        for (int j = 0; j < 4; j++){
            Image dice = diceImg.get(j);
            g.drawImage(dice, x1[j], y1[j], this);
        }*/
    }

}