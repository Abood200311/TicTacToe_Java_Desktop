/**
 * Name: MatrixTextView.java
 * Date: 8/10/2020
 * @author: Abdallah Alqashqish
 * Functionality: Links a button in the UI and specific cell in the Matrix.
 */

import javax.swing.JButton;

public class MatrixTextView {
    //The button in the UI
    protected JButton button;
    protected int xPos;
    protected int yPos;
    
    //The constructor
    MatrixTextView(JButton jButton, int xPosition, int yPosition){
        this.button = jButton;
        this.xPos = xPosition;
        this.yPos = yPosition;
    }
    
    /**
     * Name: setText
     * Date: 12/6/2020
     * Functionality: Sets the text of the button depending on the numbers in the matrix
     * @param player: The string we want to set the button to. The current playing player.
     * @return: Sets the text of the button
     * */
    protected void setText(String player){
        this.button.setText(player);
    }
    
    /**
     * Name: addData
     * Date: 15/6/2020
     * Functionality: Adds the users symbol to the correct place in the matrix
     * @param matrix: The matrix we want to use
     * @param data: The number we want to add to the matrix
     * @return: Save the data to the matrix in the spot of the button
     * */
    protected void addData(Matrix matrix, int data) {
    	matrix.setData(this.xPos, this.yPos, data);
    }
    
    /**
     * Name: getText
     * Date: 8/10/2020
     * Functionality: Gets the text of the button of the class
     * @return: The text of the button
     * */
    protected String getText() {
    	return this.button.getText();
    }
    
}
