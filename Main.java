import java.awt.Color;
import java.awt.Dimension;
import java.util.*;
import java.util.List;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;



public class Main {
    
    static int players_num;
    static int DAY_MAX = 1;

    public static void setPlayersNum(int number) {
        players_num = number;
    }

    public static int getPlayersNum() {
        return players_num;
    }
    
    public static void createAndShowGUI() {

        Deadwood deadwood = new Deadwood();
        List<Player> gamePlayers = new ArrayList<Player>();
        Day day = new Day();
        BoardData boardData = new BoardData();
        SceneCards sceneCards = new SceneCards();
        WrappingUp wrapUp = new WrappingUp();
        Board board = new Board();
        List<BoardData> sets = Board.getBoardLocations();

        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //JLabel label = new JLabel("Deadwood", JLabel.CENTER);
        //label.setVerticalAlignment(JLabel.TOP);
        //frame.getContentPane().add(label);

        JLayeredPane window = new JLayeredPane();
        window.setPreferredSize(new Dimension(700, 400));
        window.setBorder(BorderFactory.createTitledBorder("Deadwood"));

        ImageIcon backgroundImage = new ImageIcon("Images/board.jpeg");
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        //backgroundLabel.setBounds(0, 0, 10, 600);

        window.add(backgroundLabel, -1);

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

        window.add(imageLabel1, 0);
        window.add(imageLabel2, 1);

        JLayeredPane menu = new JLayeredPane();
        menu.setBounds(1025, 20, 200, 700);
        window.add(menu, 0);
        menu.setVisible(false);

        JLayeredPane numPlayers = new JLayeredPane();
        numPlayers.setBounds(1025, 20, 200, 700);
        numPlayers.setBackground(Color.white);
        window.add(numPlayers, 1);

        TextField sampleText = new TextField(null, 20);
        sampleText.setBounds(300, 150, 275, 25);
        window.add(sampleText, 1);

        JLabel playerSelect = new JLabel("Select Number of Players:");
        playerSelect.setBounds(0, 20, 300, 30);
        numPlayers.add(playerSelect, 0);


        JButton player2 = new JButton("2 Players");
        player2.setBounds(20, 60, 100, 30);
        player2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setPlayersNum(2);
                DAY_MAX = 3;
                numPlayers.setVisible(false);
                menu.setVisible(true);
                sampleText.setText("Player count: " + getPlayersNum());
            }
        });
        numPlayers.add(player2);

        JButton player3 = new JButton("3 Players");
        player3.setBounds(20, 95, 100, 30);
        player3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setPlayersNum(3);
                DAY_MAX = 3;
                numPlayers.setVisible(false);
                menu.setVisible(true);
                sampleText.setText("Player count: " + getPlayersNum());

                // int player_x = 100;
                // int player_y = 30;
                // for (int i = 0; i < players_num; i++) {
                //     Player player1 = new Player();
                //     gamePlayers.add(player1);
        
                    
                //     if (i % 2 == 1) {
                //         JLabel player_stats = new JLabel("Player" + i);
                //         player_stats.setBounds(player_x,(370 + (player_y * i)),100, 30);
                //         menu.add(player_stats, 3);
                //         i++;
                //     }
                //     else {
                //         JLabel player_stats = new JLabel("Player" + i);
                //         player_stats.setBounds(0,(370 + (player_y * i)),100, 30);
                //         menu.add(player_stats, 3);
                //         i++;
                //     }
                // }
            }
        });
        numPlayers.add(player3);

        JButton player4 = new JButton("4 Players");
        player4.setBounds(20, 130, 100, 30);
        player4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DAY_MAX = 4;
                setPlayersNum(4);
                numPlayers.setVisible(false);
                menu.setVisible(true);
                sampleText.setText("Player count: " + getPlayersNum());
            }
        });
        numPlayers.add(player4);

        JButton player5 = new JButton("5 Players");
        player5.setBounds(20, 165, 100, 30);
        player5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DAY_MAX = 4;
                setPlayersNum(5);
                numPlayers.setVisible(false);
                menu.setVisible(true);
                sampleText.setText("Player count: "+ getPlayersNum());
            }
        });
        numPlayers.add(player5);

        JButton player6 = new JButton("6 Players");
        player6.setBounds(20, 200, 100, 30);
        player6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DAY_MAX = 4;
                setPlayersNum(6);
                numPlayers.setVisible(false);
                menu.setVisible(true);
                sampleText.setText("Player count: " + getPlayersNum());
            }
        });
        numPlayers.add(player6);

        JButton player7 = new JButton("7 Players");
        player7.setBounds(20, 235, 100, 30);
        player7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DAY_MAX = 4;
                setPlayersNum(7);
                numPlayers.setVisible(false);
                menu.setVisible(true);
                sampleText.setText("Player count: " + getPlayersNum());
            }
        });
        numPlayers.add(player7);

        JButton player8 = new JButton("8 Players");
        player8.setBounds(20, 270, 100, 30);
        player8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DAY_MAX = 4;
                setPlayersNum(8);
                numPlayers.setVisible(false);
                menu.setVisible(true);
                sampleText.setText("Player count: " + getPlayersNum());
            }
        });
        numPlayers.add(player8);
        
        
        JLabel menuTitle = new JLabel("MENU");
        menuTitle.setBounds(75, 0, 50, 30);
        menu.add(menuTitle, 0);
        
        //ActionListener showText = new ActionListener();
        
        JButton testButton = new JButton("Click!");
        testButton.setBounds(400, 70, 80, 50);
        testButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(true);
                sampleText.setText("AYOoo Puss in Boots x Death x Kitty Softpaws?!?!");
            }
        });
        window.add(testButton, 2);

        JButton disButton = new JButton("Disappear!");
        disButton.setBounds(400, 200, 80, 50);
        disButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                sampleText.setText("The menu gone?!");
            }
        });
        window.add(disButton, 2);

        String[] neighbors = {"Saloon", "Main Street", "Bank"};
        JComboBox moveNeighbors = new JComboBox(neighbors);
        moveNeighbors.setBounds(0, 300, 90, 20);
        moveNeighbors.setVisible(false);
        menu.add(moveNeighbors, 3);

        String[] acts = {"card role 1", "Card role 2", "card role 3", "Board role 1", "Board role 2", "Board role 3", "Board role 4"};
        JComboBox roles =  new JComboBox<>(acts);
        roles.setBounds(0, 300, 150, 20);
        roles.setVisible(false);
        menu.add(roles, 3);

        String[] currency = {"Rank 2: 4 dollars", "Rank 3: 10 dollars", "Rank 4: 18 dollars", 
        "Rank 5: 28 dollars", "Rank 6: 40 dollars", "Rank 2: 5 credits", "Rank 3: 10 credits", 
        "Rank 4: 15 credits", "Rank 5: 20 credits", "Rank 6: 25 credits"};
        JComboBox upgrades = new JComboBox(currency);
        upgrades.setBounds(0, 300, 150, 20);
        upgrades.setVisible(false);
        menu.add(upgrades, 3);

        JButton move = new JButton("move");
        move.setBackground(Color.white);
        move.setBounds(0, 70, 80, 50);
        move.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                upgrades.setVisible(false);
                roles.setVisible(false);
                moveNeighbors.setVisible(true);
                sampleText.setText("Move to where?");
            }
        });
        menu.add(move, 3);

        

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
        menu.add(role, 3);

        JButton act = new JButton("Act");
        act.setBackground(Color.white);
        act.setBounds(0, 120, 95, 50);
        menu.add(act, 4);

        JButton rehearse = new JButton("Rehearse");
        rehearse.setBackground(Color.white);
        rehearse.setBounds(90, 180, 95, 50);
        menu.add(rehearse, 4);

        

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
        menu.add(upgrade, 4);

        JRadioButton endturn = new JRadioButton("End Turn", false);
        endturn.setBackground(Color.white);
        endturn.setBounds(0, 180, 80, 50);
        menu.add(endturn, 5);

        
        // moveNeighbors.setSelectedIndex(0);
        // moveNeighbors.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         String neighborName = moveNeighbors.getItemAt(moveNeighbors.getSelectedIndex());
        //     }
        // });

        frame.getContentPane().add(window);
        
        //move.setBounds();
        //frame.getContentPane().add(move);

        frame.pack();
        frame.setVisible(true);
        frame.setSize(1300, 825);
    }
    //Store store = Store.getStoreInstance();
    
    //Dice dice = new Dice();
   
    //LocationManager locManager = new LocationManager();
    //Acting acting = new Acting();
    
    
    

public static void main(String[] args) {

    //Initiallizing the classes to be used in main.
    Deadwood deadwood = new Deadwood();
    List<Player> gamePlayers = new ArrayList<Player>();
    Day day = new Day();
    BoardData boardData = new BoardData();
    SceneCards sceneCards = new SceneCards();
    WrappingUp wrapUp = new WrappingUp();
    Board board = new Board();
    List<BoardData> sets = Board.getBoardLocations();


    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            createAndShowGUI();
        }
    });
    /*
     * Beginning of game. Prompt player for input to ender number of players to create player classes and set DAY_MAX.
     */
    
    Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Deadwood! Please enter the number of players: ");
        int playerNum = input.nextInt();

        //Check if player does not enter correct number of players.
        if ((playerNum < 2) || (playerNum > 8)) {
            System.out.println("Error. Please enter a number between 2 and 8.");
        }
        //Set the maximum number of days. Set to 3 if 2-3 players, 4 otherwise.
        else {
            if (playerNum <= 3) {
                DAY_MAX = 3;
            }
            else {
                DAY_MAX = 4;
            }

            //Create player classes to go into List gamePlayers.
            for(int a = 0; a < playerNum; a++) {
                Player player1 = new Player();
                gamePlayers.add(player1);
            }

            int i = 0;
            
            //
            for (Player player: gamePlayers) {
                System.out.println(("What is Player ") + (i + 1) + (" name? \n"));
                String inputName = input.next();
                player.name = inputName;
                player.isInTrailer = true;
                i++;
                //Below is index number for all locations excluding Trailer and Office.
                //0 = Train Station
                //1 = Secret Hideout
                //2 = Church
                //3 = Hotel
                //4 = Main Street
                //5 = Jail
                //6 = General Store
                //7 = Ranch
                //8 = Bank
                //9 = Saloon
                
            }
            //Call day.setUp() to draw scenes, set up the board, and fully start the game.
            day.setUp();
            System.out.println("Game is set up! \n"); 

        }
        //Extra variables. playerturn checks if it is still the current player's turn, 
        //  scenesFinished checks how many scenes have been completed.
        int playerturn = 1;
        int scenesFinished = 0;
        //Whole game, doesn't end until all days are up.
        while (day.dayCount <= DAY_MAX) {

            //Loop to iterate through every player's turn.
            for (Player player:gamePlayers) {

                //Check to keep turn on player if action they take doesn't end their turn.
                while(playerturn > 0){

                    //Accepting player input of commands. Recommends 'options' for player to see what they can type.
                    System.out.println("Your turn Player " + player.name + "! " + "Please type in your command, or 'options' for a list of available commands.\n");
                    String action = input.next(); 

                    //If 'options' was chosen, print out all possible actions player can take, what to type, and what each action does.
                    if (action.equals("options")) {

                        System.out.println("\n" + "'move': Moves player to desired location, if possible.");

                        System.out.println("'stats': Shows current player's stats and info.");

                        System.out.println("'scenestats': Shows scene card's information that player is currently on/next to. ");

                        System.out.println("'boardstats': Shows location player is on, including available board roles and neighboring locations.");
                        
                        System.out.println("'day': Shows current day in game.");
                        
                        System.out.println("'takerole': Takes the role that you specify. Only works if your rank is equal to or higher than the role's rank.");
                        
                        System.out.println("'upgrade': Upgrade your rank level (only works if you are at location 'Casting Office').");
                        
                        System.out.println("'act': Act your role (only works if you have taken a role in a scene).");
                        
                        System.out.println("'rehearse': Rehearse your role. Add a token to your acting roll.");
                        
                        System.out.println("'endturn': Ends current Player's turn. ");
                        
                        System.out.println("'quit': Quits the game.\n");
                    }


                    //If 'move' was chosen, prompt the player for which neighbor location they want to move to.
                    else if (action.equals("move")) {

                        //Prompt user about which neighbor to move to.
                        System.out.println("\nWhich neighbor will you move to? (Enter neighbor's number (1,2,3,etc.)");
                        int neighborMove = input.nextInt();
                        int moveSuccess = 0;

                        //MoveCheck if the player is trying to move from the trailer.
                        if (player.isInTrailer == true) {

                            //Move player location to Main Street if they choose 1.
                            if (BoardData.getTrailNeighbor(neighborMove-1).equals("Main Street")) {
                                player.move(4);
                                System.out.println("Moved to Main Street.");
                                player.isInTrailer = false;
                                moveSuccess = 1;
                            }
                            //Move player location to Saloon if they choose 2.
                            else if (BoardData.getTrailNeighbor(neighborMove-1).equals("Saloon")) {
                                player.move(9);
                                System.out.println("Moved to Saloon.");
                                player.isInTrailer =false;
                                moveSuccess = 1;
                            }
                            //Move player location to Hotel if they choose 3.
                            else if (BoardData.getTrailNeighbor(neighborMove-1).equals("Hotel")) {
                                player.move(3);
                                System.out.println("Moved to Hotel.");
                                player.isInTrailer = false;
                                moveSuccess = 1;
                            }
                        }

                        //MoveCheck if the player is trying to move from the casting office.
                        else if (player.isInOffice == true) {

                            //Move player location to Train Station if they choose 1.
                            if (BoardData.getOffNeighbor(neighborMove-1).equals("Train Station")) {
                                player.move(0);
                                System.out.println("Moved to Train Station.");
                                player.isInOffice = false;
                                moveSuccess = 1;
                            }

                            //Move player location to Ranch if they choose 2.
                            else if (BoardData.getOffNeighbor(neighborMove-1).equals("Ranch")) {
                                player.move(7);
                                System.out.println("Moved to Ranch.");
                                player.isInOffice =false;
                                moveSuccess = 1;
                            }

                            //Move player location to Secret Hideout if they choose 3.
                            else if (BoardData.getOffNeighbor(neighborMove-1).equals("Secret Hideout")) {
                                player.move(1);
                                System.out.println("Moved to Secret Hideout.");
                                player.isInOffice = false;
                                moveSuccess = 1;
                            }
                        }

                        //General check for loactions aside from trailer and casting
                        else {
                            for (int a = 0; a < (BoardData.getNeighborsList(player.playerLocation).size()+1); a++) {

                                if (BoardData.getNeighborName(player.playerLocation, a).equals(BoardData.getNeighborName(player.playerLocation, neighborMove))){
                                    int loactionToMove = 0;

                                    //Check if player is moving to trailer from another location.
                                    if (BoardData.getNeighborName(player.playerLocation, neighborMove).equals("trailer")) {
                                        player.isInTrailer = true;
                                        moveSuccess = 1;

                                        //store player's x and y coordinates
                                        player.playerCoordinates[0] = BoardData.getTrailerArea().getX();
                                        player.playerCoordinates[1] = BoardData.getTrailerArea().getY();
                                    }
                                    
                                    //Check if player is moving to office from another loaction.
                                    else if (BoardData.getNeighborName(player.playerLocation, neighborMove).equals("office")) {
                                        player.isInOffice = true;
                                        moveSuccess = 1;

                                        //store player's x and y coordinates
                                        player.playerCoordinates[0] = BoardData.getOfficeArea().getX();
                                        player.playerCoordinates[1] = BoardData.getOfficeArea().getY();
                                    }

                                    else {
                                        //Check for index of location to move player properly!
                                        for (int i = 0; i < 10; i++) {

                                            if (BoardData.getNeighborName(player.playerLocation, neighborMove).equals(BoardData.getSetName(i))) {
                                                loactionToMove = i;
                                            }
                                        }
                                        player.move(loactionToMove);
                                        System.out.println("Moved to " + BoardData.getSetName(player.playerLocation));
                                        moveSuccess = 1;

                                        //store player's x and y coordinates
                                        player.playerCoordinates[0] = BoardData.getSetArea(player.playerLocation).getX();
                                        player.playerCoordinates[1] = BoardData.getSetArea(player.playerLocation).getY();
                                    }
                                }
                            }
                            
                        }
                        if (moveSuccess == 1) {
                            break;
                        }

                        else {
                            System.out.println("Sorry, that move is invalid. Choose a different neighbor.");
                        }
                    }


                    //If 'scenestats' was chosen, display information about the scene card on the location the player is at currently.
                    else if (action.equals("scenestats")){

                        //Check if the player is in the trailer or office, where no scene is assigned.
                        if ((player.isInTrailer == true) || (player.isInOffice == true)) {
                            System.out.println("There is no scene attached to this location. \n");
                        }
                        //Check if the sceneIndex value is -1, meaning that the scene is completed.
                        else if (Board.getBoardLocations().get(player.playerLocation).getSceneIndex() == -1) {
                            System.out.println("The scene here is completed! Find an open scene on a different set. \n");
                        }
                        //Print out scene attached to the loaction player is at currently.
                        else {

                            System.out.println("\n" + "Scene Name: " + SceneCards.getName(boardData.getSceneIndex()));
                            System.out.println("Scene Number: " + sceneCards.getSceneNumber(boardData.getSceneIndex()));
                            System.out.println("Scene Budget: " + sceneCards.getCardBudget(boardData.getSceneIndex()));
                            System.out.println("Scene Description: " + sceneCards.getSceneDescription(boardData.getSceneIndex()));
                            
                            //Iterates through all parts contained in the scene card.
                            for (int i = 0; i < SceneCards.getPartsList(boardData.getSceneIndex()).size(); i++) {
                                System.out.println("Scene Part " + (i + 1));
                                System.out.println("\t Name: " + SceneCards.getPartName(boardData.getSceneIndex(), i));
                                System.out.println("\t Level: " + SceneCards.getPartLevel(boardData.getSceneIndex(), i));
                                System.out.println("\t Line: " + SceneCards.getPartLine(boardData.getSceneIndex(), i) + "\n");
                            }
                        }
                    }


                    //If 'boardstats' was chosen, display information about the board location the player is at currently.
                    else if (action.equals("boardstats")){

                        if (player.isInTrailer == true) {
                            System.out.println("\nBoard Name: Trailer");
                            for (int x = 0; x < BoardData.getTrailerNeighbors().size(); x++){
                                System.out.println("Neighbor " + (x+1) + "'s Name: " + BoardData.getTrailNeighbor(x));
                            }
                            
                        }
                        else if (player.isInOffice == true) {
                            System.out.println("\nBoard Name: Office");
                            for (int x = 0; x < BoardData.getOfficeNeighbors().size(); x++){
                                System.out.println("Neighbor " + (x+1) + "'s Name: " + BoardData.getOffNeighbor(x));
                            }
                            
                        }
                        else {

                            System.out.println("\nBoard Name: " + BoardData.getSetName(player.playerLocation));
                            System.out.println("Number of Board Takes Left: " + (BoardData.getTakesList(player.playerLocation).size() - board.takesLeft));
                            if (boardData.getSceneIndex() == -1) {
                                System.out.println("Scene: Finished ");
                            }
                            else {
                                System.out.println("Scene: " + SceneCards.getName(boardData.getSceneIndex()) + "\tIndex: " + boardData.getSceneIndex());
                            }
                
                            for (int a = 0; a < BoardData.getNeighborsList(player.playerLocation).size(); a++) {
                                System.out.println("Board Neighbor " + (a+1) + "'s Name: " + BoardData.getNeighborName(player.playerLocation, a));
                                
                            }

                            for (int i = 0; i < BoardData.getPartsList(player.playerLocation).size(); i++) {
                                System.out.println("Board Part " + (i + 1));
                                System.out.println("\t Name: " + BoardData.getPartName(player.playerLocation, i));
                                System.out.println("\t Level: " + BoardData.getPartLevel(player.playerLocation, i));
                                System.out.println("\t Line: " + BoardData.getPartLine(player.playerLocation, i) + "\n");
                            }
                        }

                    }


                    //If 'takerole' was chosen, have player choose their role from the scene they are on or board they are on.
                    else if (action.equals("takerole")){

                        if ((player.isInTrailer == true) || (player.isInOffice == true)) {
                            System.out.println("There is no scene attached to this location. \n");
                        }
                        else {

                            System.out.println("\n" + "Will you take a scene part or board part? (Enter 'scene' or 'board') \n");
                            String roleSection = input.next();
                            System.out.println("Which part number will you take? (Type in 1,2,3, or 4 depending on part number.) \n");
                            int partToTake = input.nextInt();

                            //Code here to print success or failure message.
                            int success = player.takeRole(roleSection, (partToTake-1));
                            

                            if (success == 1) {
                                System.out.println("Role "+ SceneCards.getPartName(player.sceneIndexNumber, (partToTake-1)) + " has been taken!");
                                sets.get(player.playerLocation).fillMainRoll(1);

                                //store player's x and y coordinates
                                player.playerCoordinates[0] = SceneCards.getPartArea(player.sceneIndexNumber, player.playerRolePosition).getX();
                                player.playerCoordinates[1] = SceneCards.getPartArea(player.sceneIndexNumber, player.playerRolePosition).getY();

                                break;
                            }
                            else if (success == 2) {
                                System.out.println("Role "+ SceneCards.getPartName(player.sceneIndexNumber, (partToTake-1)) + " has been taken!");

                                //store player's x and y coordinates
                                player.playerCoordinates[0] = BoardData.getPartArea(player.playerLocation, player.playerRolePosition).getX();
                                player.playerCoordinates[1] = BoardData.getPartArea(player.playerLocation, player.playerRolePosition).getY();

                                break;
                            }

                            else if (success == -1){
                                System.out.println("Error. Invalid set type ('scene' or 'board') invalid part number. Please try again.");
                            }
                        }
                    }


                    //If 'upgrade' was chosen, upgrade the player's rank if they have enough credits or dollars.
                    else if (action.equals("upgrade")){

                        //Code here to check if player's location is Casting Office.
                        if (player.isInOffice != true) {
                            System.out.println("There is no upgrade attached to this location. Move to Office to upgrade rank. \n");
                        }
                        else {

                           
                            System.out.println("\n" + "What rank would you like to upgrade to? (enter number between 2 and 6)\n");
                            int rankWanted = input.nextInt();
                            System.out.println("What will you pay with? ('credit' or 'dollar')");

                            String payment = input.next();
                            player.upgrade(rankWanted, payment);

                            break;
                        }
                    }


                    //If 'act' was chosen, have the player act out their role if they have taken one.
                    else if (action.equals("act")){

                        //need a check in here to wrap up based on the shot counter.
                        if (player.playerRole != null) {
                            System.out.println("Rolling for acting...");
                            //int roll = dice.readDice();
                            int attempt = player.act();
                            if (attempt == 1){
                                board.takesLeft++;
                                if ((BoardData.getTakesList(player.playerLocation).size() - board.takesLeft) == 0) {
                                    Board.getBoardLocations().get(player.playerLocation).takeSceneIndex(-1);
                                    if (player.playerRole.equals("Main")) {
                                        wrapUp.playerMainBonus();
                                        player.playerRole = "None";
                                        scenesFinished++;
                                    }
                                    else {
                                        if (sets.get(player.playerLocation).isMainRoleFilled() == 1){
                                            wrapUp.mainActorRoleFilled = true;
                                        }
                                        wrapUp.playerExtraBonus();
                                        player.playerRole = "None";
                                        scenesFinished++;
                                    }
                                    //System.out.println("That's a wrap! Scene is over!");
                                }
                                break;
                            }

                            else {
                                break;
                            }
                            
                        }

                        else {
                            System.out.println("Error. Player needs to have taken a role from a scene before they can act.");
                        }
                    }

                    //If 'rehearse' was chosen, add a rehearse counter to player if they have a role chosen.
                    else if (action.equals("rehearse")) {
                        if (player.playerRole != null){
                            player.rehearse();
                            break;
                        }
                        else {
                            System.out.println("Error. Cannot take this action without a role chosen.");
                        }
                        
                    }


                    //If 'stat' was chosen, show current player's stats.
                    else if (action.equals("stats")) {
                        player.checkInfo();
                    }


                    //If 'day' was chosen, print the current day (1, 2, 3, or 4).
                    else if (action.equals("day")) {
                        System.out.println("\n" +"This is day " + day.dayCount + "\n");
                    }


                    //If 'quit' was chosen, prompt to exit the program or not.
                    else if (action.equals("quit")) {
                        System.out.println("Are you sure you want to quit? 'y/n'");
                        String response = input.next();
                        if ((response.equals("yes")) || (response.equals("y"))){
                            System.out.println("Thank you! We hope to see you again!");
                            System.exit(1);
                        }
                        else if ((response.equals("no")) || (response.equals("n"))) {
                            System.out.println("Okay! Resuming game. \n");
                        }
                        else {
                            System.out.println("Error. Please answer yes or no if you would like to quit.");
                        }
                    }


                    //If 'endturn' was chosen, end current player's turn.
                    else if (action.equals("endturn")) {
                        System.out.println("Turn ended. \n");
                        break;
                    }


                    //Check if something other than above commands is typed.
                    else{
                        System.out.println("\n" + 
                        "Sorry, that command is not available. Please type 'options' to see the list of available options. \n");
                    }

                    //Need a check down here to see how many scenes are left on the board, then call endDay().
                    
                }
            }
        //If statement here for a counter of scenes left. If scenecounter == 9, increase day.dayCount.
            if (scenesFinished == 9) {
                day.endDay();
                for (Player player:gamePlayers) {
                    player.isInTrailer = true;
                }
                day.dayCount++;
            } 
        }

    //Finish the game by calculating the score of each player and declare winner! 
    System.out.println("\nGame is over! Calculating scores...\n");
    int[] scores = new int[gamePlayers.size()];
    int[] ranks = new int[gamePlayers.size()];
    String[] names = new String[gamePlayers.size()];
    int c = 0;
    for (Player player:gamePlayers) {
        scores[c] = deadwood.scoring(player);
        ranks[c] = player.rank;
        names[c] = player.name;
        c++;
    }
    deadwood.decideWinner(scores, ranks, names);
    input.close();
}

}