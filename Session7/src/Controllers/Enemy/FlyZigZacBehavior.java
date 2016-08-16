package Controllers.Enemy;

import Models.GameObject;
import Models.GameSetting;
import Models.GameVector;

/**
 * Created by giaqu on 8/14/2016.
 */
public class FlyZigZacBehavior implements FlyBehavior {



    private static final int SPEED = 5;
    private boolean startup = true;

    @Override
    public void doFly(EnemyController enemyController) {
        GameVector gameVector = enemyController.getGameVector();
        GameObject gameObject = enemyController.getGameObject();

        if(startup) {
            gameVector.dy = SPEED;
            gameVector.dx = SPEED;
            startup = false;
        } else {
            if(gameObject.getX() > GameSetting.getInstance().getScreenHeight()) {
                gameVector.dx = -SPEED;
            } else if(gameObject.getX() < 0){
                gameVector.dx = SPEED;
            }
        }

    }
}
