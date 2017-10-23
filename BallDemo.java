import java.awt.Color;
import java.util.Random;

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
        
        myCanvas.setVisible(true);
        /**
         * Draws a rectangle box
         */
        myCanvas.drawLine(50, ground, 550, ground);
        myCanvas.drawLine(50, ceiling, 550, ceiling);
        myCanvas.drawLine(50, ceiling, 50, ground);
        myCanvas.drawLine(550, ceiling, 550, ground);
        
        /**
         * Sets a random Color
         */
        int r = rand.nextInt(255) + 1;
        int g = rand.nextInt(255) + 1;
        int b = rand.nextInt(255) + 1;

        Color randomColor = new Color(r,g,b);


        BoxBall ball = new BoxBall(50, 100, 25, randomColor, 50, 550, ground, ceiling, myCanvas);
        ball.draw();
        
        BoxBall ball2 = new BoxBall(50, 100, 30, randomColor, 50, 550, ground, ceiling, myCanvas);
        ball2.draw();
        
        BoxBall ball3 = new BoxBall(50, 100, 35, randomColor, 50, 550, ground, ceiling, myCanvas);
        ball3.draw();
        
        BoxBall ball4 = new BoxBall(50, 100, 40, randomColor, 50, 550, ground, ceiling, myCanvas);
        ball4.draw();
        
        BoxBall ball5 = new BoxBall(50, 100, 15, randomColor, 50, 550, ground, ceiling, myCanvas);
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


    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
}