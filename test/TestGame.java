import game.MyBean;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestGame {
    private static final ArrayList<ArrayList<Integer>> boardValues =
            new ArrayList<ArrayList<Integer>>(Arrays.asList(
                    new ArrayList<>(Arrays.asList(0, 0, 0, 0)),
                    new ArrayList<>(Arrays.asList(0, 0, 0, 0)),
                    new ArrayList<>(Arrays.asList(0, 0, 0, 0)),
                    new ArrayList<>(Arrays.asList(0, 0, 0, 0))
            ));
    private MyBean bean;

    @Before
    public void setUp() {
        bean = new MyBean();
    }

    @Test
    public void testUp() {
        int free, notFree = 0;
        int row, col, rowPos = 0, colPos = 0, rowPosUp = 0, colPosUp = 0;
        bean.startGame();
        free = bean.getFreeSpots();
        Assert.assertEquals(free, 15);

        for (row = 0; row <= 3; row++)
            for (col = 0; col <= 3; col++)
                if (bean.getListOfValues().get(row).get(col) != 0) {
                    rowPos = row;
                    colPos = col;
                }

        bean.up();

        for (row = 0; row <= 3; row++)
            for (col = 0; col <= 3; col++)
                if (bean.getListOfValues().get(row).get(col) != 0) {
                    rowPosUp = row;
                    colPosUp = col;
                }

        if (rowPos == rowPosUp && colPos == colPosUp) { // on up -> sum of the 2 tiles
            notFree = 1;
            Assert.assertEquals(notFree, 1);
        } else {
            notFree = 2;
            Assert.assertEquals(notFree, 2);
        }


        free = bean.getFreeSpots();
        Assert.assertEquals(free, 14);

    }

    @Test
    public void testDown() {
        int free, notFree = 0;
        int row, col, rowPos = 0, colPos = 0, rowPosDown = 0, colPosDown = 0;

        bean.startGame();
        free = bean.getFreeSpots();
        Assert.assertEquals(free, 15);

        for (row = 0; row <= 3; row++)
            for (col = 0; col <= 3; col++)
                if (bean.getListOfValues().get(row).get(col) != 0) {
                    rowPos = row;
                    colPos = col;
                }


        bean.down();

        for (row = 0; row <= 3; row++)
            for (col = 0; col <= 3; col++)
                if (bean.getListOfValues().get(row).get(col) != 0) {
                    rowPosDown = row;
                    colPosDown = col;
                }

        if (rowPos == rowPosDown && colPos == colPosDown) { // on up -> sum of the 2 tiles
            notFree = 1;
            Assert.assertEquals(notFree, 1);
        } else {
            notFree = 2;
            Assert.assertEquals(notFree, 2);
        }


        free = bean.getFreeSpots();
        Assert.assertEquals(free, 14);
    }

    @Test
    public void testLeft() {
        int free, notFree = 0;
        int row, col, rowPos = 0, colPos = 0, rowPosLeft = 0, colPosLeft = 0;
        bean.startGame();

        free = bean.getFreeSpots();
        Assert.assertEquals(free, 15);

        for (row = 0; row <= 3; row++)
            for (col = 0; col <= 3; col++)
                if (bean.getListOfValues().get(row).get(col) != 0) {
                    rowPos = row;
                    colPos = col;
                }


        bean.left();

        for (row = 0; row <= 3; row++)
            for (col = 0; col <= 3; col++)
                if (bean.getListOfValues().get(row).get(col) != 0) {
                    rowPosLeft = row;
                    colPosLeft = col;
                }

        if (rowPos == rowPosLeft && colPos == colPosLeft) { // on up -> sum of the 2 tiles
            notFree = 1;
            Assert.assertEquals(notFree, 1);
        } else {
            notFree = 2;
            Assert.assertEquals(notFree, 2);
        }

        free = bean.getFreeSpots();
        Assert.assertEquals(free, 14);
    }

    @Test
    public void testRight() {
        int free, notFree = 0;
        int row, col, rowPos = 0, colPos = 0, rowPosRight = 0, colPosRight = 0;
        bean.startGame();

        free = bean.getFreeSpots();
        Assert.assertEquals(free, 15);

        for (row = 0; row <= 3; row++)
            for (col = 0; col <= 3; col++)
                if (bean.getListOfValues().get(row).get(col) != 0) {
                    rowPos = row;
                    colPos = col;
                }


        bean.left();

        for (row = 0; row <= 3; row++)
            for (col = 0; col <= 3; col++)
                if (bean.getListOfValues().get(row).get(col) != 0) {
                    rowPosRight = row;
                    colPosRight = col;
                }

        if (rowPos == rowPosRight && colPos == colPosRight) { // on up -> sum of the 2 tiles
            notFree = 1;
            Assert.assertEquals(notFree, 1);
        } else {
            notFree = 2;
            Assert.assertEquals(notFree, 2);
        }

        free = bean.getFreeSpots();
        Assert.assertEquals(free, 14);
    }

    @Test
    public void testGetters()
    {
        bean.startGame();
        String msg = bean.getStartMessage();
        Assert.assertEquals("", msg);

        int score = bean.getScore();
        Assert.assertEquals(0, score);

        bean.setUsername("abc");
        String username = this.bean.getUsername();
        Assert.assertEquals("abc", username);
    }

}

