import java.awt.Color;
import java.util.Random;
import javax.swing.*;
import java.awt.*;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Emeka Okonkwo
 * @version 2017.10.22
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private Random rand = new Random();
    private Random randomPosition = new Random(400);

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }
    
    public void boxBounce()
    {
        int ground = 400;
        int ceiling = 50;
        
        // draws the rectangle box
        myCanvas.setVisible(true);
        myCanvas.drawLine(50, ground, 550, ground);
        myCanvas.drawLine(50, ceiling, 550, ceiling);
        myCanvas.drawLine(50, ceiling, 50, ground);
        myCanvas.drawLine(550, ceiling, 550, ground);
        
        // sets a random color

        int r = rand.nextInt(255) + 1;
        int g = rand.nextInt(255) + 1;
        int b = rand.nextInt(255) + 1;
        Color randomColor = new Color(r,g,b);
        
        // get the size of the canvas
        Dimension size = myCanvas.getSize();
        int positionX;
        int positionY;
        int randomX = size.width;
        int randomY = size.height;
        
        positionX = randomPosition.nextInt(randomX) + 1;
        positionY = randomPosition.nextInt(randomY) + 1;

        BoxBall ball = new BoxBall(positionX, positionY, 25, randomColor, 50, 550, ground, ceiling, myCanvas);
        ball.draw();

        BoxBall ball2 = new BoxBall(positionX, positionY, 25, randomColor, 50, 550, ground, ceiling, myCanvas);
        ball2.draw();
        
        BoxBall ball3 = new BoxBall(positionX, positionY, 25, randomColor, 50, 550, ground, ceiling, myCanvas);
        ball3.draw();
        
        BoxBall ball4 = new BoxBall(positionX, positionY, 25, randomColor, 50, 550, ground, ceiling, myCanvas);
        ball4.draw();
        
        BoxBall ball5 = new BoxBall(positionX, positionY, 25, randomColor, 50, 550, ground, ceiling, myCanvas);
        ball5.draw();
        
            while(true)
            {
                myCanvas.wait(10);
                ball.move();
                ball2.move();
                ball3.move();
                ball4.move();
                ball5.move();
            }
    }
}