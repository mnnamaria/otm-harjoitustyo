

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tictactoe.domain.Player;

/**
 *
 * @author minnahir
 */
public class PlayerTest {
    Player player;
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.player = new Player("X");
    }
    
    @After
    public void tearDown() {
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void getTokenReturnsToken() {
         assertEquals(player.getToken(), "X");
     }
}
