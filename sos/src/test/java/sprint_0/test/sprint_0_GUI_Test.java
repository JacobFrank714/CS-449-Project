package sprint_0.test;

import static org.junit.Assert.assertSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Assert.*;
import javafx.Platform;

import sprint_0.app.Game;

public class sprint_0_GUI_Test {
	@BeforeAll
	static void initJfxRuntime() {
    	Platform.startup(() -> {});
	}
	@Test
	public void testSquareID() {
		Game test = new Game();
		test.setBlueMove("O");
		assertSame("O",test.getBlueMove());
	}

    
}
