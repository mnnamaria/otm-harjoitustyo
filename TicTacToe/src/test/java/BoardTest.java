/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tictactoe.Board;

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
        this.board = new Board();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void validMoveTooSmallANumber(){
        assertEquals(board.validMove(0),false);
    }
    
    @Test
    public void validMoveTooBigANumber(){
        assertEquals(board.validMove(10),false);   
    }
    
    @Test
    public void validMovePositionAlreadyTaken(){
        board.setToBoard("X", 1);
        assertEquals(board.validMove(1),false);
        
    }
    
    @Test
    public void validMoveTrue(){
        assertEquals(board.validMove(1),true);
        
    }
    
    @Test
    public void threeInARowFirstRow(){
        board.setToBoard("X", 1);
        board.setToBoard("X", 2);
        board.setToBoard("X", 3);
        assertEquals(board.threeInARow("X"),true);
        
    }
    
    @Test
    public void threeInARowSecondRow(){
        board.setToBoard("X", 4);
        board.setToBoard("X", 5);
        board.setToBoard("X", 6);
        assertEquals(board.threeInARow("X"),true);
        
    }
    
    @Test
    public void threeInARowThirdRow(){
        board.setToBoard("X", 7);
        board.setToBoard("X", 8);
        board.setToBoard("X", 9);
        assertEquals(board.threeInARow("X"),true);
    }
    
    @Test
    public void threeInARowFirstColumn(){
        board.setToBoard("X", 1);
        board.setToBoard("X", 4);
        board.setToBoard("X", 7);
        assertEquals(board.threeInARow("X"),true);
    }
    
    @Test
    public void threeInARowSecondColumn(){
        board.setToBoard("X", 2);
        board.setToBoard("X", 5);
        board.setToBoard("X", 8);
        assertEquals(board.threeInARow("X"),true);
    }
    
    @Test
    public void threeInARowThirdColumn(){
        board.setToBoard("X", 3);
        board.setToBoard("X", 6);
        board.setToBoard("X", 9);
        assertEquals(board.threeInARow("X"),true);
    }
    
    @Test
    public void threeInARowDiagonalLeftToRight(){
        board.setToBoard("X", 1);
        board.setToBoard("X", 5);
        board.setToBoard("X", 9);
        assertEquals(board.threeInARow("X"),true);
    }
    
    @Test
    public void threeInARowDiagonalRightToLeft(){
        board.setToBoard("X", 3);
        board.setToBoard("X", 5);
        board.setToBoard("X", 7);
        assertEquals(board.threeInARow("X"),true);
    }
    
    @Test
    public void threeInARowReturnsFalse(){
        assertEquals(board.threeInARow("X"),false);
    }
    
    @Test
    public void gameOverFullBoard(){
        board.setToBoard("X", 1);
        board.setToBoard("O", 2);
        board.setToBoard("X", 3);
        board.setToBoard("O", 4);
        board.setToBoard("X", 5);
        board.setToBoard("O", 7);
        board.setToBoard("X", 6);
        board.setToBoard("O", 9);
        board.setToBoard("X", 8);
        assertEquals(board.gameOver(),true);
    }
    
    @Test
    public void gameOverXWinsTrue(){
        board.setToBoard("X", 1);
        board.setToBoard("O", 2);
        board.setToBoard("X", 3);
        board.setToBoard("O", 4);
        board.setToBoard("X", 5);
        board.setToBoard("O", 6);
        board.setToBoard("X", 7);
        assertEquals(board.gameOver(),true);
    }
    
    @Test
    public void gameOverXWinsWinnerIsX(){
        board.setToBoard("X", 1);
        board.setToBoard("O", 2);
        board.setToBoard("X", 3);
        board.setToBoard("O", 4);
        board.setToBoard("X", 5);
        board.setToBoard("O", 6);
        board.setToBoard("X", 7);
        board.gameOver();
        assertEquals(board.getWinner(),"X");
    }
    
    @Test
    public void gameOverOWinsTrue(){
        board.setToBoard("X", 1);
        board.setToBoard("O", 2);
        board.setToBoard("X", 3);
        board.setToBoard("O", 5);
        board.setToBoard("X", 4);
        board.setToBoard("O", 8);
        assertEquals(board.gameOver(),true);
    }
    
    @Test
    public void gameOverXWinsWinnerIsO(){
        board.setToBoard("X", 1);
        board.setToBoard("O", 2);
        board.setToBoard("X", 3);
        board.setToBoard("O", 5);
        board.setToBoard("X", 4);
        board.setToBoard("O", 8);
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