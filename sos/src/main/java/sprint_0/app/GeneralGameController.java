package sprint_0.app;

import javafx.fxml.FXML;

import java.io.IOException;

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
    }

    public static void gameOver(Integer bpoints, Integer rpoints){
        if(bpoints > rpoints){
            Game.setWinnerProp("B");
        }
        else if (bpoints < rpoints) {
            Game.setWinnerProp("R");
        }
        else{
            Game.setWinnerProp("T");
        }
    }
}
