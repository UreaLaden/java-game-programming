package first.game;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {
    Random random = new Random();

    public Player(int x, int y, ID id) {
        super(x, y, id);

        velX=random.nextInt(5)+1;
        velY=random.nextInt(5);
    }

    public void tick() {
        x+=velX;
        y+=velY;
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(x,y,32,32);
    }
}
