

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tictactoe.domain.Board;

/**
 *
 * @author minnahir
 */
public class BoardTest {
    Board board;
    
    public BoardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.board = new Board(3,3);
    }
    
    @After
    public void tearDown() {
    }
      
    @Test
    public void threeInARowFirstRow(){
        board.setToBoard("X", 0,0);
        board.setToBoard("X", 1,0);
        board.setToBoard("X", 2,0);
        assertEquals(board.threeInARow("X"),true);
        
    }
    
    @Test
    public void threeInARowSecondRow(){
        board.setToBoard("X", 0,1);
        board.setToBoard("X", 1,1);
        board.setToBoard("X", 2,1);
        assertEquals(board.threeInARow("X"),true);
        
    }
    
    @Test
    public void threeInARowThirdRow(){
        board.setToBoard("X", 0,2);
        board.setToBoard("X", 1,2);
        board.setToBoard("X", 2,2);
        assertEquals(board.threeInARow("X"),true);
    }
    
    @Test
    public void threeInARowFirstColumn(){
        board.setToBoard("X", 0,0);
        board.setToBoard("X", 0,1);
        board.setToBoard("X", 0,2);
        assertEquals(board.threeInARow("X"),true);
    }
    
    @Test
    public void threeInARowSecondColumn(){
        board.setToBoard("X", 0,1);
        board.setToBoard("X", 1,1);
        board.setToBoard("X", 2,1);
        assertEquals(board.threeInARow("X"),true);
    }
    
    @Test
    public void threeInARowThirdColumn(){
        board.setToBoard("X", 2,0);
        board.setToBoard("X", 2,1);
        board.setToBoard("X", 2,2);
        assertEquals(board.threeInARow("X"),true);
    }
    
    @Test
    public void threeInARowDiagonalLeftToRight(){
        board.setToBoard("X", 0,0);
        board.setToBoard("X", 1,1);
        board.setToBoard("X", 2,2);
        assertEquals(board.threeInARow("X"),true);
    }
    
    @Test
    public void threeInARowDiagonalRightToLeft(){
        board.setToBoard("X", 0,2);
        board.setToBoard("X", 1,1);
        board.setToBoard("X", 2,0);
        assertEquals(board.threeInARow("X"),true);
    }
    
    @Test
    public void threeInARowReturnsFalse(){
        assertEquals(board.threeInARow("X"),false);
    }
    
    @Test
    public void gameOverFullBoard(){
        board.setToBoard("X", 0,0);
        board.setToBoard("O", 1,0);
        board.setToBoard("X", 2,0);
        board.setToBoard("O", 0,1);
        board.setToBoard("X", 1,1);
        board.setToBoard("O", 0,2);
        board.setToBoard("X", 2,1);
        board.setToBoard("O", 2,2);
        board.setToBoard("X", 1,2);
        assertEquals(board.gameOver(),true);
    }
    
    @Test
    public void gameOverXWinsTrue(){
        board.setToBoard("X", 0,0);
        board.setToBoard("O", 1,0);
        board.setToBoard("X", 0,1);
        board.setToBoard("O", 1,1);
        board.setToBoard("X", 0,2);
        assertEquals(board.gameOver(),true);
    }
    
    @Test
    public void gameOverXWinsWinnerIsX(){
        board.setToBoard("X", 0,0);
        board.setToBoard("O", 1,0);
        board.setToBoard("X", 0,1);
        board.setToBoard("O", 1,1);
        board.setToBoard("X", 0,2);
        board.gameOver();
        assertEquals(board.getWinner(),"X");
    }
    
    @Test
    public void gameOverOWinsTrue(){
        board.setToBoard("X", 0,0);
        board.setToBoard("O", 1,0);
        board.setToBoard("X", 2,0);
        board.setToBoard("O", 1,1);
        board.setToBoard("X", 0,1);
        board.setToBoard("O", 1,2);
        assertEquals(board.gameOver(),true);
    }
    
    @Test
    public void gameOverXWinsWinnerIsO(){
        board.setToBoard("X", 0,0);
        board.setToBoard("O", 1,0);
        board.setToBoard("X", 2,0);
        board.setToBoard("O", 1,1);
        board.setToBoard("X", 0,1);
        board.setToBoard("O", 1,2);
        board.gameOver();
        assertEquals(board.getWinner(),"O");
    }
    
    @Test
    public void gameNotOverReturnsFalse(){
        assertEquals(board.gameOver(),false);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
