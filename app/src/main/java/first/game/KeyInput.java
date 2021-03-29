package first.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    private boolean up, down,left,right;
    private boolean direction;
    private int speed = 3;
    private HashMap<Integer,Boolean> keys = new HashMap<>();

    public void Update(){
        for(GameObject tempObj: handler.object){
            if(!keys.isEmpty()){

                if(keys.containsValue(true)){
                    if(tempObj.getId()== ID.Player){

                        // key events for player 1
                        processPlayerOneInput(tempObj);
                    }
                    if(tempObj.getId()== ID.Player2){
                        // key events for player 2

                        processPlayerTwoInput(tempObj);
                    }
                }//TODO: RELEASING ANY KEY STARTS AN ENDLESS LOOP. CONSIDER IMPLEMENTING A TIMER
                if(keys.containsValue(false)){
                    if(tempObj.getId()== ID.Player){
                        // key events for player 1
                        playerOneRelease(tempObj);
                    }
                    if(tempObj.getId()== ID.Player2){
                        // key events for player 2
                        playerTwoRelease(0,tempObj);
                    }
                }
            }
        }
    }
    public KeyInput(Handler handler){
        this.handler = handler;
    }

    public void keyPressed(KeyEvent event){
        int key = event.getKeyCode();
        keys.put(key,true);
    }

    public void keyReleased(KeyEvent event){
        int key = event.getKeyCode();
        keys.put(key,false);
    }

    private void processPlayerOneInput(GameObject tempObj) {
        //key events for player 1
        up = keys.get(KeyEvent.VK_W)!=null && keys.get(KeyEvent.VK_W);
        down = keys.get(KeyEvent.VK_S) != null && keys.get(KeyEvent.VK_S);
        left = keys.get(KeyEvent.VK_A) != null && keys.get(KeyEvent.VK_A);
        right = keys.get(KeyEvent.VK_D) != null && keys.get(KeyEvent.VK_D);
        if(up){
            tempObj.setVelY(-speed);
        }
        if(down){
            tempObj.setVelY(speed);
        }
        if(right){
            tempObj.setVelX(speed);
        }
        if(left){
            tempObj.setVelX(-speed);
        }
    }

    private void processPlayerTwoInput(GameObject tempObj) {
        up = keys.get(KeyEvent.VK_UP) != null && keys.get(KeyEvent.VK_UP);
        down = keys.get(KeyEvent.VK_DOWN) != null && keys.get(KeyEvent.VK_DOWN);
        left = keys.get(KeyEvent.VK_LEFT) != null && keys.get(KeyEvent.VK_LEFT);
        right = keys.get(KeyEvent.VK_RIGHT) != null && keys.get(KeyEvent.VK_RIGHT);
        if(up){
            tempObj.setVelY(-speed);
        }
        if(down){
            tempObj.setVelY(speed);
        }
        if(right){
            tempObj.setVelX(speed);
        }
        if(left){
            tempObj.setVelX(-speed);
        }
    }

    private void playerOneRelease(GameObject tempObj) {
        int v;
        up = keys.get(KeyEvent.VK_W)!=null && keys.get(KeyEvent.VK_W);
        down = keys.get(KeyEvent.VK_S) != null && keys.get(KeyEvent.VK_S);
        left = keys.get(KeyEvent.VK_A) != null && keys.get(KeyEvent.VK_A);
        right = keys.get(KeyEvent.VK_D) != null && keys.get(KeyEvent.VK_D);

        if(up){
            System.out.println("Released up");
            tempObj.setVelY(0);
        }if(down){
            System.out.println("Released down");
            tempObj.setVelY(0);
        }if(left){
            System.out.println("Released left");
            tempObj.setVelX(0);
        }if(right){
            System.out.println("Released right");
            tempObj.setVelX(0);
        }
        }
//        switch(key){
//            case KeyEvent.VK_W:
//                up = false;
//                v = down ? speed : 0;
//                tempObj.setVelY(v);
//                break;
//            case KeyEvent.VK_S:
//                down = false;
//                v = up ? speed : 0;
//                tempObj.setVelY(v);
//                break;
//            case KeyEvent.VK_D:
//                right = false;
//                v = left ? -speed : 0;
//                tempObj.setVelX(v);
//                break;
//            case KeyEvent.VK_A:
//                left = false;
//                v = right ? speed : 0;
//                tempObj.setVelX(v);
//                break;
//        }
//    }

    private void playerTwoRelease(int key, GameObject tempObj) {
        int v;
        switch(key){
            case KeyEvent.VK_UP:
                up = false;
                v = down ? speed : 0;
                tempObj.setVelY(v);
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                v = up ? speed : 0;
                tempObj.setVelY(v);
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                v = left ? -speed : 0;
                tempObj.setVelX(v);
                break;
            case KeyEvent.VK_LEFT:
                left = false;
                v = right ? speed : 0;
                tempObj.setVelX(v);
                break;
            default:
                tempObj.setVelX(0);
                tempObj.setVelY(0);
                break;
        }
    }

}
