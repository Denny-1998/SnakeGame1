import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.concurrent.ThreadLocalRandom;

public class Food {

    Position pos;

    GraphicsContext gc;
    Board b;



    public Food(GraphicsContext gc, Board b){
        if(pos != null) {
            delete();
        }

        this.gc = gc;
        this.b = b;

        int randomX = ThreadLocalRandom.current().nextInt(1,  b.getTiles());
        int randomY = ThreadLocalRandom.current().nextInt(1,  b.getTiles());
        pos = new Position(randomX, randomY);



        gc.setFill(Color.RED);
        gc.fillOval(pos.getX() * b.getTilesize(), pos.getY() * b.getTilesize(), b.getTilesize(), b.getTilesize());

    }




    public Position getPos(){
        return this.pos;
    }





    public void delete(){

        Square currentPos = b.getSquares(pos.getX(), pos.getY());

        //gc.setFill(Color.PINK); //for debugging
        gc.setFill(currentPos.getColor());
        gc.fillRect(pos.getX() * b.getTilesize(), pos.getY() * b.getTilesize(), b.getTilesize(), b.getTilesize());
    }

}
