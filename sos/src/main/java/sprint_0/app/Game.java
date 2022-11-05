package sprint_0.app;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.geometry.Pos;

public class Game {
    
    public static String redPlayerType = new String("CP");
	public static String bluePlayerType = new String("CP");
	public static String redPlayerMove = new String("S");
	public static String bluePlayerMove = new String("S");
    public static String gameType = new String("SM");
    public static Label turn = new Label("B");
    
    public static Label getTurn(){
        return turn;
    }

    public static String getBlueMove(){
        return bluePlayerMove;
    }

    public static String getRedMove(){
        return redPlayerMove;
    }

    public static String getBlueType(){
        return bluePlayerType;
    }

    public static String getRedType(){
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
                Square.setAlignment(x,Pos.CENTER);

                check(id);

                setTurn("R");
            }
            else if (turn.getText() == "R"){

                Text x= new Text(redPlayerMove);

                x.setFont(Font.font("Verdana",35));
                x.autosize();
                id.getChildren().add(x);
                Square.setAlignment(x,Pos.CENTER);
                setTurn("B");
            }

        }
        // makes that space unreachable so no overlapping moves
        spaces.remove(id);
    }
    private static void check(Square id) {
        Parent board = id.getParent();
        List children = board.getChildrenUnmodifiable();
        Square test = (Square)children.get(0);
        String[] testing = id.getId().split(",");
        System.out.println(Integer.valueOf(id.getId().split(",")[0]) + 1);
        System.out.println(id.getId().split(",")[1] + 1);
        if(){}
    }
    
}
