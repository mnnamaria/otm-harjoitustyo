

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
        this.board = new Board(4,4);
    }
    
    @After
    public void tearDown() {
    }
      
    @Test
    public void fourInARowFirstColumn(){
        board.setToBoard("X", 0,0);
        board.setToBoard("X", 1,0);
        board.setToBoard("X", 2,0);
        board.setToBoard("X", 3,0);
        assertEquals(board.fourInARow("X"),true);
        
    }
    
    @Test
    public void fourInARowSecondColumn(){
        board.setToBoard("X", 0,1);
        board.setToBoard("X", 1,1);
        board.setToBoard("X", 2,1);
        board.setToBoard("X", 3,1);
        assertEquals(board.fourInARow("X"),true);
        
    }
    
    @Test
    public void fourInARowThirdColumn(){
        board.setToBoard("X", 0,2);
        board.setToBoard("X", 1,2);
        board.setToBoard("X", 2,2);
        board.setToBoard("X", 3,2);
        assertEquals(board.fourInARow("X"),true);
    }
    
    @Test
    public void fourInARowFirstRow(){
        board.setToBoard("X", 0,0);
        board.setToBoard("X", 0,1);
        board.setToBoard("X", 0,2);
        board.setToBoard("X", 0,3);
        assertEquals(board.fourInARow("X"),true);
    }
    
    @Test
    public void fourInARowSecondRow(){
        board.setToBoard("X", 1,0);
        board.setToBoard("X", 1,1);
        board.setToBoard("X", 1,2);
        board.setToBoard("X", 1,3);
        assertEquals(board.fourInARow("X"),true);
    }
    
    @Test
    public void fourInARowThirdRow(){
        board.setToBoard("X", 2,0);
        board.setToBoard("X", 2,1);
        board.setToBoard("X", 2,2);
        board.setToBoard("X", 2,3);
        assertEquals(board.fourInARow("X"),true);
    }
    
    @Test
    public void fourInARowDiagonalLeftToRight(){
        board.setToBoard("X", 0,0);
        board.setToBoard("X", 1,1);
        board.setToBoard("X", 2,2);
        board.setToBoard("X", 3,3);
        assertEquals(board.fourInARow("X"),true);
    }
    
    @Test
    public void threeInARowDiagonalRightToLeft(){
        board.setToBoard("X", 0,3);
        board.setToBoard("X", 1,2);
        board.setToBoard("X", 2,1);
        board.setToBoard("X", 3,0);
        assertEquals(board.fourInARow("X"),true);
    }
    
    @Test
    public void threeInARowReturnsFalse(){
        assertEquals(board.fourInARow("X"),false);
    }
    
    @Test
    public void gameOverFullBoard(){
        board.setToBoard("X", 0,0);
        board.setToBoard("O", 1,0);
        board.setToBoard("X", 2,0);
        board.setToBoard("O", 3,0);
        board.setToBoard("X", 0,1);
        board.setToBoard("O", 1,1);
        board.setToBoard("X", 2,1);
        board.setToBoard("O", 3,1);
        board.setToBoard("X", 1,2);
        board.setToBoard("O", 0,2);
        board.setToBoard("X", 3,2);
        board.setToBoard("O", 2,2);
        board.setToBoard("X", 3,3);
        board.setToBoard("O", 0,3);
        board.setToBoard("X", 1,3);
        board.setToBoard("O", 2,3);
        assertEquals(board.gameOver(),true);
    }
    
    @Test
    public void gameOverXWinsReturnsTrue(){
        board.setToBoard("X", 0,0);
        board.setToBoard("O", 1,1);
        board.setToBoard("X", 1,0);
        board.setToBoard("O", 2,2);
        board.setToBoard("X", 2,0);
        board.setToBoard("O", 3,3);
        board.setToBoard("X", 3,0);
        assertEquals(board.gameOver(),true);
    }
    
    @Test
    public void gameOverXWinsWinnerIsX(){
        board.setToBoard("X", 0,0);
        board.setToBoard("O", 1,1);
        board.setToBoard("X", 1,0);
        board.setToBoard("O", 2,2);
        board.setToBoard("X", 2,0);
        board.setToBoard("O", 3,3);
        board.setToBoard("X", 3,0);
        board.gameOver();
        assertEquals(board.getWinner(),"X");
    }
    
    @Test
    public void gameOverOWinsTrue(){
        board.setToBoard("O", 0,0);
        board.setToBoard("X", 1,1);
        board.setToBoard("O", 1,0);
        board.setToBoard("X", 2,2);
        board.setToBoard("O", 2,0);
        board.setToBoard("X", 3,3);
        board.setToBoard("O", 3,0);
        assertEquals(board.gameOver(),true);
    }
    
    @Test
    public void gameOverXWinsWinnerIsO(){
        board.setToBoard("O", 0,0);
        board.setToBoard("X", 1,1);
        board.setToBoard("O", 1,0);
        board.setToBoard("X", 2,2);
        board.setToBoard("O", 2,0);
        board.setToBoard("X", 3,3);
        board.setToBoard("O", 3,0);
        board.gameOver();
        assertEquals(board.getWinner(),"O");
    }
    
    
    @Test
    public void gameNotOverReturnsFalse(){
        assertEquals(board.gameOver(),false);
    }
    
    @Test
    public void getTokensBoardEmpty(){
        assertEquals(board.getTokens(),0);
    }
    
    @Test
    public void getTokensBoardNotEmpty(){
        board.setToBoard("X", 0,0);
        assertEquals(board.getTokens(),1);
    }
    
    @Test
    public void getMessageBoardIsFull(){
        board.setToBoard("X", 0,0);
        board.setToBoard("O", 1,0);
        board.setToBoard("X", 2,0);
        board.setToBoard("O", 3,0);
        board.setToBoard("X", 0,1);
        board.setToBoard("O", 1,1);
        board.setToBoard("X", 2,1);
        board.setToBoard("O", 3,1);
        board.setToBoard("X", 1,2);
        board.setToBoard("O", 0,2);
        board.setToBoard("X", 3,2);
        board.setToBoard("O", 2,2);
        board.setToBoard("X", 3,3);
        board.setToBoard("O", 0,3);
        board.setToBoard("X", 1,3);
        board.setToBoard("O", 2,3);
        board.gameOver();
        assertEquals(board.getMessage(), "Game over, the board is full");
    }
    
    @Test
    public void getMessageWinnerIsX(){
        board.setToBoard("X", 0,0);
        board.setToBoard("X", 1,0);
        board.setToBoard("X", 2,0);
        board.setToBoard("X", 3,0);
        board.gameOver();
        assertEquals(board.getMessage(), "Game over, the winner is X");
    }
    
    @Test
    public void getBoardSizeReturnsBoardSize(){
        assertEquals(board.getBoardSize(),4);
    }
    
    @Test
    public void getTokensInARowReturnstheNumberOfTokensRequiredForAWin(){
        assertEquals(board.getTokensInARow(),4);
    }
    
    @Test 
    public void emptySpotsReturnsAllTheSpotsWhenBoardEmpty(){
        String testi = "";
        for(String paikka: board.emptySpots()){
            testi = testi + "(" + paikka+ ")";
        }
        
        assertEquals(testi, "(0,0)(0,1)(0,2)(0,3)(1,0)(1,1)(1,2)(1,3)(2,0)(2,1)(2,2)(2,3)(3,0)(3,1)(3,2)(3,3)");
    }
    
    @Test 
    public void emptySpotsReturnsEmptyTheSpotsWhenBoardNotTotallyEmpty(){
        board.setToBoard("X", 0,0);
        board.setToBoard("O",1,1);
        String testi = "";
        for(String paikka: board.emptySpots()){
            testi = testi + "(" + paikka+ ")";
        }
        
        assertEquals(testi, "(0,1)(0,2)(0,3)(1,0)(1,2)(1,3)(2,0)(2,1)(2,2)(2,3)(3,0)(3,1)(3,2)(3,3)");
    }
    
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
