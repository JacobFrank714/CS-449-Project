package sprint_0;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.geometry.Bounds;
import sprint_0.app.Square;
import sprint_0.app.Game;
import javafx.application.Platform;
import javafx.collections.ObservableList;

public class move_Test {

    @BeforeClass
	public static void setUp(){
		Platform.startup(()->{});
	}


	@AfterClass
	public static void tearDown(){
		Platform.exit();
	}
    
    @Test
    public void testBlueMoveS() {
        // Makes a test space and gets the coordinate info for that square
        Square test = new Square(5, 3);
        Bounds bounds = test.getBoundsInLocal();
        Bounds sceneCoords = test.localToScene(bounds);
        // At game start turn is default Blue, sets blue move to "S"
        Game.setBlueMove("S");
        // Fires a mouse click event on the test square
        test.fireEvent(new MouseEvent(MouseEvent.MOUSE_CLICKED,
        sceneCoords.getMinX(), sceneCoords.getMinY(), 0, 0, MouseButton.PRIMARY, 1,
        false, false, false, false, true, false, false, true, true, true, null));
        // Gets the text that was put into the test square
        ObservableList<Node> content = test.getChildren();
        Node node = content.get(0);
        String text = ((Text) node).getText();
        // Text in the square should be "S"
        assertEquals("S",text);
    }

    @Test
    public void testRedMoveS() {
        // Makes a test space and gets the coordinate info for that square
        Square test = new Square(5, 3);
        Bounds bounds = test.getBoundsInLocal();
        Bounds sceneCoords = test.localToScene(bounds);
        // Sets the turn to Red and Red's move to S
        Game.setTurn("R");
        Game.setRedMove("S");
        // Fires a mouse click event on the test square
        test.fireEvent(new MouseEvent(MouseEvent.MOUSE_CLICKED,
        sceneCoords.getMinX(), sceneCoords.getMinY(), 0, 0, MouseButton.PRIMARY, 1,
        false, false, false, false, true, false, false, true, true, true, null));
        // Gets the text that was put into the test square
        ObservableList<Node> content = test.getChildren();
        Node node = content.get(0);
        String text = ((Text) node).getText();
        // Text in the square should be "S"
        assertEquals("S",text);
    }

    @Test
    public void testBlueMoveO() {
        // Makes a test space and gets the coordinate info for that square
        Square test = new Square(5, 3);
        Bounds bounds = test.getBoundsInLocal();
        Bounds sceneCoords = test.localToScene(bounds);
        // At game start turn is default Blue, sets blue move to "O"
        Game.setBlueMove("O");
        // Fires a mouse click event on the test square
        test.fireEvent(new MouseEvent(MouseEvent.MOUSE_CLICKED,
        sceneCoords.getMinX(), sceneCoords.getMinY(), 0, 0, MouseButton.PRIMARY, 1,
        false, false, false, false, true, false, false, true, true, true, null));
        // Gets the text that was put into the test square
        ObservableList<Node> content = test.getChildren();
        Node node = content.get(0);
        String text = ((Text) node).getText();
        // Text in the square should be "O"
        assertEquals("O",text);
        
    }

    @Test
    public void testRedMoveO() {
        // Makes a test space and gets the coordinate info for that square
        Square test = new Square(5, 3);
        Bounds bounds = test.getBoundsInLocal();
        Bounds sceneCoords = test.localToScene(bounds);
        // Sets the turn to Red and Red's move to O
        Game.setTurn("R");
        Game.setRedMove("O");
        // Fires a mouse click event on the test square
        test.fireEvent(new MouseEvent(MouseEvent.MOUSE_CLICKED,
        sceneCoords.getMinX(), sceneCoords.getMinY(), 0, 0, MouseButton.PRIMARY, 1,
        false, false, false, false, true, false, false, true, true, true, null));
        // Gets the text that was put into the test square
        ObservableList<Node> content = test.getChildren();
        Node node = content.get(0);
        String text = ((Text) node).getText();
        // Text in the square should be "O"
        assertEquals("O",text);
    }
}
