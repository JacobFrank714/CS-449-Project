package sprint_0.app;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class Controller {

    

    private Square[][] squares;

    @FXML
    private TextField boardSize;

    @FXML
    private RadioButton gameTypeSM,gameTypeBL,bluePlayerTypeHP,bluePlayerTypeCP,redPlayerTypeHP,redPlayerTypeCP,bluePlayerMoveS,bluePlayerMoveO,redPlayerMoveS,redPlayerMoveO;
    
    @FXML
    private BorderPane borderPane;
    
    public void changeGameType(ActionEvent e){
        
        if (gameTypeSM.isSelected()){
            Game.setGameType("SM");
        }
        else if (gameTypeBL.isSelected()) {
            Game.setGameType("BL");
        }
    }
    
    public void changeBluePlayerType(ActionEvent e){
        
        if (bluePlayerTypeHP.isSelected()){
            Game.setBlueType("HP");
        }
        else if (bluePlayerTypeCP.isSelected()){
            Game.setBlueType("CP");
        }
    }
    
    public void changeRedPlayerType(ActionEvent e){
        
        if (redPlayerTypeHP.isSelected()){
            Game.setRedType("HP");
        }
        else if (redPlayerTypeCP.isSelected()){
            Game.setRedType("CP");
        }
    }
    
    public void changeBluePlayerMove(ActionEvent e){
        
        if (bluePlayerMoveO.isSelected()){
            Game.setBlueMove("O");
        }
        else if (bluePlayerMoveS.isSelected()){
            Game.setBlueMove("S");
        }
    }
    
    public void changeRedPlayerMove(ActionEvent e){
        
        if (redPlayerMoveO.isSelected()){
            Game.setRedMove("O");
        }
        else if (redPlayerMoveS.isSelected()){
            Game.setRedMove("S");
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
