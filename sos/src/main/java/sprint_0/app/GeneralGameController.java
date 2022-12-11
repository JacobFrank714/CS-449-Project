package sprint_0.app;

import javafx.fxml.FXML;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class GeneralGameController extends NewGameController {
    private Square[][] squares;

    @FXML
    private TextField boardSize;
    
    @FXML
    private BorderPane borderPane;

    @FXML
    private Pane bottomSection;
    
    public void setBaordSize(ActionEvent e) throws IOException{

            GridPane gridBoard = new GridPane();
        
            int x = Integer.parseInt(boardSize.getText());

            squares = new Square[x][x];
            
            for(int i=0;i<x; i++){
                for(int j=0;j<x; j++){
                    
                    gridBoard.add(squares[i][j] = new Square(i, j), j, i);
                }
            }
            borderPane.setCenter(gridBoard);
            Game.setWinnerProp(" ");
    }

    public static void gameOver(Integer bpoints, Integer rpoints, ArrayList<String> moves){
        if(Game.bpoints > Game.rpoints){
            Game.setWinnerProp("B");
            if(Game.saveGame){
                saveGame(moves);
            }
        }
        else if (Game.bpoints < Game.rpoints) {
            Game.setWinnerProp("R");
            if(Game.saveGame){
                saveGame(moves);
            }
        }
        else{
            Game.setWinnerProp("T");
            if(Game.saveGame){
                saveGame(moves);
            }
        }
        Game.moves.clear();
        Game.bpoints = 0;
        Game.rpoints = 0;
    }
}
