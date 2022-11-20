package sprint_0.app;

import java.io.IOException;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;


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
		Game.makeMove(this);
	}

	public static void drawLine(Square current,Square i,Square j, String direction){
		switch(direction){
			case "vertical":
				
				Line vline1 = new Line((current.getWidth() / 2),0.0f,(current.getWidth()/2),current.getWidth());
				if(Game.getTurn().equals("B")){
					vline1.setStroke(Color.BLUE);
				}
				else if(Game.getTurn().equals("R")){
					vline1.setStroke(Color.RED);
				}
				current.getChildren().add(vline1);
				Line vline2 = new Line((current.getWidth() / 2),0.0f,(current.getWidth()/2),current.getWidth());
				if(Game.getTurn().equals("B")){
					vline2.setStroke(Color.BLUE);
				}
				else if(Game.getTurn().equals("R")){
					vline2.setStroke(Color.RED);
				}
				i.getChildren().add(vline2);
				Line vline3 = new Line((current.getWidth() / 2),0.0f,(current.getWidth()/2),current.getWidth());
				if(Game.getTurn().equals("B")){
					vline3.setStroke(Color.BLUE);
				}
				else if(Game.getTurn().equals("R")){
					vline3.setStroke(Color.RED);
				}
				j.getChildren().add(vline3);
				break;
			case "horizontal":
				Line hline1 = new Line(0.0f,(current.getHeight()/2),current.getWidth(),(current.getHeight()/2));
				if(Game.getTurn().equals("B")){
					hline1.setStroke(Color.BLUE);
				}
				else if(Game.getTurn().equals("R")){
					hline1.setStroke(Color.RED);
				}
				current.getChildren().add(hline1);
				Line hline2 = new Line(0.0f,(current.getHeight()/2),current.getWidth(),(current.getHeight()/2));
				if(Game.getTurn().equals("B")){
					hline2.setStroke(Color.BLUE);
				}
				else if(Game.getTurn().equals("R")){
					hline2.setStroke(Color.RED);
				}
				i.getChildren().add(hline2);
				Line hline3 = new Line(0.0f,(current.getHeight()/2),current.getWidth(),(current.getHeight()/2));
				if(Game.getTurn().equals("B")){
					hline3.setStroke(Color.BLUE);
				}
				else if(Game.getTurn().equals("R")){
					hline3.setStroke(Color.RED);
				}
				j.getChildren().add(hline3);
				break;
			case "fordiag":
				Line fline1 = new Line(current.getWidth(),0.0f,0.0f,current.getHeight());
				if(Game.getTurn().equals("B")){
					fline1.setStroke(Color.BLUE);
				}
				else if(Game.getTurn().equals("R")){
					fline1.setStroke(Color.RED);
				}
				current.getChildren().add(fline1);
				Line fline2 = new Line(current.getWidth(),0.0f,0.0f,current.getHeight());
				if(Game.getTurn().equals("B")){
					fline2.setStroke(Color.BLUE);
				}
				else if(Game.getTurn().equals("R")){
					fline2.setStroke(Color.RED);
				}
				i.getChildren().add(fline2);
				Line fline3 = new Line(current.getWidth(),0.0f,0.0f,current.getHeight());
				if(Game.getTurn().equals("B")){
					fline3.setStroke(Color.BLUE);
				}
				else if(Game.getTurn().equals("R")){
					fline3.setStroke(Color.RED);
				}
				j.getChildren().add(fline3);
				break;
			case "backdiag":
				Line bline1 = new Line(0.0f,0.0f,current.getWidth(),current.getHeight());
				if(Game.getTurn().equals("B")){
					bline1.setStroke(Color.BLUE);
				}
				else if(Game.getTurn().equals("R")){
					bline1.setStroke(Color.RED);
				}
				current.getChildren().add(bline1);
				Line bline2 = new Line(0.0f,0.0f,current.getWidth(),current.getHeight());
				if(Game.getTurn().equals("B")){
					bline2.setStroke(Color.BLUE);
				}
				else if(Game.getTurn().equals("R")){
					bline2.setStroke(Color.RED);
				}
				i.getChildren().add(bline2);
				Line bline3 = new Line(0.0f,0.0f,current.getWidth(),current.getHeight());
				if(Game.getTurn().equals("B")){
					bline3.setStroke(Color.BLUE);
				}
				else if(Game.getTurn().equals("R")){
					bline3.setStroke(Color.RED);
				}
				j.getChildren().add(bline3);
				break;
		}
	}
}
