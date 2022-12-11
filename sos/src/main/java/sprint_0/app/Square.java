package sprint_0.app;

import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Square extends StackPane {

	public Square(int x, int y){
		setStyle("-fx-border-color: white; -fx-background-color: lightgrey;");
		setId(String.valueOf(x)+"," +String.valueOf(y));
		this.setPrefSize(2000, 2000);
		this.setOnMouseClicked(e -> {
			try {
				handleMouseClick();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
        Game.spaces.add(this);
	}
	
	private void handleMouseClick() throws IOException {
		
		// Finding if spaces is occupied
		if(Game.spaces.contains(this)){
			
			// makes that space unreachable so no overlapping moves
			Game.spaces.remove(this);
			if(Game.getBlueTurnPropValue()){
				Game.moves.add(this.getId()+" "+Game.bluePlayerMove);
				
				Text x = new Text(Game.bluePlayerMove);

				x.setFont(Font.font("Verdana",35));
				x.autosize();
				this.getChildren().add(x);
				Square.setAlignment(x,Pos.CENTER);

				Game.check(this);

				Game.setBlueTurnPropValue(false);

				if(Game.redPlayerType == "CP"){
					NewGameController.cpu2.makeMove();
				}
			}
			else if (!Game.getBlueTurnPropValue()){
				Game.moves.add(this.getId()+" "+Game.redPlayerMove);

				Text x= new Text(Game.redPlayerMove);

				x.setFont(Font.font("Verdana",35));
				x.autosize();
				this.getChildren().add(x);
				Square.setAlignment(x,Pos.CENTER);

				Game.check(this);

				Game.setBlueTurnPropValue(true);

				if(Game.bluePlayerType == "CP"){
					NewGameController.cpu1.makeMove();
				}
			}

		}
	}

	public static void drawLine(Square current,Square i,Square j, String direction){
		switch(direction){
			case "vertical":
				
				Line vline1 = new Line((current.getWidth() / 2),10.0f,(current.getWidth()/2),(current.getWidth()) - 20);
				if(Game.getBlueTurnPropValue()){
					vline1.setStroke(Color.BLUE);
				}
				else{
					vline1.setStroke(Color.RED);
				}
				current.getChildren().add(vline1);
				Line vline2 = new Line((current.getWidth() / 2),10.0f,(current.getWidth()/2),(current.getWidth()) - 20);
				if(Game.getBlueTurnPropValue()){
					vline2.setStroke(Color.BLUE);
				}
				else{
					vline2.setStroke(Color.RED);
				}
				i.getChildren().add(vline2);
				Line vline3 = new Line((current.getWidth() / 2),10.0f,(current.getWidth()/2),(current.getWidth()) - 20);
				if(Game.getBlueTurnPropValue()){
					vline3.setStroke(Color.BLUE);
				}
				else{
					vline3.setStroke(Color.RED);
				}
				j.getChildren().add(vline3);
				break;
			case "horizontal":
				Line hline1 = new Line(10.0f,(current.getHeight()/2),(current.getWidth() - 20),(current.getHeight()/2));
				if(Game.getBlueTurnPropValue()){
					hline1.setStroke(Color.BLUE);
				}
				else{
					hline1.setStroke(Color.RED);
				}
				current.getChildren().add(hline1);
				Line hline2 = new Line(10.0f,(current.getHeight()/2),(current.getWidth() - 20),(current.getHeight()/2));
				if(Game.getBlueTurnPropValue()){
					hline2.setStroke(Color.BLUE);
				}
				else{
					hline2.setStroke(Color.RED);
				}
				i.getChildren().add(hline2);
				Line hline3 = new Line(10.0f,(current.getHeight()/2),(current.getWidth() - 20),(current.getHeight()/2));
				if(Game.getBlueTurnPropValue()){
					hline3.setStroke(Color.BLUE);
				}
				else{
					hline3.setStroke(Color.RED);
				}
				j.getChildren().add(hline3);
				break;
			case "fordiag":
				Line fline1 = new Line((current.getWidth() - 20),10.0f,10.0f,(current.getHeight() - 20));
				if(Game.getBlueTurnPropValue()){
					fline1.setStroke(Color.BLUE);
				}
				else{
					fline1.setStroke(Color.RED);
				}
				current.getChildren().add(fline1);
				Line fline2 = new Line((current.getWidth() - 20),10.0f,10.0f,(current.getHeight() - 20));
				if(Game.getBlueTurnPropValue()){
					fline2.setStroke(Color.BLUE);
				}
				else{
					fline2.setStroke(Color.RED);
				}
				i.getChildren().add(fline2);
				Line fline3 = new Line((current.getWidth() - 20),10.0f,10.0f,(current.getHeight() - 20));
				if(Game.getBlueTurnPropValue()){
					fline3.setStroke(Color.BLUE);
				}
				else{
					fline3.setStroke(Color.RED);
				}
				j.getChildren().add(fline3);
				break;
			case "backdiag":
				Line bline1 = new Line(10.0f,10.0f,(current.getWidth() - 20),(current.getHeight() - 20));
				if(Game.getBlueTurnPropValue()){
					bline1.setStroke(Color.BLUE);
				}
				else{
					bline1.setStroke(Color.RED);
				}
				current.getChildren().add(bline1);
				Line bline2 = new Line(10.0f,10.0f,(current.getWidth() - 20),(current.getHeight() - 20));
				if(Game.getBlueTurnPropValue()){
					bline2.setStroke(Color.BLUE);
				}
				else{
					bline2.setStroke(Color.RED);
				}
				i.getChildren().add(bline2);
				Line bline3 = new Line(10.0f,10.0f,(current.getWidth() - 20),(current.getHeight() - 20));
				if(Game.getBlueTurnPropValue()){
					bline3.setStroke(Color.BLUE);
				}
				else{
					bline3.setStroke(Color.RED);
				}
				j.getChildren().add(bline3);
				break;
		}
	}
}
