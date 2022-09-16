package sprint_0;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import sprint_0.app.Game;

public class spaceID_Test {
	@Before
	public void setUp(){	
	}

	@After
	public void tearDown(){
	}

	@Test
	public void testSquareID() {
		// Game test = new Game();
		Game.setBlueMove("O");
		assertSame("O",Game.getBlueMove());
	}
}
