package game;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


@ManagedBean
@RequestScoped
public class MyBean implements Serializable {

    private static final ArrayList<ArrayList<Integer>> boardValues =
            new ArrayList<ArrayList<Integer>>( Arrays.asList(
                    new ArrayList<>(Arrays.asList(0,0,0,0)),
                    new ArrayList<>(Arrays.asList(0,0,0,0)),
                    new ArrayList<>(Arrays.asList(0,0,0,0)),
                    new ArrayList<>(Arrays.asList(0,0,0,0))
            ));

    private static Integer score = 0;

    private static boolean start = false;

    private static String msgStart = "";
    private static String msgEnd = "";
    private static String msgScore = "";

    private String username;

    private Integer freeSpots;

    /**
     * Getter for the board
     * @return list of lists
     */
    public ArrayList<ArrayList<Integer>> getListOfValues()
    {
        return boardValues;
    }

    /**
     * Method to move the values up if the start button was clicked.
     * Firstly, all the tiles are moved up while there are empty spots ( 0 values ).
     * Then, if there are equal values on the tiles it makes the sum of those 2.
     */
    public void up() {
        if(start) {
            for (int z = 0; z <= 3; z++) {
                for (int row = 3; row >= 0; row--)
                    for (int col = 3; col >= 0; col--) {

                        int rowPos = row;
                        int colPos = col;
                        while (rowPos != 0 && colPos != 0) {

                            if (boardValues.get(rowPos - 1).get(colPos) == 0) {
                                boardValues.get(rowPos - 1).set(colPos, boardValues.get(rowPos).get(colPos));
                                boardValues.get(rowPos).set(colPos, 0);
                            }

                            rowPos--;
                            colPos--;
                        }

                        while (rowPos != 0) {

                            if (boardValues.get(rowPos - 1).get(0) == 0 && boardValues.get(rowPos).get(0) != 0) {
                                boardValues.get(rowPos - 1).set(colPos, boardValues.get(rowPos).get(0));
                                boardValues.get(rowPos).set(0, 0);
                            }

                            rowPos--;
                        }

                        rowPos = row;
                        colPos = col;
                        while (rowPos != 0 && colPos != 0) {

                            if (boardValues.get(rowPos - 1).get(colPos).equals(boardValues.get(rowPos).get(colPos))) {
                                int sum = boardValues.get(rowPos - 1).get(colPos) + boardValues.get(rowPos).get(colPos);
                                boardValues.get(rowPos - 1).set(colPos, sum);
                                boardValues.get(rowPos).set(colPos, 0);
                                setScore(sum);
                            }
                            rowPos--;
                            colPos--;
                        }

                        while (rowPos != 0) {

                            if (boardValues.get(rowPos - 1).get(0).equals(boardValues.get(rowPos).get(0))) {
                                int sum = boardValues.get(rowPos - 1).get(0) + boardValues.get(rowPos).get(0);
                                boardValues.get(rowPos - 1).set(0, sum);
                                boardValues.get(rowPos).set(0, 0);
                                setScore(sum);
                            }

                            rowPos--;
                        }


                    }
            }
            insertValues();

        }
        else
        {
            msgStart = "Press start, please!";
        }
    }
    /**
     * Method to move the values down if the start button was clicked.
     * Firstly, all the tiles are moved up while there are empty spots ( 0 values ).
     * Then, if there are equal values on the tiles it makes the sum of those 2.
     */
    public void down(){
        if(start) {
            for (int z = 0; z <= 3; z++) {
                for (int row = 0; row <= 3; row++) {
                    for (int col = 0; col <= 3; col++) {
                        int rowPos = row;
                        int colPos = col;

                        while (rowPos != 3 && colPos != 3) {

                            if (boardValues.get(rowPos + 1).get(colPos) == 0) {
                                boardValues.get(rowPos + 1).set(colPos, boardValues.get(rowPos).get(colPos));
                                boardValues.get(rowPos).set(colPos, 0);
                            }
                            rowPos++;
                            colPos++;
                        }

                        while (rowPos != 3) {
                            if (boardValues.get(rowPos + 1).get(3) == 0 && boardValues.get(rowPos).get(3) != 0) {
                                boardValues.get(rowPos + 1).set(colPos, boardValues.get(rowPos).get(3));
                                boardValues.get(rowPos).set(3, 0);
                            }
                            rowPos++;
                        }

                        rowPos = row;
                        colPos = col;

                        while (rowPos != 3 && colPos != 3) {

                            if (boardValues.get(rowPos + 1).get(colPos).equals(boardValues.get(rowPos).get(colPos))) {
                                int sum = boardValues.get(rowPos + 1).get(colPos) + boardValues.get(rowPos).get(colPos);
                                boardValues.get(rowPos + 1).set(colPos, sum);
                                boardValues.get(rowPos).set(colPos, 0);
                                setScore(sum);
                            }
                            rowPos++;
                            colPos++;
                        }

                        while (rowPos != 3) {

                            if (boardValues.get(rowPos + 1).get(3).equals(boardValues.get(rowPos).get(3))) {
                                int sum = boardValues.get(rowPos + 1).get(3) + boardValues.get(rowPos).get(3);
                                boardValues.get(rowPos + 1).set(3, sum);
                                boardValues.get(rowPos).set(3, 0);
                                setScore(sum);
                            }

                            rowPos++;
                        }
                    }
                }
            }
            insertValues();
        }
        else
        {
            msgStart = "Press start, please!";
        }
    }
    /**
     * Method to move the values left if the start button was clicked.
     * Firstly, all the tiles are moved up while there are empty spots ( 0 values ).
     * Then, if there are equal values on the tiles it makes the sum of those 2.
     */
    public void left(){

        if(start) {
            for (int z = 0; z <= 3; z++) {
                for (int row = 0; row <= 3; row++)
                    for (int col = 0; col <= 3; col++) {
                        int rowPos = row;
                        int colPos = col;
                        while (rowPos != 3 && colPos != 3) {

                            if (boardValues.get(rowPos).get(colPos + 1) == 0) {
                                boardValues.get(rowPos).set(colPos + 1, boardValues.get(rowPos).get(colPos));
                                boardValues.get(rowPos).set(colPos, 0);
                            }
                            rowPos++;
                            colPos++;
                        }

                        while (colPos != 3) {
                            if (boardValues.get(3).get(colPos + 1) == 0 && boardValues.get(3).get(colPos) != 0) {
                                boardValues.get(3).set(colPos + 1, boardValues.get(3).get(colPos));
                                boardValues.get(3).set(colPos, 0);

                            }

                            colPos++;
                        }

                        rowPos = row;
                        colPos = col;
                        while (rowPos != 3 && colPos != 3) {


                            if (boardValues.get(rowPos).get(colPos + 1).equals(boardValues.get(rowPos).get(colPos))) {
                                int sum = boardValues.get(rowPos).get(colPos + 1) + boardValues.get(rowPos).get(colPos);
                                boardValues.get(rowPos).set(colPos + 1, sum);
                                boardValues.get(rowPos).set(colPos, 0);
                                setScore(sum);
                            }
                            rowPos++;
                            colPos++;
                        }

                        while (colPos != 3) {
                            if (boardValues.get(3).get(colPos + 1).equals(boardValues.get(3).get(colPos))) {
                                int sum = boardValues.get(3).get(colPos + 1) + boardValues.get(3).get(colPos);
                                boardValues.get(3).set(colPos + 1, sum);
                                boardValues.get(3).set(colPos, 0);
                                setScore(sum);
                            }

                            colPos++;
                        }
                    }
            }
            insertValues();

        }
        else
        {
            msgStart = "Press start, please!";
        }
    }

    /**
     * Method to move the values right if the start button was clicked.
     * Firstly, all the tiles are moved up while there are empty spots ( 0 values ).
     * Then, if there are equal values on the tiles it makes the sum of those 2.
     */
    public void right() {
        if (start) {
            for (int z = 0; z <= 3; z++) {
                for (int row = 3; row >= 0; row--)
                    for (int col = 3; col >= 0; col--) {
                        int rowPos = row;
                        int colPos = col;
                        while (rowPos != 0 && colPos != 0) {

                            if (boardValues.get(rowPos).get(colPos - 1) == 0) {
                                boardValues.get(rowPos).set(colPos - 1, boardValues.get(rowPos).get(colPos));
                                boardValues.get(rowPos).set(colPos, 0);
                            }
                            rowPos--;
                            colPos--;
                        }

                        while (colPos != 0) {
                            if (boardValues.get(0).get(colPos - 1) == 0 && boardValues.get(0).get(colPos) != 0) {
                                boardValues.get(0).set(colPos - 1, boardValues.get(0).get(colPos));
                                boardValues.get(0).set(colPos, 0);
                            }

                            colPos--;
                        }

                        rowPos = row;
                        colPos = col;
                        while (rowPos != 0 && colPos != 0) {


                            if (boardValues.get(rowPos).get(colPos - 1).equals(boardValues.get(rowPos).get(colPos))) {
                                int sum = boardValues.get(rowPos).get(colPos - 1) + boardValues.get(rowPos).get(colPos);
                                boardValues.get(rowPos).set(colPos - 1, sum);
                                boardValues.get(rowPos).set(colPos, 0);
                                setScore(sum);
                            }
                            rowPos--;
                            colPos--;
                        }

                        while (colPos != 0) {
                            if (boardValues.get(0).get(colPos - 1).equals(boardValues.get(0).get(colPos))) {
                                int sum = boardValues.get(0).get(colPos - 1) + boardValues.get(0).get(colPos);
                                boardValues.get(0).set(colPos - 1, sum);
                                boardValues.get(0).set(colPos, 0);
                                setScore(sum);
                            }

                            colPos--;
                        }
                    }
            }
            insertValues();

        }

        else
        {
            msgStart = "Press start, please!";
        }
    }

    /**
     * Method that inserts a value of 2 or 4 randomly in the table if there are free spots in the table.
     */
    public void insertRandom2Or4()
    {
        Random r = new Random();
        int value = 0;
        int posI = r.nextInt(4), posJ = r.nextInt(4);

        while(value == 0 || value == 1) {
            value = r.nextInt(3);
            value = (int) Math.pow(2, value);
        }


        this.freeSpots = this.getFreeSpots();
        while(this.getListOfValues().get(posI).get(posJ) != 0)
        {
            if(freeSpots == 0)
                break;

            posI = r.nextInt(4);
            posJ = r.nextInt(4);

        }

        if(freeSpots != 0) {
            ArrayList<Integer> row = boardValues.get(posI);
            row.set(posJ, value);
            boardValues.set(posI, row);
        }

    }

    public Integer getFreeSpots()
    {
        freeSpots = 0;
        for(int row = 0; row <= 3; row++)
            for(int col = 0; col <= 3; col++)
            {
                if(boardValues.get(row).get(col) == 0)
                    freeSpots++;
            }
        return freeSpots;
    }

    /**
     * Method that inserts a random value (2 or 4) and checks if there are still free spots or available moves.
     */
    public void insertValues()
    {
        insertRandom2Or4();

        if(freeSpots == 0 && endGame()) {
            msgEnd = "End of the game :( ";

            if(username.equals(""))
                msgScore += "Unknown : " + score;
            else
                msgScore += username + " : " + score;
        }
    }

    /**
     * Method that restarts the game.
     * The values on the board will be 0.
     * Start - false - the tiles can not be moved.
     * The messages that appear at the end will be " ".
     */
    public void clearBoard()
    {
        boardValues.set(0, new ArrayList<>(Arrays.asList(0,0,0,0)));
        boardValues.set(1, new ArrayList<>(Arrays.asList(0,0,0,0)));
        boardValues.set(2, new ArrayList<>(Arrays.asList(0,0,0,0)));
        boardValues.set(3, new ArrayList<>(Arrays.asList(0,0,0,0)));

        score = 0;
        start = false;
        msgEnd = "";
        msgScore = "";
    }

    /**
     * Getter for the score
     * @return integer that represents the score
     */
    public Integer getScore()
    {
        return score;
    }

    /**
     * Method that adds a value to the score
     * @param val integer
     */
    public void setScore(Integer val)
    {
        score += val;
    }

    /**
     * Method that prepares the board and messages for the start of the game and inserts a random value of 2 or 4.
     * Board - contains only 0
     * start - true - the user can move the tiles on the table
     * score - 0
     */
    public void startGame()
    {
        clearBoard();
        start = true;
        insertRandom2Or4();
        score = 0;
        msgStart = "";
    }

    /**
     * Getter for the "Press start, please!"
     * @return message
     */
    public String getStartMessage()
    {
        return msgStart;
    }

    /**
     * Getter for the username
     * @return string that contains the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter for the username
     * @param username string that contains the username
     */
    public  void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter for the "End game :( "
     * @return message
     */
    public String getEndMessage() {
        return msgEnd;
    }

    /**
     * Getter for the score message - the username + score
     * @return message
     */
    public String getScoreMessage() {
        return msgScore;
    }

    /**
     * Method that checks if there are any moves possible(if there are 2 equal valuea either on a column or row)
     * @return true - no moves possible; false - otherwise
     */

    public boolean endGame()
    {
        for(int i = 1; i <=3; i++)
        {
            if(boardValues.get(i).get(0).equals(boardValues.get(i).get(1)) ||
                    boardValues.get(i).get(1).equals(boardValues.get(i).get(2)) ||
                    boardValues.get(i).get(2).equals(boardValues.get(i).get(3)))
            {
                return false;
            }
        }

        for(int i = 1; i <=3; i++)
        {
            if(boardValues.get(0).get(i).equals(boardValues.get(1).get(i)) ||
                    boardValues.get(1).get(i).equals(boardValues.get(2).get(i)) ||
                    boardValues.get(2).get(i).equals(boardValues.get(3).get(i)))
            {
                return false;
            }
        }

        return true;
    }

}