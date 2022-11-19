package sprint_0.app;

import javafx.fxml.FXML;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class SimpleGameController {
    private Square[][] squares;

    @FXML
    private TextField boardSize;

    @FXML
    private RadioButton gameTypeSM,gameTypeBL,bluePlayerTypeHP,bluePlayerTypeCP,redPlayerTypeHP,redPlayerTypeCP,bluePlayerMoveS,bluePlayerMoveO,redPlayerMoveS,redPlayerMoveO;
    
    @FXML
    private BorderPane borderPane;

    @FXML
    private Pane bottomSection;
    
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
    
    public void setBaordSize(ActionEvent e) throws IOException{

        if(gameTypeSM.isSelected()){
            GridPane gridBoard = new GridPane();
        
            int x = Integer.parseInt(boardSize.getText());

            squares = new Square[x][x];
            
            for(int i=0;i<x; i++){
                for(int j=0;j<x; j++){
                    
                    gridBoard.add(squares[i][j] = new Square(i, j), j, i);
                }
            }
            
            borderPane.setCenter(gridBoard);
            Text  turn = new Text();
            turn.setText("Blue Player's Turn");
            turn.setFill(Color.BLUE);
            turn.setFont(Font.font("Verdana",35));

            
            bottomSection.getChildren().add(turn);
        }
        else if(gameTypeBL.isSelected()){
            GUI.setRoot("GeneralGame.fxml");
            GeneralGameController.setBaordSize(e);
        }

        
    }

    public static void turnSwitch(String turn){
        // bottomSection.getChildren()
    }

    private void turnSwitchText(String turn){
        if(turn.equals("R")){
            bottomSection.getChildren();
        }
    }

    public static void gameOver(String turn){
        if(turn.equals("B")){
            System.out.println("Blue Player Wins");
        }
        else if(turn.equals("R")){
            System.out.println("Red Player Wins");
        }
    }
    public static void gameOver(Integer blueScore, Integer redScore){
        if(blueScore > redScore){
            System.out.println("Blue Player Wins with :" + blueScore + " points");
        }
        else if(redScore < blueScore){
            System.out.println("Red Player Wins with :" + redScore + " points");
        }
        else{
            System.out.println("Tie");
        }
    }
}
