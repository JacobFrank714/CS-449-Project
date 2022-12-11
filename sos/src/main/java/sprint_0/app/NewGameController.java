package sprint_0.app;

import javafx.fxml.FXML;

import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
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

    @FXML
    private Label PlayerTurnText;

    @FXML
    protected Text WinText;

    @FXML
    protected CheckBox saveGame;

    public static ComputerPlayer cpu1 = new ComputerPlayer();
    public static ComputerPlayer cpu2 = new ComputerPlayer();
    
    Game content = new Game();

    public void toggleSaveGame(ActionEvent e) throws IOException{
        if(saveGame.isSelected()){
            content.saveGame = true;
        }
        else{
            content.saveGame = false;
        }
    }
    
    public void changeGameType(ActionEvent e) throws IOException{
        
        if (gameTypeSM.isSelected()){
            Game.setGameType("SM");
            GUI.setRoot("SimpleGame");
        }
        else if (gameTypeBL.isSelected()) {
            Game.setGameType("GM");
            GUI.setRoot("GeneralGame");
        }
    }
    
    public void changeBluePlayerType(ActionEvent e){
        
        if (bluePlayerTypeHP.isSelected()){
            Game.setBlueType("HP");
        }
        else if (bluePlayerTypeCP.isSelected()){
            Game.setBlueType("CP");
            cpu1.setSide(true);
        }
    }
    
    public void changeRedPlayerType(ActionEvent e){
        
        if (redPlayerTypeHP.isSelected()){
            Game.setRedType("HP");
        }
        else if (redPlayerTypeCP.isSelected()){
            Game.setRedType("CP");
            cpu2.setSide(false);
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

    static public void saveGame(ArrayList<String> moves){
        createFile();
        writeFile(moves);
    }

    public static void createFile(){
        try {
            File myObj = new File("LastGame.txt");
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println("File already exists.");
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    public static void writeFile(ArrayList<String> moves){
        try {
            FileWriter myWriter = new FileWriter("LastGame.txt");
            for(int i=0; i < moves.size();++i){
                myWriter.write("Move "+i+": "+moves.get(i));
                myWriter.write("\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    @FXML
    void initialize(){
        PlayerTurnText.textProperty().bind(Bindings.createStringBinding(() -> {
            String s = " ";
            if (Game.getBlueTurnPropValue())
                s = "Blue Player's Turn";
            else
                s = "Red Player's Turn";
            return s;
        }, content.getBlueTurnProp()));
        WinText.textProperty().bind(Bindings.createStringBinding(() -> {
            String s = " ";
            if (Game.getWinnerPropValue().equals("B"))
                s = "Blue Wins";
            else if (Game.getWinnerPropValue().equals("R"))
                s = "Red Wins";
            else if (Game.getWinnerPropValue().equals("T"))
                s = "Tie";
            else
                s = " ";
            return s;
        }, content.getBlueTurnProp()));
    }
}
