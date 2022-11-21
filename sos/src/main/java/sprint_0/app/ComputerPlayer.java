package sprint_0.app;

import java.util.List;
import java.util.Random;

import javafx.geometry.Bounds;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class ComputerPlayer {

    public Boolean side;
    public String move;

    public void makeMove(){
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

    Square findSquare(){
        List children = Game.spaces.get(0).getParent().getChildrenUnmodifiable();
        List<Square> squares = children;
        Random rand = new Random();

        if(squares.size() == Game.spaces.size()){
            int x = rand.nextInt(Game.spaces.size());
            return Game.spaces.get(x);
        }

        // for(int i = 0;i<=Game.spaces.size();++i){
        //     if(Game.spaces.contains(squares.get(i))){
        //         continue;
        //     }
        //     else{
        //         int j = rand.nextInt(9);
        //         Integer x = Integer.valueOf(squares.get(i).getId().split(",")[0]);
        //         Integer y = Integer.valueOf(squares.get(i).getId().split(",")[1]);
        //         String id = " ";
        //         switch (j) {
        //             case 0: // Upleft
        //                 id = String.valueOf(x - 1)+","+String.valueOf(y - 1);
        //                 break;
                    
        //             case 1: // UP
        //                 id = String.valueOf(x - 1)+","+String.valueOf(y);
        //                 break;

        //             case 2: // UpRight
        //                 id = String.valueOf(x - 1)+","+String.valueOf(y + 1);
        //                 break;
                    
        //             case 3: // Right
        //                 id = String.valueOf(x)+","+String.valueOf(y + 1);
        //                 break;

        //             case 4: // DownRight
        //                 id = String.valueOf(x + 1)+","+String.valueOf(y + 1);
        //                 break;

        //             case 5: // Down
        //                 id = String.valueOf(x + 1)+","+String.valueOf(y);
        //                 break;
                    
        //             case 6: // DownLeft
        //                 id = String.valueOf(x + 1)+","+String.valueOf(y);
        //                 break;
                    
        //             case 7: // Left
        //                 id = String.valueOf(x)+","+String.valueOf(y - 1);
        //                 break;
        //         }
        //         for(int k = 0; k < squares.size(); ++i){
        //             if(squares.get(k).getId().equals(id)){
        //                 return squares.get(k);
        //             }
        //         }
        //     }
        // }
        return Game.spaces.get(0);
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
