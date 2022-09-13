package sprint_0.app;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class Controller {
    
    public Label gameType = new Label("SM");
	public Label redPlayerType = new Label("CP");
	public Label bluePlayerType = new Label("CP");
	public Label redPlayerMove = new Label("S");
	public Label bluePlayerMove = new Label("S");

    @FXML
    private RadioButton gameTypeSM,gameTypeBL,bluePlayerTypeHP,bluePlayerTypeCP,redPlayerTypeHP,redPlayerTypeCP,bluePlayerMoveS,bluePlayerMoveO,redPlayerMoveS,redPlayerMoveO;

    public void changeGameType(ActionEvent e){

        if (gameTypeSM.isSelected()){
            gameType.setText("SM");
        }
        else if (gameTypeBL.isSelected()) {
            gameType.setText("BL");
        }
        System.out.println(gameType.getText());
    }

    public void changeBluePlayerType(ActionEvent e){

        if (bluePlayerTypeHP.isSelected()){
            bluePlayerType.setText("HP");
        }
        else if (bluePlayerTypeCP.isSelected()){
            bluePlayerType.setText("CP");
        }

        System.out.println(bluePlayerType.getText());
    }

    public void changeRedPlayerType(ActionEvent e){
        
        if (redPlayerTypeHP.isSelected()){
            redPlayerType.setText("HP");
        }
        else if (redPlayerTypeCP.isSelected()){
            redPlayerType.setText("CP");
        }

        System.out.println(redPlayerType.getText());
    }

    public void changeBluePlayerMove(ActionEvent e){
        
        if (bluePlayerMoveO.isSelected()){
            bluePlayerMove.setText("O");
        }
        else if (bluePlayerMoveS.isSelected()){
            bluePlayerMove.setText("S");
        }

        System.out.println(bluePlayerMove.getText());
    }

    public void changeRedPlayerMove(ActionEvent e){
        
        if (redPlayerMoveO.isSelected()){
            redPlayerMove.setText("O");
        }
        else if (redPlayerMoveS.isSelected()){
            redPlayerMove.setText("S");
        }

        System.out.println(redPlayerMove.getText());
    }
}
