package sprint_0.app;

import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import java.util.ArrayList;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.scene.text.Text;
import sprint_0.app.Controller;



public class Square extends StackPane {

    
	private String redPlayerType = new String("CP");
	private String bluePlayerType = new String("CP");
	private String redPlayerMove = new String("S");
	private String bluePlayerMove = new String("S");
    
    public Label getTurn(){
        return turn;
    }

    public String getBlueMove(){
        return bluePlayerMove;
    }

    public String getRedMove(){
        return redPlayerMove;
    }

    public String getBlueType(){
        return bluePlayerType;
    }

    public String getRedType(){
        return redPlayerType;
    }

    public void setBlueType(String type){
        bluePlayerType = type;
    }

    public void setRedType(String type){
        redPlayerType = type;
    }

    public void setBlueMove(String move){
        bluePlayerType = move;
    }

    public void setRedMove(String move){
        redPlayerType = move;
    }

    public Label turn = new Label("B");
    
    @FXML
    private ArrayList<Square> spaces = new ArrayList<Square>();

	public Square(int x, int y){
		setStyle("-fx-border-color: white; -fx-background-color: lightgrey;");
		setId(String.valueOf(x)+"_" +String.valueOf(y));
		this.setPrefSize(2000, 2000);
		this.setOnMouseClicked(e -> handleMouseClick());
	}
	
	private void handleMouseClick() {
		makeMove(this);
	}
    
    public void makeMove (Square id){
        // Finding if spaces is occupied
        if(spaces.contains(id)){

            if(turn.getText() == "B"){
                
                Text move = new Text(bluePlayerMove);

                move.setFont(Font.font("Verdana",35));
                move.autosize();
                id.getChildren().add(move);
                id.setAlignment(move,Pos.CENTER);
                turn.setText("R");
            }
            else if (turn.getText() == "R"){

                Text move = new Text(redPlayerMove);

                move.setFont(Font.font("Verdana",35));
                move.autosize();
                id.getChildren().add(move);
                id.setAlignment(move,Pos.CENTER);
                turn.setText("B");
            }

        }
        // makes that space unreachable so no overlapping moves
        spaces.remove(id);
    }
}
