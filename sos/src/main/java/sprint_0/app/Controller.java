package sprint_0.app;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;

public class Controller {

    private Square[][] squares;
    
    public Label gameType = new Label("SM");
	public Label redPlayerType = new Label("CP");
	public Label bluePlayerType = new Label("CP");
	public Label redPlayerMove = new Label("S");
	public Label bluePlayerMove = new Label("S");

    @FXML
    private RadioButton gameTypeSM,gameTypeBL,bluePlayerTypeHP,bluePlayerTypeCP,redPlayerTypeHP,redPlayerTypeCP,bluePlayerMoveS,bluePlayerMoveO,redPlayerMoveS,redPlayerMoveO;
    
    @FXML
    private TextField boardSize;
    @FXML
    private BorderPane borderPane;
    
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
    
    public void setBaordSize(ActionEvent e){

        GridPane gridBoard = new GridPane();
        
        int x = Integer.parseInt(boardSize.getText());

        squares = new Square[x][x];
        
        for(int i=0;i<x; i++){
            for(int j=0;j<x; j++){
                gridBoard.add(squares[i][j] = new Square(), j, i);
            }
        }
        
        borderPane.setCenter(gridBoard);
    }
    
    public class Square extends Pane {
        public Square() {
            setStyle("-fx-border-color: white; -fx-background-color: lightgrey;");
			this.setPrefSize(2000, 2000);
			this.setOnMouseClicked(e -> handleMouseClick());
		}
        
		private void handleMouseClick() {
            System.out.println("click");
		}

	}

    public class makeMove {
	}
}
