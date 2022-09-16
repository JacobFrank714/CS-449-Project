package sprint_0;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import javafx.application.Platform;

import sprint_0.app.Square;

public class spaceID_Test {
	@BeforeClass
	public static void setUp(){
		Platform.startup(()->{});
	}


	// @AfterClass
	// public static void tearDown(){
	// 	Platform.exit();
	// }
	
	@Test
	public void testSquareIDExpected() {
		Square test = new Square(5, 3);
		assertEquals("5,3",test.getId());
	}
	@Test
	public void testSquareIDFail() {
		Square test = new Square(5, 3);	
		assertNotEquals("3,5",test.getId());
		}
}
	