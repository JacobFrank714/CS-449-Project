package sprint_0;

import static org.junit.Assert.assertSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Assert.*;

import sprint_0.app.Game;
import sprint_0.app.GUI;

public class sprint_0_GUI_Test {
	@Before
	public void setUp(){
		
	}

	@Test
	public void testSquareID() {
		Game test = new Game();
		test.setBlueMove("O");
		assertSame("O",test.getBlueMove());
	}
}
