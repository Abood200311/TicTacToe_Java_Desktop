/**
 * Name: Matrix.java
 * Date: 8/10/2020
 * @author: Abdallah Alqashqish
 * Functionality: The 2D array, Matrix, that will control the game play.
 */

class Matrix {

    //Declare class variables
    private int rows;
    private int columns;
    int [][] matrix;

    //The constructor
    Matrix(int numRows, int numColumns) {
        this.rows = numRows;
        this.columns = numColumns;
        this.matrix = new int[rows][columns];
        this.setMatrixData();
    }

    /**
     * Name: setMatrixData
     * Date: 8/10/2020
     * Functionality: Sets the data in the matrix when its empty to 4
     * @return: Sets all the slots in the matrix to 4
     * */
    void setMatrixData() {
    	//Loop through the rows
        for(int row=0; row<this.rows; row++) {
        	//Loop through the columns
            for(int col=0; col<this.columns; col++) {
                //Set the slot to 4
            	matrix[row][col] = 4;
            }
        }
    }

    /**
     * Name: setData
     * Date: 8/10/2020
     * Functionality: Sets a specific slot in the matrix to 0 or 1, depending on user
     * @param rowIndex: The row index of the grid
     * @param columnIndex: The index of the column of the grid
     * @param data: What to save to the cell
     * @return: Sets the slot to the data
     * */
    void setData(int rowIndex, int columnIndex, int data) {
        matrix[rowIndex][columnIndex] = data;
    }

    /**
     * Name: getBoxSymbol
     * Date: 8/10/2020
     * Functionality: Gets the symbol for the button
     * @param Tview: The MatrixTextView of the button
     * @return: X -> if 1 is in the cell
     *          O -> if 0 is in the cell
     *          "" -> if 4 is in the cell
     * */
    String getBoxSymbol(MatrixTextView Tview){
        int boxNum = matrix[Tview.xPos][Tview.yPos];
        String letter;
        switch(boxNum){
            case 1: //Is it the user?
                letter = "X";
                break;
            case 0: //Is it the computer?
                letter = "O";
                break;
            default: //Must be a 4 and so empty
                letter = "";
                break;
        }
        return letter;
    }

    /**
     * Name: isRowEqual
     * Date: 8/10/2020
     * Functionality: Checks if there is a win in a specific row
     * @param rowIndex: The index of the row
     * @return: 1 -> If the user won
     *          0 -> If the computer won
     *          4 -> If no one 
     * */
    int isRowEqual(int rowIndex) {
        int numWon = 4;
        int sumOfData = 0;
        //Loop through the columns of the specific row
        for(int i=0; i<this.columns; i++) {
            //Add up the contents of the row
            sumOfData += matrix[rowIndex][i];
        }
        //Did the user win?
        if (sumOfData == 3) {
            numWon = 1;
        }
        //Did the computer win?
        else if(sumOfData == 0) {
            numWon = 0;
        }
        return numWon;
    }

    /**
     * Name: isColumnEqual
     * Date: 8/10/2020
     * Functionality: Checks to see if there is a win in a specific column
     * @param columnIndex: The index of the column
     * @return: 1 -> if the user won
     *          0 -> if the computer won
     *          4 -> if no one won
     * */
    int isColumnEqual(int columnIndex) {
        int numWon = 4;
        int sumOfData = 0;
        //Loop through the the rows of the column
        for(int i=0; i<this.rows; i++) {
            //Add up the contents of the column
            sumOfData += matrix[i][columnIndex];
        }
        //Did the user win?
        if (sumOfData == 3)         numWon = 1;
        
        //Did the computer win?
        else if(sumOfData == 0)     numWon = 0;
        
        return numWon;
    }

    /**
     * Name: isDiagonalEqual1
     * Date: 8/10/2020
     * Functionality: Checks if there is a win diagonally, from top left to bottom right
     * @return: 1 -> if the user won
     *          0 -> if the computer won
     *          4 -> if no one won
     * */
    int isDiagonalEqual1() {
        int numWon = 4;
        
        //Did the user win?
        if (matrix[0][0] == 1 && matrix[1][1] == 1 && matrix[2][2] == 1)        numWon = 1;
        
        //Did the computer win?
        else if(matrix[0][0] == 0 && matrix[1][1] == 0 && matrix[2][2] == 0)    numWon = 0;
        
        return numWon;
    }

    /**
     * Name: isDiagonalEqual2
     * Date: 8/10/2020
     * Functionality: Checks if there is a win diagonally, from top right to bottom left
     * @return: 1 -> if the user won
     *          0 -> if the computer won
     *          4 -> if no one won
     * */
    int isDiagonalEqual2() {
        int numWon = 4;
        
        //Did the user win?
        if (matrix[0][2] == 1 && matrix[1][1] == 1 && matrix[2][0] == 1)        numWon = 1;
        
        //Did the computer win?
        else if(matrix[0][2] == 0 && matrix[1][1] == 0 && matrix[2][0] == 0)    numWon = 0;
        
        return numWon;
    }
}
