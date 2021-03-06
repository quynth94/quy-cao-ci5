package Controllers.Enemy;

/**
 * Created by giaqu on 8/14/2016.
 */
public class FlyVerticalBehavior implements FlyBehavior {

    private static final int SPEED = 4;

    @Override
    public void doFly(EnemyController enemyController) {
        enemyController.getGameVector().dy = SPEED;
    }
}
