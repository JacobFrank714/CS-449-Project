package sprint_0.app;

import java.util.Random;

import javafx.geometry.Bounds;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class ComputerPlayer {

    public Boolean side;
    public String move;

    public void makeMove(){
        try{
            Square choice = findSquare();
            Bounds bounds = choice.getBoundsInLocal();
            Bounds sceneCoords = choice.localToScene(bounds);
            chooseMove();

            if(!side)
                Game.setRedMove(move);        
            else if(side)
                Game.setBlueMove(move);

            choice.fireEvent(new MouseEvent(MouseEvent.MOUSE_CLICKED,
            sceneCoords.getMinX(), sceneCoords.getMinY(), 0, 0, MouseButton.PRIMARY, 1,
            false, false, false, false, true, false, false, true, true, true, null));
        }
        catch(Exception e){}

    }

    Square findSquare(){
        try {
            return Game.spaces.get(0);
        }catch(Exception e){
            return null;
        }
    }

    public void setSide(Boolean Side) {
        this.side = Side;
    }

    public String getMove() {
        return this.move;
    }

    void chooseMove() {
        Random rand = new Random();
        int x = rand.nextInt(2);
        if(x == 0)
            this.move = "S";
        else if(x == 1)
            this.move = "O";
    }
    
}
