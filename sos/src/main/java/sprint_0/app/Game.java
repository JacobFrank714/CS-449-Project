package sprint_0.app;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.text.Text;

public class Game {

    static BooleanProperty blueTurnProp = new SimpleBooleanProperty(true);
    static StringProperty winnerProp = new SimpleStringProperty(" ");
    
    public static String redPlayerType = new String("HP");
	public static String bluePlayerType = new String("HP");
	public static String redPlayerMove = new String("S");
	public static String bluePlayerMove = new String("S");
    public static String gameType = new String("SM");
    public static Integer bpoints = 0;
    public static Integer rpoints = 0;
    public static Boolean saveGame = false;
    
    public BooleanProperty getBlueTurnProp() {
        return blueTurnProp;
    }
    
    public static void setBlueTurnPropValue(Boolean blueTurn) {
        blueTurnProp.setValue(blueTurn);
    }
    
    public static boolean getBlueTurnPropValue() {
        return blueTurnProp.getValue();
    }

    public StringProperty getWinnerProp() {
        return winnerProp;
    }

    public static void setWinnerProp(String winner) {
        winnerProp.setValue(winner);
    }

    public static String getWinnerPropValue() {
        return winnerProp.getValue();
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



    @FXML
    public static ArrayList<Square> spaces = new ArrayList<Square>();
    public static ArrayList<String> moves = new ArrayList<String>();

    private static String getDirection(Square n, String direction){
        Integer x = Integer.valueOf(n.getId().split(",")[0]);
        Integer y = Integer.valueOf(n.getId().split(",")[1]);
        String output = "";
        switch(direction){
            case("downRight"):
                output =  String.valueOf(x + 1)+","+String.valueOf(y + 1);
                break;
            case("downLeft"):
                output =  String.valueOf(x + 1)+","+String.valueOf(y - 1);
                break;
            case("upRight"):
                output =  String.valueOf(x - 1)+","+String.valueOf(y + 1);
                break;
            case("upLeft"):
                output =  String.valueOf(x - 1)+","+String.valueOf(y - 1);
                break;
            case("down"):
                output =  String.valueOf(x + 1)+","+String.valueOf(y);
                break;
            case("Right"):
                output =  String.valueOf(x)+","+String.valueOf(y + 1);
                break;
            case("Left"):
                output =  String.valueOf(x)+","+String.valueOf(y - 1);
                break;
            case("up"):
                output =  String.valueOf(x - 1)+","+String.valueOf(y);
                break;
        }
        return output;
    }

    public static void check(Square current) throws IOException {
        List children = current.getParent().getChildrenUnmodifiable();
        List<Square> squares = children;

        for(Square i: squares){

            Text tmp = (Text)current.getChildren().get(0);
            String currentText = tmp.getText();

            if(i.getId().equals(getDirection(current, "downRight"))){
                if(!i.getChildren().isEmpty()){
                    Text k = (Text)i.getChildren().get(0);
                    if(currentText.equals("S")){
                        if(k.getText().equals("O")){
                            for(Square j: squares){
                                if(j.getId().equals(getDirection(i,"downRight"))){
                                    if(!j.getChildren().isEmpty()){
                                        Text n = (Text)j.getChildren().get(0);
                                        if(n.getText().equals("S")){
                                            if(gameType.equals("SM")){
                                                spaces.clear();
                                                SimpleGameController.gameOver(getBlueTurnPropValue(), moves);
                                            }
                                            else if(gameType.equals("GM")){
                                                if(getBlueTurnPropValue()){
                                                    bpoints += 1;
                                                }
                                                else if(getBlueTurnPropValue()){
                                                    rpoints += 1;
                                                }
                                            }
                                            Square.drawLine(current,i,j,"backdiag");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(currentText.equals("O")){
                        if(k.getText().equals("S")){
                            for(Square j: squares){
                                if(j.getId().equals(getDirection(current,"upLeft"))){
                                    if(!j.getChildren().isEmpty()){
                                        Text n = (Text)j.getChildren().get(0);
                                        if(n.getText().equals("S")){
                                            if(gameType.equals("SM")){
                                                spaces.clear();
                                                SimpleGameController.gameOver(getBlueTurnPropValue(), moves);
                                            }
                                            else if(gameType.equals("GM")){
                                                if(getBlueTurnPropValue()){
                                                    bpoints += 1;
                                                }
                                                else if(getBlueTurnPropValue()){
                                                    rpoints += 1;
                                                }
                                            }
                                            Square.drawLine(current,i,j,"backdiag");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else if(i.getId().equals(getDirection(current,"Right"))){
                if(!i.getChildren().isEmpty()){
                    Text text= (Text)i.getChildren().get(0);
                    if(currentText.equals("S")){
                        if(text.getText().equals("O")){
                            for(Square j: squares){
                                if(j.getId().equals(getDirection(i,"Right"))){
                                    if(!j.getChildren().isEmpty()){
                                        Text n = (Text)j.getChildren().get(0);
                                        if(n.getText().equals("S")){
                                            if(gameType.equals("SM")){
                                                spaces.clear();
                                                SimpleGameController.gameOver(getBlueTurnPropValue(), moves);
                                            }
                                            else if(gameType.equals("GM")){
                                                if(getBlueTurnPropValue()){
                                                    bpoints += 1;
                                                }
                                                else if(getBlueTurnPropValue()){
                                                    rpoints += 1;
                                                }
                                            }
                                            Square.drawLine(current,i,j,"horizontal");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(currentText.equals("O")){
                        if(text.getText().equals("S")){
                            for(Square j: squares){
                                if(j.getId().equals(getDirection(current,"Left"))){
                                    if(!j.getChildren().isEmpty()){
                                        Text n = (Text)j.getChildren().get(0);
                                        if(n.getText().equals("S")){
                                            if(gameType.equals("SM")){
                                                spaces.clear();
                                                SimpleGameController.gameOver(getBlueTurnPropValue(), moves);
                                            }
                                            else if(gameType.equals("GM")){
                                                if(getBlueTurnPropValue()){
                                                    bpoints += 1;
                                                }
                                                else if(getBlueTurnPropValue()){
                                                    rpoints += 1;
                                                }
                                            }
                                            Square.drawLine(current,i,j,"horizontal");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else if(i.getId().equals(getDirection(current,"upRight"))){
                if(!i.getChildren().isEmpty()){
                    Text text= (Text)i.getChildren().get(0);
                    if(currentText.equals("S")){
                        if(text.getText().equals("O")){
                            for(Square j: squares){
                                if(j.getId().equals(getDirection(i,"upRight"))){
                                    if(!j.getChildren().isEmpty()){
                                        Text n = (Text)j.getChildren().get(0);
                                        if(n.getText().equals("S")){
                                            if(gameType.equals("SM")){
                                                spaces.clear();
                                                SimpleGameController.gameOver(getBlueTurnPropValue(), moves);
                                            }
                                            else if(gameType.equals("GM")){
                                                if(getBlueTurnPropValue()){
                                                    bpoints += 1;
                                                }
                                                else if(getBlueTurnPropValue()){
                                                    rpoints += 1;
                                                }
                                            }
                                            Square.drawLine(current,i,j,"fordiag");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(currentText.equals("O")){
                        if(text.getText().equals("S")){
                            for(Square j: squares){
                                if(j.getId().equals(getDirection(current,"downLeft"))){
                                    if(!j.getChildren().isEmpty()){
                                        Text n = (Text)j.getChildren().get(0);
                                        if(n.getText().equals("S")){
                                            if(gameType.equals("SM")){
                                                spaces.clear();
                                                SimpleGameController.gameOver(getBlueTurnPropValue(), moves);
                                            }
                                            else if(gameType.equals("GM")){
                                                if(getBlueTurnPropValue()){
                                                    bpoints += 1;
                                                }
                                                else if(getBlueTurnPropValue()){
                                                    rpoints += 1;
                                                }
                                            }
                                            Square.drawLine(current,i,j,"fordiag");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else if(i.getId().equals(getDirection(current,"up"))){
                if(!i.getChildren().isEmpty()){
                    Text text= (Text)i.getChildren().get(0);
                    if(currentText.equals("S")){
                        if(text.getText().equals("O")){
                            for(Square j: squares){
                                if(j.getId().equals(getDirection(i,"up"))){
                                    if(!j.getChildren().isEmpty()){
                                        Text n = (Text)j.getChildren().get(0);
                                        if(n.getText().equals("S")){
                                            if(gameType.equals("SM")){
                                                spaces.clear();
                                                SimpleGameController.gameOver(getBlueTurnPropValue(), moves);
                                            }
                                            else if(gameType.equals("GM")){
                                                if(getBlueTurnPropValue()){
                                                    bpoints += 1;
                                                }
                                                else if(getBlueTurnPropValue()){
                                                    rpoints += 1;
                                                }
                                            }
                                            Square.drawLine(current,i,j,"vertical");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(currentText.equals("O")){
                        if(text.getText().equals("S")){
                            for(Square j: squares){
                                if(j.getId().equals(getDirection(current,"down"))){
                                    if(!j.getChildren().isEmpty()){
                                        Text n = (Text)j.getChildren().get(0);
                                        if(n.getText().equals("S")){
                                            if(gameType.equals("SM")){
                                                spaces.clear();
                                                SimpleGameController.gameOver(getBlueTurnPropValue(), moves);
                                            }
                                            else if(gameType.equals("GM")){
                                                if(getBlueTurnPropValue()){
                                                    bpoints += 1;
                                                }
                                                else if(getBlueTurnPropValue()){
                                                    rpoints += 1;
                                                }
                                            }
                                            Square.drawLine(current,i,j,"vertical");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else if(i.getId().equals(getDirection(current,"upLeft"))){
                if(!i.getChildren().isEmpty()){
                    Text text= (Text)i.getChildren().get(0);
                    if(currentText.equals("S")){
                        if(text.getText().equals("O")){
                            for(Square j: squares){
                                if(j.getId().equals(getDirection(i,"upLeft"))){
                                    if(!j.getChildren().isEmpty()){
                                        Text n = (Text)j.getChildren().get(0);
                                        if(n.getText().equals("S")){
                                            if(gameType.equals("SM")){
                                                spaces.clear();
                                                SimpleGameController.gameOver(getBlueTurnPropValue(), moves);
                                            }
                                            else if(gameType.equals("GM")){
                                                if(getBlueTurnPropValue()){
                                                    bpoints += 1;
                                                }
                                                else if(getBlueTurnPropValue()){
                                                    rpoints += 1;
                                                }
                                            }
                                            Square.drawLine(current,i,j,"backdiag");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(currentText.equals("O")){
                        if(text.getText().equals("S")){
                            for(Square j: squares){
                                if(j.getId().equals(getDirection(current,"downRight"))){
                                    if(!j.getChildren().isEmpty()){
                                        Text n = (Text)j.getChildren().get(0);
                                        if(n.getText().equals("S")){
                                            if(gameType.equals("SM")){
                                                spaces.clear();
                                                SimpleGameController.gameOver(getBlueTurnPropValue(), moves);
                                            }
                                            else if(gameType.equals("GM")){
                                                if(getBlueTurnPropValue()){
                                                    bpoints += 1;
                                                }
                                                else if(getBlueTurnPropValue()){
                                                    rpoints += 1;
                                                }
                                            }
                                            Square.drawLine(current,i,j,"backdiag");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else if(i.getId().equals(getDirection(current,"Left"))){
                if(!i.getChildren().isEmpty()){
                    Text text= (Text)i.getChildren().get(0);
                    if(currentText.equals("S")){
                        if(text.getText().equals("O")){
                            for(Square j: squares){
                                if(j.getId().equals(getDirection(i,"Left"))){
                                    if(!j.getChildren().isEmpty()){
                                        Text n = (Text)j.getChildren().get(0);
                                        if(n.getText().equals("S")){
                                            if(gameType.equals("SM")){
                                                spaces.clear();
                                                SimpleGameController.gameOver(getBlueTurnPropValue(), moves);
                                            }
                                            else if(gameType.equals("GM")){
                                                if(getBlueTurnPropValue()){
                                                    bpoints += 1;
                                                }
                                                else if(getBlueTurnPropValue()){
                                                    rpoints += 1;
                                                }
                                            }
                                            Square.drawLine(current,i,j,"horizontal");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(currentText.equals("O")){
                        if(text.getText().equals("S")){
                            for(Square j: squares){
                                if(j.getId().equals(getDirection(current,"Right"))){
                                    if(!j.getChildren().isEmpty()){
                                        Text n = (Text)j.getChildren().get(0);
                                        if(n.getText().equals("S")){
                                            if(gameType.equals("SM")){
                                                spaces.clear();
                                                SimpleGameController.gameOver(getBlueTurnPropValue(), moves);
                                            }
                                            else if(gameType.equals("GM")){
                                                if(getBlueTurnPropValue()){
                                                    bpoints += 1;
                                                }
                                                else if(getBlueTurnPropValue()){
                                                    rpoints += 1;
                                                }
                                            }
                                            Square.drawLine(current,i,j,"horizontal");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else if(i.getId().equals(getDirection(current,"downLeft"))){
                if(!i.getChildren().isEmpty()){
                    Text text= (Text)i.getChildren().get(0);
                    if(currentText.equals("S")){
                        if(text.getText().equals("O")){
                            for(Square j: squares){
                                if(j.getId().equals(getDirection(i,"downLeft"))){
                                    if(!j.getChildren().isEmpty()){
                                        Text n = (Text)j.getChildren().get(0);
                                        if(n.getText().equals("S")){
                                            if(gameType.equals("SM")){
                                                spaces.clear();
                                                SimpleGameController.gameOver(getBlueTurnPropValue(), moves);
                                            }
                                            else if(gameType.equals("GM")){
                                                if(getBlueTurnPropValue()){
                                                    bpoints += 1;
                                                }
                                                else if(getBlueTurnPropValue()){
                                                    rpoints += 1;
                                                }
                                            }
                                            Square.drawLine(current,i,j,"fordiag");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(currentText.equals("O")){
                        if(text.getText().equals("S")){
                            for(Square j: squares){
                                if(j.getId().equals(getDirection(current,"upRight"))){
                                    if(!j.getChildren().isEmpty()){
                                        Text n = (Text)j.getChildren().get(0);
                                        if(n.getText().equals("S")){
                                            if(gameType.equals("SM")){
                                                spaces.clear();
                                                SimpleGameController.gameOver(getBlueTurnPropValue(), moves);
                                            }
                                            else if(gameType.equals("GM")){
                                                if(getBlueTurnPropValue()){
                                                    bpoints += 1;
                                                }
                                                else if(getBlueTurnPropValue()){
                                                    rpoints += 1;
                                                }
                                            }
                                            Square.drawLine(current,i,j,"fordiag");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else if(i.getId().equals(getDirection(current,"down"))){
                if(!i.getChildren().isEmpty()){
                    Text text= (Text)i.getChildren().get(0);
                    if(currentText.equals("S")){
                        if(text.getText().equals("O")){
                            for(Square j: squares){
                                if(j.getId().equals(getDirection(i,"down"))){
                                    if(!j.getChildren().isEmpty()){
                                        Text n = (Text)j.getChildren().get(0);
                                        if(n.getText().equals("S")){
                                            if(gameType.equals("SM")){
                                                spaces.clear();
                                                SimpleGameController.gameOver(getBlueTurnPropValue(), moves);
                                            }
                                            else if(gameType.equals("GM")){
                                                if(getBlueTurnPropValue()){
                                                    bpoints += 1;
                                                }
                                                else if(getBlueTurnPropValue()){
                                                    rpoints += 1;
                                                }
                                            }
                                            Square.drawLine(current,i,j,"vertical");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(currentText.equals("O")){
                        if(text.getText().equals("S")){
                            for(Square j: squares){
                                if(j.getId().equals(getDirection(current,"up"))){
                                    if(!j.getChildren().isEmpty()){
                                        Text n = (Text)j.getChildren().get(0);
                                        if(n.getText().equals("S")){
                                            if(gameType.equals("SM")){
                                                spaces.clear();
                                                SimpleGameController.gameOver(getBlueTurnPropValue(), moves);
                                            }
                                            else if(gameType.equals("GM")){
                                                if(getBlueTurnPropValue()){
                                                    bpoints += 1;
                                                }
                                                else if(getBlueTurnPropValue()){
                                                    rpoints += 1;
                                                }
                                            }
                                            Square.drawLine(current,i,j,"vertical");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if(gameType.equals("GM")){
            if(spaces.size() == 0){
                GeneralGameController.gameOver(bpoints, rpoints, moves);
            }
        }
    }

    
}
