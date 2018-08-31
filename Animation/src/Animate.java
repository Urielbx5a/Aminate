import javax.swing.*;
import java.awt.*;

final public class Animate {

    JFrame frame;
    DrawPanel drawPanel;

    private int oneX = 10; // Starting X coordinate
    private int oneY = 0; // Starting Y coordinate
    private int twoX = 10; // Starting X coordinate
    private int twoY = 0; // Starting Y coordinate
    
    boolean up = false;
    boolean down = true;
    boolean left = false;
    boolean right = true;
    
    boolean up1 = false;
    boolean down1 = true;
    boolean left1 = false;
    boolean right1 = true;

    public static void main(String[] args) {
        new Animate().go();
    }

    private void go() {
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawPanel = new DrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(1000, 1000);
        frame.setLocation(375, 300);
        moveDot();
        moveDot2();
    }

    class DrawPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -3030379568821478211L;
		
		public void paintComponent(Graphics g) {
        	//White Border
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            //Black Border
            g.setColor(Color.BLUE);
            g.fillRect(3, 3, this.getWidth()-6, this.getHeight()-6);
            //Inside Color
            g.setColor(Color.yellow);
            g.fillRect(6, 6, this.getWidth()-12, this.getHeight()-12);
            
            //Dot
            g.setColor(Color.RED);
            g.fillRect(oneX, oneY, 80, 30); // This is the dot
            //g.fillRect(oneX + 2, oneY - 2, 2, 10);
            //g.fillRect(oneX - 2, oneY + 2, 10, 2);
            g.setColor(Color.RED);
            g.fillRect(twoX,twoY, 80, 30);
        }
    }

    private void moveDot() {
        while(true){
            checkBounds();
            moveLoc();
            try{
                Thread.sleep(10);
            } catch (Exception exc){}
            frame.repaint();
        }
    }
    private void moveDot2() {
        while(true){
           checkBounds2();
            moveLoc2();
            try{
                Thread.sleep(10);
            } catch (Exception exc){}
            frame.repaint();
        }
    }

    private void moveLoc(){
    	if(up){
            oneY--;
        }
        if(down){
            oneY++;
        }
        if(left){
            oneX--;
        }
        if(right){
            oneX++;
        }	
    }
    private void moveLoc2(){
    	if(up1){
            twoY--;
        }
        if(down1){
            twoY++;
        }
        if(left1){
            twoX--;
        }
        if(right1){
            twoX++;
        }	
    }
    private void checkBounds(){
    	if(oneX >= 235){
            right = false;
            left = true;
        }
        if(oneX <= 200){
            right = true;
            left = false;
        }
        if(oneY >= 235){
            up = true;
            down = false;
        }
        if(oneY <= 200){
            up = false;
            down = true;
        }	
    }
    private void checkBounds2(){
    	if(twoX >= 235){
            right1 = false;
            left1 = true;
        }
        if(twoX <= 200){
            right1 = true;
            left1 = false;
        }
        if(twoY >= 235){
            up1 = true;
            down1 = false;
        }
        if(twoY <= 200){
            up1 = false;
            down1 = true;
        }	
    }
}