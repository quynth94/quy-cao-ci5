package Views;

import Models.GameObject;
import Models.GameSetting;

import java.awt.*;
import java.util.Vector;

/**
 * Created by giaqu on 8/19/2016.
 */
public class AnimationDrawer implements GameDrawer {

    private Vector<Image> imageVector;
    private int imageIndex;
    private int timeCounter;
    private boolean detroyOnReachEnd;

    public AnimationDrawer(Vector<Image> imageVector, boolean detroyOnReachEnd) {
        this.imageVector = imageVector;
        this.imageIndex = 0;
        this.detroyOnReachEnd = detroyOnReachEnd;
    }

    public AnimationDrawer(Vector<Image> imageVector) {
        this(imageVector, false);
    }

    @Override
    public void draw(Graphics g, GameObject gameObject) {
        Image image = imageVector.get(imageIndex);
        /*Draw the image */
        g.drawImage(image,
                gameObject.getX(),
                gameObject.getY(),
                gameObject.getWidth(),
                gameObject.getHeight(), null);

        timeCounter++;
        if(GameSetting.getInstance().toMiliseconds(timeCounter) >= 100) {
            timeCounter = 0;
            imageIndex++;
            if(imageIndex >= imageVector.size()) {
                imageIndex = 0;
            }

            if(imageIndex == imageVector.size() - 1 && detroyOnReachEnd) {
                gameObject.destroy();
            }
        }
    }

    @Override
    public void run() {

    }
}
