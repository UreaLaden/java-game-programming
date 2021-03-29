package first.game;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {
    Random random = new Random();

    public Player(int x, int y, ID id) {
        super(x, y, id);

    }

    public void tick() {
        x+=velX;
        y+=velY;
    }

    public void render(Graphics graphics) {
        if(id == ID.Player)graphics.setColor(Color.WHITE);
        if(id == ID.Player2)graphics.setColor(Color.green);
        graphics.fillRect(x,y,32,32);
    }
}
