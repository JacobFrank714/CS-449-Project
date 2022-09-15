package sprint_0.app;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import java.util.ArrayList;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import sprint_0.app.Square;

// import javafx.scene.control.;

public class Controller {

    private Square[][] squares;
    
    private String gameType = new String("SM");


    @FXML
    private RadioButton gameTypeSM,gameTypeBL,bluePlayerTypeHP,bluePlayerTypeCP,redPlayerTypeHP,redPlayerTypeCP,bluePlayerMoveS,bluePlayerMoveO,redPlayerMoveS,redPlayerMoveO;
    @FXML
    private TextField boardSize;
    @FXML
    private BorderPane borderPane;
    
    public void changeGameType(ActionEvent e){
        
        if (gameTypeSM.isSelected()){
            gameType="SM";
        }
        else if (gameTypeBL.isSelected()) {
            gameType = "BL";
        }
    }
    
    public void changeBluePlayerType(ActionEvent e){
        
        if (bluePlayerTypeHP.isSelected()){
            setBlueType("HP");
        }
        else if (bluePlayerTypeCP.isSelected()){
            setBlueType("CP");
        }
    }
    
    public void changeRedPlayerType(ActionEvent e){
        
        if (redPlayerTypeHP.isSelected()){
            setRedType("HP");
        }
        else if (redPlayerTypeCP.isSelected()){
            setRedType("CP");
        }
    }
    
    public void changeBluePlayerMove(ActionEvent e){
        
        if (bluePlayerMoveO.isSelected()){
            bluePlayerMove="O";
        }
        else if (bluePlayerMoveS.isSelected()){
            bluePlayerMove="S";
        }
    }
    
    public void changeRedPlayerMove(ActionEvent e){
        
        if (redPlayerMoveO.isSelected()){
            redPlayerMove="O";
        }
        else if (redPlayerMoveS.isSelected()){
            redPlayerMove="S";
        }
    }
    
    public void setBaordSize(ActionEvent e){

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
    
}
