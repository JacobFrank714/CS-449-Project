package sprint_0.app;

import javafx.fxml.FXML;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class NewGameController {

    @FXML
    private TextField boardSize;

    @FXML
    private RadioButton gameTypeSM,gameTypeBL,bluePlayerTypeHP,bluePlayerTypeCP,redPlayerTypeHP,redPlayerTypeCP,bluePlayerMoveS,bluePlayerMoveO,redPlayerMoveS,redPlayerMoveO;
    
    @FXML
    private BorderPane borderPane;

    @FXML
    private Pane bottomSection;
    
    public void changeGameType(ActionEvent e) throws IOException{
        
        if (gameTypeSM.isSelected()){
            Game.setGameType("SM");
            GUI.setRoot("SimpleGame");
        }
        else if (gameTypeBL.isSelected()) {
            Game.setGameType("BL");
            GUI.setRoot("GeneralGame");
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

    public static void turnSwitch(String turn){
        // bottomSection.getChildren()
    }
}
