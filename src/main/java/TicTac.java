/**
 * Name: TicTac.java
 * Date: 8/10/2020
 * @author: Abdallah Alqashqish
 * Functionality: Controls the game window and game functionality
 */

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class TicTac extends javax.swing.JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = -484155684440604087L;

    // Variables declaration                   
    public static javax.swing.JButton button1;
    public static javax.swing.JButton button2;
    public static javax.swing.JButton button3;
    public static javax.swing.JButton button4;
    public static javax.swing.JButton button5;
    public static javax.swing.JButton button6;
    public static javax.swing.JButton button7;
    public static javax.swing.JButton button8;
    public static javax.swing.JButton button9;
    public javax.swing.JButton resetBtn;
    public javax.swing.JButton exitBtn;
    public javax.swing.JLabel titleLabel;
    public javax.swing.JLabel playerLabel;
    public javax.swing.JLabel computerLabel;
    public javax.swing.JLabel playerScoreLabel;
    public javax.swing.JLabel computerScoreLabel;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    // End of variables declaration
    
    //MatrixTextViews
    MatrixTextView tview1;
    MatrixTextView tview2;
    MatrixTextView tview3;
    MatrixTextView tview4;
    MatrixTextView tview5;
    MatrixTextView tview6;
    MatrixTextView tview7;
    MatrixTextView tview8;
    MatrixTextView tview9;
    //Array that will contain the MatrixTextViews
    static MatrixTextView[] tviews = new MatrixTextView[9];
    //The Matrix
    static Matrix gameMatrix = new Matrix(3, 3);
    
    //Turn
    int playerTurn = 1;
    
    //Scores
    int playerScore = 0;
    int compScore = 0;
        
    /**
     * Creates new form tictactoeUI
     */
    public TicTac() {
        initComponents();
        this.setSize(1200, 600);
        this.setResizable(true);
    }

    /**
     * Name: initComponents
     * Date: 8/10/2020
     * @return: Declares and sets up all parts of the UI
     */
    private void initComponents() {

    	//Declare the variables
        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        button1 = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        button3 = new javax.swing.JButton();
        playerLabel = new javax.swing.JLabel();
        playerScoreLabel = new javax.swing.JLabel();
        button4 = new javax.swing.JButton();
        button5 = new javax.swing.JButton();
        button6 = new javax.swing.JButton();
        computerLabel = new javax.swing.JLabel();
        computerScoreLabel = new javax.swing.JLabel();
        button7 = new javax.swing.JButton();
        button8 = new javax.swing.JButton();
        button9 = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        
        //MatrixTextViews
        tview1 = new MatrixTextView(button1, 0, 0);
        tview2 = new MatrixTextView(button2, 0, 1);
        tview3 = new MatrixTextView(button3, 0, 2);
        tview4 = new MatrixTextView(button4, 1, 0);
        tview5 = new MatrixTextView(button5, 1, 1);
        tview6 = new MatrixTextView(button6, 1, 2);
        tview7 = new MatrixTextView(button7, 2, 0);
        tview8 = new MatrixTextView(button8, 2, 1);
        tview9 = new MatrixTextView(button9, 2, 2);
        
        //Add the MatrixTextViews to the array
        tviews[0] = tview1;
        tviews[1] = tview2;
        tviews[2] = tview3;
        tviews[3] = tview4;
        tviews[4] = tview5;
        tviews[5] = tview6;
        tviews[6] = tview7;
        tviews[7] = tview8;
        tviews[8] = tview9;

        //Sets close operation for window
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //Sets the title
        setTitle("Tic Tac Toe");
        //Is the window resizable?
        setResizable(false);

        //Sets up the panel
        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new java.awt.BorderLayout());

        //Sets up the titleLabel
        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 100)); 
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Tic Tac Toe");
        jPanel1.add(titleLabel, java.awt.BorderLayout.PAGE_START);

        //Sets up the the panel that will contain all the buttons of the game
        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new java.awt.GridLayout(3, 5, 2, 2));

        //Sets up the button1
        setUpButton(tview1);

        //Sets up the button2
        setUpButton(tview2);

        //Sets up the button3
        setUpButton(tview3);

        //Label that tells the user that it displays his score
        playerLabel.setBackground(new java.awt.Color(0, 0, 0));
        playerLabel.setFont(new java.awt.Font("Tahoma", 0, 45)); 
        playerLabel.setForeground(new java.awt.Color(255, 255, 255));
        playerLabel.setText("Player: ");
        //Add the label to the panel
        jPanel2.add(playerLabel);

        //Label that will display the users score
        playerScoreLabel.setBackground(new java.awt.Color(0, 0, 0));
        playerScoreLabel.setFont(new java.awt.Font("Tahoma", 0, 45)); 
        playerScoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        playerScoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerScoreLabel.setText("");
        playerScoreLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        //Add the label to the panel
        jPanel2.add(playerScoreLabel);

        //Sets up the button4
        setUpButton(tview4);

        //Sets up the button5
        setUpButton(tview5);

        //Sets up the button6
        setUpButton(tview6);

        //Shows the computers part for the score
        computerLabel.setBackground(new java.awt.Color(0, 0, 0));
        computerLabel.setFont(new java.awt.Font("Tahoma", 0, 45)); 
        computerLabel.setForeground(new java.awt.Color(255, 255, 255));
        computerLabel.setText("Comp: ");
        //Adds the label to the panel
        jPanel2.add(computerLabel);

        //Displays the computers score
        computerScoreLabel.setBackground(new java.awt.Color(0, 0, 0));
        computerScoreLabel.setFont(new java.awt.Font("Tahoma", 0, 45)); 
        computerScoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        computerScoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        computerScoreLabel.setText("");
        //Adds the label to the panel
        jPanel2.add(computerScoreLabel);

        //Sets up the button7
        setUpButton(tview7);

        //Sets up the button8
        setUpButton(tview8);

        //Sets up the button9
        setUpButton(tview9);

        //Sets up the resetBtn
        resetBtn.setBackground(new java.awt.Color(0, 0, 0));
        resetBtn.setFont(new java.awt.Font("Tahoma", 0, 70)); 
        resetBtn.setForeground(new java.awt.Color(255, 255, 255));
        resetBtn.setText("Reset");
        //Controls what the button does when clicked
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnAction(evt);
            }
        });
        //Adds the button to the panel
        jPanel2.add(resetBtn);

        //Sets up the exit button
        exitBtn.setBackground(new java.awt.Color(0, 0, 0));
        exitBtn.setFont(new java.awt.Font("Tahoma", 0, 70)); 
        exitBtn.setForeground(new java.awt.Color(255, 255, 255));
        exitBtn.setText("Exit");
        //Controls what the button does when clicked
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnAction(evt);
            }
        });
        //Add the button to the panel
        jPanel2.add(exitBtn);

        //Add jPanel2 to jPanel1
        //Place jPanel2 in the center of jPanel1
        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        //Add jPanel1 to the windows content pane
        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        
        //Refresh the game
        refresh();
    }
    
    public JFrame frame;

    //Functions that control the functionality of the buttons
    
    /**
     * Name: setUpButton
     * Date: 8/10/2020
     * Functionality: Sets up an individual button
     * @param tview: The button we would like to set up and the number of the button
     * Output: Sets the background and foreground of the button as well as what happens when it is clicked
     * */
    private void setUpButton(MatrixTextView tview) {
    	//Sets up the button
        tview.button.setBackground(new java.awt.Color(0, 0, 0));
        tview.button.setForeground(new java.awt.Color(255, 255, 255));
        tview.button.setFont(new java.awt.Font("Tahoma", 0, 100));
        //Controls what the button does when clicked
        userPress(tview);
            
        //Adds the button to the panel
        jPanel2.add(tview.button);
    }
    
    /**
     * Name: resetBtnAction
     * Date: 8/10/2020
     * Functionality: Resets the game
     * Input: When the user presses on the resetBtn
     * Output: Sets all the buttons in the game grid to empty text and the score to 0
     * */
    private void resetBtnAction(java.awt.event.ActionEvent evt) {
    	//Resets the grid
        resetGame(true);
        
        //Refreshes the grid and score
        refresh();
    }
    
    /**
     * Name: exitBtnAction
     * Date: 8/10/2020
     * Functionality: When the exitBtn is clicked, a popup will show asking the user to confirm he would like to leave the game
     * @param evt: The ActionEvent of the button
     * Output: If the user presses yes, exit the game.
     * */
    private void exitBtnAction(java.awt.event.ActionEvent evt) {
        frame = new JFrame("Exit");
        
        //Did the user select yes?
        if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Tic Tac Toe", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            //Close the window
            System.exit(0);
	}
    }

    //All button functions end
    
    /**
     * Name: userPress
     * Date: 8/10/2020
     * Functionality: Adds the users selection to the matrix, then lets the computer plays, then checks for the circumstance of the game
     * @param btn: The MatrixTextView of the button
     * Output: Adds the user selection and lets the computer play and checks for wins and tie
     * */
    private void userPress(MatrixTextView btn) {
    	btn.button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//Is the slot available?
            	if (gameMatrix.getBoxSymbol(btn) == "" && !isComputerWin(false) && !isPlayerWin(false)) {
                    //Set the text of the button to the users symbol, X
                    gameMatrix.setData(btn.xPos, btn.yPos, playerTurn);
                    //Change turns
                    setPlayerTurn();
                    
                    //Refresh the grid after users turn
                    refresh();
        	    }
            	
            	
                //Let the computer play his turn
                compterTurn();	
            	
            	isPlayerWin(true); //Did the player win?
            	isComputerWin(true); //Did the computer win?
            	isTie(true); //Is it a tie?
            	//Refresh the grid
            	refresh();
            }
        });
	}
    
    /**
     * Name: random
     * Date: 8/10/2020
     * Functionality: Randomly selects a place for the computer to place its turn
     * Output: Randomly places its turn in an empty slot
     * */
    public void randomSelection(){
        Random rd = new Random();
        //Generate new random number
        int randomNum = rd.nextInt(9) + 1;
        //Was the computer able to play a turn?
        boolean isTurnPlayed = false;
        while(!isTurnPlayed){
          	//Is the spot taken?
            if (!gameMatrix.getBoxSymbol(tviews[randomNum - 1]).isEmpty()) randomNum = rd.nextInt(9) + 1;
        
            else{ //Available spot?
            	tviews[randomNum - 1].addData(gameMatrix, playerTurn);
            	//Exit the loop
            	isTurnPlayed = true;
            }
        }
        //Change players turn
        setPlayerTurn();
            
        //Refresh the grid
        refresh();
    }
    
    /**
     * Name: computerTurn
     * Date: 8/10/2020 
     * Functionality: Plays as the computer
     * Output: Plays the turn according to the grid
     * */
    private void compterTurn() {
    	if (!isTie(false) && !isPlayerWin(false) && !isComputerWin(false) && playerTurn == 0) { //Did anyone win, is it a tie and is it the computers turn
            //To store the spots where the computer will win
            ArrayList<MatrixTextView> wins = new ArrayList<>();
            //Store where the computer will lose
            ArrayList<MatrixTextView> stops = new ArrayList<>();

            //Play as computer
            for (MatrixTextView tview : tviews) { //Go through the spots
                if (gameMatrix.getBoxSymbol(tview).isEmpty()) { //Is the spot available?
                    //Try the spot
                    tview.addData(gameMatrix, 0);
                    //Does the computer win on this spot?
                    if (isComputerWin(false)) wins.add(tview);
                    //Undo the move
                    tview.addData(gameMatrix, 4);
                }
            }

            //Play as user
            for (MatrixTextView view : tviews) {
                if (gameMatrix.getBoxSymbol(view).isEmpty()) { //Is the spot available?
                    //Try the spot as the user
                    view.addData(gameMatrix, 1);

                    //Does the user win on this spot?
                    if (isPlayerWin(false)) stops.add(view);
                    //Undo the move
                    view.addData(gameMatrix, 4);
                }
            }

            if (wins.size() != 0){ //Is there a spot to win?
                wins.get(0).addData(gameMatrix, 0);
                setPlayerTurn();
            }else if (stops.size() != 0){ //Is there a spot to lose?
                stops.get(0).addData(gameMatrix, 0);
                setPlayerTurn();
            } else if (tview5.getText().isEmpty()) { //Is the center available?
                tview5.addData(gameMatrix, 0);
                setPlayerTurn();
            }

            //Otherwise selectRandomly
            else randomSelection();
    	}
    	//Refresh the grid
        refresh();
    }
    
    /**
     * Name: resetGame
     * Date: 8/10/2020
     * Functionality: Resets the game grid
     * Output: Empties the grid and sets the default background
     * */
    private void resetGame(boolean isNewGame) {
    	//Set the matrix to default number, 4
    	gameMatrix.setMatrixData();
    	//Set the player turn to 1
        playerTurn = 1;

        if (isNewGame) {
            playerScore = 0;
            compScore = 0;
        }
        
        //Set the background to default color
        for (MatrixTextView matrixTextView : tviews) matrixTextView.button.setBackground(new java.awt.Color(0, 0, 0));
        
        //Refresh the game grid
        refresh();
	}
    
    /**
     * Name: win
     * Date: 8/10/2020
     * Functionality: Sets the buttons red or green depending on who won as well as informing the user and adjusting the score
     * @param buttons: Array of buttons that caused the win
     * @param color: The color to change the background of the buttons to
     * @param message: The message to display to the user
     * Output: Sets the buttons to the color, and displays to the user who won. The resets the game and adjusts the score 
     * */
    void win(JButton buttons[], Color color, String message) {
    	for (JButton button : buttons) button.setBackground(color);
        
    	
    	//Show the message to the user
    	JOptionPane.showMessageDialog(this, message, "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
		
    	//Resets the game grid
	    resetGame(false);
    }
    
    /**
     * Name: isPlayerWin
     * Date: 8/10/2020
     * Functionality: Checks if the user won, and if asked to, displays the spot as green
     * @param show: Do we show the winner?
     * @return: True -> The user won
     *          False -> The user didn't win
     * */
    private boolean isPlayerWin(boolean show) {
    	JButton[] jbuttons = new JButton[3];
    	
    	//Did the player win?
	    if (gameMatrix.isRowEqual(0) == 1) {
            if (show) {
                jbuttons[0] = button1;
                jbuttons[1] = button2;
                jbuttons[2] = button3;
                    
                win(jbuttons, Color.GREEN, "You Won!");
                        
                playerScore++;
            }
            return true;
	    } else if(gameMatrix.isRowEqual(1) == 1) {
            if (show) {
                jbuttons[0] = button4;
                jbuttons[1] = button5;
                jbuttons[2] = button6;
                        
                win(jbuttons, Color.GREEN, "You Won!");
                    
                playerScore++;
            }
			
            return true;
	    } else if(gameMatrix.isRowEqual(2) == 1) {
            if (show) {
                jbuttons[0] = button7;
                jbuttons[1] = button8;
                jbuttons[2] = button9;
                
                win(jbuttons, Color.GREEN, "You Won!");
                        
                playerScore++;
            }
			
            return true;
	    } else if(gameMatrix.isColumnEqual(0) == 1) {
            if (show) {
                jbuttons[0] = button1;
                jbuttons[1] = button4;
                jbuttons[2] = button7;
                        
                win(jbuttons, Color.GREEN, "You Won!");
                    
                playerScore++;
            }
			
            return true;
	    } else if(gameMatrix.isColumnEqual(1) == 1) {
            if (show) {
                jbuttons[0] = button2;
                jbuttons[1] = button5;
                jbuttons[2] = button8;
                        
                win(jbuttons, Color.GREEN, "You Won!");
                        
                playerScore++;
            }
			
            return true;
	    } else if(gameMatrix.isColumnEqual(2) == 1) {
            if (show) {
                jbuttons[0] = button3;
                jbuttons[1] = button6;
                jbuttons[2] = button9;
                        
                win(jbuttons, Color.GREEN, "You Won!");
                        
                playerScore++;
            }
			
            return true;
	    } else if(gameMatrix.isDiagonalEqual1() == 1) {
            if (show) {
                jbuttons[0] = button1;
                jbuttons[1] = button5;
                jbuttons[2] = button9;
                        
                win(jbuttons, Color.GREEN, "You Won!");
                        
                playerScore++;
            }
			
            return true;
	    } else if(gameMatrix.isDiagonalEqual2() == 1) {
            if (show) {
                jbuttons[0] = button3;
                jbuttons[1] = button5;
                jbuttons[2] = button7;
                        
                win(jbuttons, Color.GREEN, "You Won!");
                        
                playerScore++;
            }
			
            return true;
            
	    } else return false;
	}
    
    /**
     * Name: isComputerWin
     * Date: 8/10/2020
     * Functionality: Checks if the computer won, and if asked to, displays the spot as red
     * @param show: Do we show the winner?
     * @return: True -> The computer won
     *          False -> The computer didn't win
     * */
    private boolean isComputerWin(boolean show) {
    	JButton[] jbuttons = new JButton[3];
    	
    	//Did the computer win?
    	if (gameMatrix.isRowEqual(0) == 0) {
            if (show) {
                jbuttons[0] = button1;
                jbuttons[1] = button2;
                jbuttons[2] = button3;
                        
                win(jbuttons, Color.RED, "The Computer Won!");
                    
                compScore++;
            }
            return true;
	    } else if(gameMatrix.isRowEqual(1) == 0) {
            if (show) {
                jbuttons[0] = button4;
                jbuttons[1] = button5;
                jbuttons[2] = button6;
                        
                win(jbuttons, Color.RED, "The Computer Won!");
                        
                compScore++;
            }
			
            return true;
	    } else if(gameMatrix.isRowEqual(2) == 0) {
            if (show) {
                jbuttons[0] = button7;
                jbuttons[1] = button8;
                jbuttons[2] = button9;
                        
                win(jbuttons, Color.RED, "The Computer Won!");
                        
                compScore++;
            }
			
            return true;
	    } else if(gameMatrix.isColumnEqual(0) == 0) {
            if (show) {
                jbuttons[0] = button1;
                jbuttons[1] = button4;
                jbuttons[2] = button7;
                        
                win(jbuttons, Color.RED, "The Computer Won!");
                        
                compScore++;
            }
			
            return true;
	    } else if(gameMatrix.isColumnEqual(1) == 0) {
            if (show) {
                jbuttons[0] = button2;
                jbuttons[1] = button5;
                jbuttons[2] = button8;
                        
                win(jbuttons, Color.RED, "The Computer Won!");
                        
                compScore++;
            }
			
            return true;
	    } else if(gameMatrix.isColumnEqual(2) == 0) {
            if (show) {
                jbuttons[0] = button3;
                jbuttons[1] = button6;
                jbuttons[2] = button9;
                        
                win(jbuttons, Color.RED, "The Computer Won!");
                        
                compScore++;
            }
			
            return true;
        } else if(gameMatrix.isDiagonalEqual1() == 0) {
            if (show) {
                jbuttons[0] = button1;
                jbuttons[1] = button5;
                jbuttons[2] = button9;
                        
                win(jbuttons, Color.RED, "The Computer Won!");
                        
                compScore++;
            }
			
            return true;
	    } else if(gameMatrix.isDiagonalEqual2() == 0) {
            if (show) {
                jbuttons[0] = button3;
                jbuttons[1] = button5;
                jbuttons[2] = button7;
                        
                win(jbuttons, Color.RED, "The Computer Won!");
                
                compScore++;
            }
			
            return true;

	    } else return false;
	}
    
    /**
     * Name: isTie
     * Date: 8/10/2020
     * Functionality: Checks if it is a tie
     * @param show: Do we want to show to the user that it's a tie?
     * @return: True -> Game is a tie
     *          False -> Game is not a tie
     * */
    private boolean isTie(boolean show) {
    	//No empty slots
    	if (!tview1.getText().isEmpty() && !tview2.getText().isEmpty() && !tview3.getText().isEmpty() && !tview4.getText().isEmpty() && !tview5.getText().isEmpty() && !tview6.getText().isEmpty() && !tview7.getText().isEmpty() && !tview8.getText().isEmpty() && !tview9.getText().isEmpty()) {
            if (show) { //Do we want to show the user that it's a tie?
                //Show the user that it's a tie
                JOptionPane.showMessageDialog(this, "It is a tie", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
                        
                //Reset the game
                resetGame(false);
            }
    		
            return true;
	    }
    	return false; 
    }
    
    /**
     * Name: refresh
     * Date: 8/10/2020
     * @return: Refreshes the game grid
     * */
    private void refresh() {    
    	//Loop through the MatrixTextViews
    	for (MatrixTextView matrixTextView : tviews) matrixTextView.setText(gameMatrix.getBoxSymbol(matrixTextView));
	    
        //Display the score	
    	playerScoreLabel.setText(String.valueOf(playerScore));
    	computerScoreLabel.setText(String.valueOf(compScore));
    }
    
    /**
     * Name: setPlayerTurn
     * Date: 8/10/2020
     * @return: Changes which players turn it is
     * */
    private void setPlayerTurn() {
    	if (playerTurn == 1) { // Did the user just play his turn?
            playerTurn = 0;
	    } else if (playerTurn == 0) { //Did the computer just play his turn?
            playerTurn = 1;
	    }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TicTac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTac().setVisible(true);
                
            }
        });
    }
}
