package sprint_0;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import javafx.application.Platform;

import sprint_0.app.Game;

public class GameTest {

    @Test
    public void testTurnSwitch(){
        Game.setTurn("R");
        assertEquals("R",Game.getTurn().getText());
    }
    @Test
    public void testMoveSwitch(){
        Game.setBlueMove("O");
        assertEquals("O",Game.getBlueMove());
    }
    
}
