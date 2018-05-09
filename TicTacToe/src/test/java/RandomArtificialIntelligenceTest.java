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
import tictactoe.domain.Board;
import tictactoe.domain.RandomArtificialIntelligence;

/**
 *
 * @author minnahir
 */
public class RandomArtificialIntelligenceTest {
    RandomArtificialIntelligence randomArtificialIntelligence;
    Board board;
    
    
    
    public RandomArtificialIntelligenceTest() {
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
        this.randomArtificialIntelligence = new RandomArtificialIntelligence(board, "O");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test 
    
    public void randomArtificialIntelligenceExtendsPlayerGetToken(){
        assertEquals(randomArtificialIntelligence.getToken(), "O");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
