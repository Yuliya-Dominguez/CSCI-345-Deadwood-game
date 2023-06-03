import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
        frame.setSize(1600,900);

        View images = new View(list);

        //add horizontal and vertical scroll bars (for small screens)
        JScrollPane scrollPane = new JScrollPane(images);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //add user functions panel for the player's actions
        JPanel userFunctionsPanel = new JPanel();
        userFunctionsPanel.setBackground(Color.white);
        userFunctionsPanel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.fill = GridBagConstraints.NONE;

        TextField sampleText = new TextField(null, 20);
        sampleText.setBounds(300, 150, 275, 25);
        userFunctionsPanel.add(sampleText, constraints);

        String[] neighbors = {"Saloon", "Main Street", "Bank"};
        JComboBox moveNeighbors = new JComboBox(neighbors);
        moveNeighbors.setBounds(0, 300, 90, 20);
        moveNeighbors.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == moveNeighbors) {
                    sampleText.setText("Moved to " + moveNeighbors.getSelectedItem());
                }
            }
        });
        moveNeighbors.setVisible(false);
        constraints.gridy++;
        userFunctionsPanel.add(moveNeighbors, constraints);

        String[] acts = {"card role 1", "Card role 2", "card role 3", "Board role 1", "Board role 2", "Board role 3", "Board role 4"};
        JComboBox roles =  new JComboBox<>(acts);
        roles.setBounds(0, 500, 150, 20);
        roles.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == roles) {
                    sampleText.setText("Role " + roles.getSelectedItem() + " Chosen.");
                }
            }
        });
        roles.setVisible(false);
        constraints.gridy++;
        userFunctionsPanel.add(roles, constraints);

        String[] currency = {"Rank 2: 4 dollars", "Rank 3: 10 dollars", "Rank 4: 18 dollars", 
        "Rank 5: 28 dollars", "Rank 6: 40 dollars", "Rank 2: 5 credits", "Rank 3: 10 credits", 
        "Rank 4: 15 credits", "Rank 5: 20 credits", "Rank 6: 25 credits"};
        JComboBox upgrades = new JComboBox(currency);
        upgrades.setBounds(0, 700, 150, 20);
        upgrades.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == upgrades) {
                    pllist.get(0).rank = 5;
                    images.repaint();

                    if (upgrades.getSelectedIndex() == 0) {
                        sampleText.setText("Upgraded to rank 2! 4 dollars lost.");
                    }

                    else if (upgrades.getSelectedIndex() == 1) {
                        sampleText.setText("Upgraded to rank 3! 10 dollars lost.");
                    }

                    else if (upgrades.getSelectedIndex() == 2) {
                        sampleText.setText("Upgraded to rank 4! 18 dollars lost.");
                    }

                    else if (upgrades.getSelectedIndex() == 3) {
                        sampleText.setText("Upgraded to rank 5! 28 dollars lost.");
                    }

                    else if (upgrades.getSelectedIndex() == 4) {
                        sampleText.setText("Upgraded to rank 6! 40 dollars lost.");
                    }

                    else if (upgrades.getSelectedIndex() == 5) {
                        sampleText.setText("Upgraded to rank 2! 5 credits lost.");
                    }

                    else if (upgrades.getSelectedIndex() == 6) {
                        sampleText.setText("Upgraded to rank 3! 10 credits lost.");
                        pllist.get(0).rank = 6;
                        images.repaint();
                    }

                    else if (upgrades.getSelectedIndex() == 7) {
                        sampleText.setText("Upgraded to rank 4! 15 credits lost.");
                    }

                    else if (upgrades.getSelectedIndex() == 8) {
                        sampleText.setText("Upgraded to rank 5! 20 credits lost.");
                    }

                    else if (upgrades.getSelectedIndex() == 9) {
                        sampleText.setText("Upgraded to rank 6! 25 credits lost.");
                    }
                }
            }
        });
        upgrades.setVisible(false);
        constraints.gridy++;
        userFunctionsPanel.add(upgrades, constraints);

        JButton testButton = new JButton("MOVE!");
        testButton.setBounds(400, 70, 80, 50);
        testButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        constraints.gridy++;
        userFunctionsPanel.add(testButton, constraints);

        JButton role = new JButton("Take Role");
        role.setBackground(Color.white);
        role.setBounds(100, 70, 95, 50);
        role.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                upgrades.setVisible(false);
                roles.setVisible(true);
                moveNeighbors.setVisible(false);
                sampleText.setText("What role do you want?");
            }
        });
        constraints.gridy++;
        userFunctionsPanel.add(role, constraints);

        JButton act = new JButton("Act");
        act.setBackground(Color.white);
        act.setBounds(0, 120, 95, 50);
        constraints.gridy++;
        userFunctionsPanel.add(act, constraints);

        JButton rehearse = new JButton("Rehearse");
        rehearse.setBackground(Color.white);
        rehearse.setBounds(90, 180, 95, 50);
        constraints.gridy++;
        userFunctionsPanel.add(rehearse, constraints);

        JButton upgrade = new JButton("Upgrade");
        upgrade.setBackground(Color.white);
        upgrade.setBounds(100, 120, 95, 50);
        upgrade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                upgrades.setVisible(true);
                roles.setVisible(false);
                moveNeighbors.setVisible(false);
                sampleText.setText("What rank do you want?");
            }
        });
        constraints.gridy++;
        userFunctionsPanel.add(upgrade, constraints);

        JRadioButton endturn = new JRadioButton("End Turn", false);
        endturn.setBackground(Color.white);
        endturn.setBounds(0, 180, 80, 50);
        constraints.gridy++;
        userFunctionsPanel.add(endturn, constraints);

        pllist = list;

        TextField coordinates = new TextField("Select an action.", 20);
        constraints.gridy++;
        userFunctionsPanel.add(coordinates, constraints);

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(userFunctionsPanel, BorderLayout.EAST);

        frame.setVisible(true);
    }

    //Add images to the array list for drawing with paintComponent()
    private void addImage() {

        ImageIcon brd = new ImageIcon("Images/board.jpeg");
        board = brd.getImage();

        ImageIcon faceIm = new ImageIcon("Images/CardBack-small.jpeg");
        face = faceIm.getImage();

        cards = new ArrayList<>();

        Day day = new Day();
        int[] scenesDrawn = day.getScenesDrawn();

        //Create card images
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

        //Create dice images with corresponding rank
        for (int j = 0; j < pllist.size(); j++){

            int r = pllist.get(j).rank;
            ImageIcon pIcon = new ImageIcon("Images/dice/" + diceIc[j] + r + ".png");
            playerIc = pIcon.getImage();
            diceImg.add(playerIc);

        }
        //deal with face cards
    }

    //Paint all images
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
        
        int index = 0;

        for (Player player:pllist) {
            if ((player.isInTrailer) || (player.isInOffice)) {
                int x = player.playerCoordinates[0] + (index*20);
                int y = player.playerCoordinates[1] + (index*10);

                Image dice = diceImg.get(index);
                g.drawImage(dice, x, y, this);
                index++;
            } else {
                int x = player.playerCoordinates[0];
                int y = player.playerCoordinates[1];

                Image dice = diceImg.get(index);
                g.drawImage(dice, x, y, this);
                index++;
            }
        }
    }

}