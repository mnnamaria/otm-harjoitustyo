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
import tictactoe.domain.Square;

/**
 *
 * @author minnahir
 */
public class SquareTest {
    Square square;
    
    public SquareTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.square = new Square("test");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    public void getContents() {
        assertEquals(square.getContents(), "test");
    }
    
    @Test
    public void setContents() {
        this.square.setContents("testing");
        assertEquals(square.getContents(), "testing");
    }
    
}
