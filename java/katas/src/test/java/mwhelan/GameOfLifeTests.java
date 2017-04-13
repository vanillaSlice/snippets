package mwhelan;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Mike Lowe
 */
public class GameOfLifeTests {

    private GameOfLife gameOfLife;
    private boolean[][] state;
    private boolean[][] expectedState;

    @Test(expected = IllegalArgumentException.class)
    public void test_constructor_negativeRows() {
        new GameOfLife(-1, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_constructor_negativeColumns() {
        new GameOfLife(3, -1);
    }

    @Test
    public void test_constructor() {
        gameOfLife = new GameOfLife(3, 3);
        state = new boolean[3][3];
        setState(state);
        expectedState = new boolean[3][3];
        stateAssertions(expectedState);
    }

    private void setState(boolean[][] state) {
        for (int row = 0; row < gameOfLife.getRows(); row++) {
            for (int column = 0; column < gameOfLife.getColumns(); column++) {
                GameOfLife.Cell cell = gameOfLife.getCell(row, column);
                boolean isAlive = state[row][column];
                cell.setAlive(isAlive);
            }
        }
    }

    private void stateAssertions(boolean[][] expectedState) {
        for (int row = 0; row < gameOfLife.getRows(); row++) {
            for (int column = 0; column < gameOfLife.getColumns(); column++) {
                GameOfLife.Cell cell = gameOfLife.getCell(row, column);
                boolean expectedAlive = expectedState[row][column];
                assertEquals(expectedAlive, cell.isAlive());
            }
        }
    }

    @Test
    public void test_cellWithFewerThanTwoLiveNeighboursDies() {
        gameOfLife = new GameOfLife(3, 3);
        state = new boolean[3][3];
        state[0][0] = true;
        setState(state);
        gameOfLife.nextGeneration();
        expectedState = new boolean[3][3];
        stateAssertions(expectedState);
    }

    @Test
    public void test_cellWithTwoLiveNeighboursLives() {
        gameOfLife = new GameOfLife(3, 3);
        state = new boolean[3][3];
        state[0][0] = true;
        state[0][1] = true;
        state[1][0] = true;
        setState(state);
        gameOfLife.nextGeneration();
        expectedState = state;
        expectedState[1][1] = true;
        stateAssertions(expectedState);
    }

    @Test
    public void test_cellWithThreeLiveNeighboursLives() {
        gameOfLife = new GameOfLife(3, 3);
        state = new boolean[3][3];
        state[0][0] = true;
        state[0][1] = true;
        state[1][0] = true;
        state[1][1] = true;
        setState(state);
        gameOfLife.nextGeneration();
        expectedState = state;
        stateAssertions(expectedState);
    }

    @Test
    public void test_cellWithMoreThanThreeLiveNeighboursDies() {
        gameOfLife = new GameOfLife(3, 3);
        state = new boolean[3][3];
        state[0][0] = true;
        state[0][1] = true;
        state[0][2] = true;
        state[1][0] = true;
        state[1][1] = true;
        setState(state);
        gameOfLife.nextGeneration();
        expectedState = state;
        expectedState[0][1] = false;
        expectedState[1][1] = false;
        expectedState[1][2] = true;
        stateAssertions(expectedState);
    }

    @Test
    public void test_deadCellWithExactlyThreeLiveNeighboursBecomesLive() {
        gameOfLife = new GameOfLife(3, 3);
        state = new boolean[3][3];
        state[0][0] = true;
        state[0][1] = true;
        state[0][2] = true;
        setState(state);
        gameOfLife.nextGeneration();
        expectedState = state;
        expectedState[0][0] = false;
        expectedState[0][2] = false;
        expectedState[1][1] = true;
        stateAssertions(expectedState);
    }

}