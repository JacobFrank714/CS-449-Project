package sprint_0.app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.ArrayList;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.geometry.Pos;

public class Game {
    public static String redPlayerType = new String("CP");
	public static String bluePlayerType = new String("CP");
	public static String redPlayerMove = new String("S");
	public static String bluePlayerMove = new String("S");

    public static String gameType = new String("SM");
    
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

    public static void setBlueType(String type){
        bluePlayerType = type;
    }

    public static void setRedType(String type){
        redPlayerType = type;
    }

    public static void setBlueMove(String move){
        bluePlayerMove = move;
    }

    public static void setRedMove(String move){
        redPlayerMove = move;
    }

    public static void setGameType(String type){
        gameType = type;
    }

    public static void setTurn(String newTurn){
        turn.setText(newTurn);
    }

    public static Label turn = new Label("B");

    @FXML
    public static ArrayList<Square> spaces = new ArrayList<Square>();

    public static void makeMove (Square id){
        // Finding if spaces is occupied
        if(spaces.contains(id)){

            if(turn.getText() == "B"){
                
                Text x = new Text(bluePlayerMove);

                x.setFont(Font.font("Verdana",35));
                x.autosize();
                id.getChildren().add(x);
                id.setAlignment(x,Pos.CENTER);
                setTurn("R");
            }
            else if (turn.getText() == "R"){

                Text x= new Text(redPlayerMove);

                x.setFont(Font.font("Verdana",35));
                x.autosize();
                id.getChildren().add(x);
                id.setAlignment(x,Pos.CENTER);
                setTurn("B");
            }

        }
        // makes that space unreachable so no overlapping moves
        spaces.remove(id);
    }
    
}
