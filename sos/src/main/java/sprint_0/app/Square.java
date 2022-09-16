package sprint_0.app;

import javafx.scene.layout.StackPane;


public class Square extends StackPane {

	public Square(int x, int y){
		setStyle("-fx-border-color: white; -fx-background-color: lightgrey;");
		setId(String.valueOf(x)+"," +String.valueOf(y));
		this.setOnMouseClicked(e -> handleMouseClick());
        Game.spaces.add(this);
	}
	
	private void handleMouseClick() {
		Game.makeMove(this);
	}
}
