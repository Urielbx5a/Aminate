import javax.swing.*;
import java.awt.*;
import java.util.Random;



//Feedback?
//
//
//
//
//
//
final public class Scene {
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JFrame frame;
    DrawPanel drawPanel;
    int offset = 0;
    boolean waveRight = true;
    final private double WAVESPEED = 1;
    final private int WAVEAMT = 20;

    private int oneX = 300; // Starting X coordinate
    private int oneY = 200; // Starting Y coordinate
    
    boolean up = false;
    boolean down = true;
    boolean left = false;
    boolean right = true;
    java.awt.Color Sky = (new Color(49,69,165));
    java.awt.Color Mid = (new Color(242, 99, 34));
    java.awt.Color MidB = (new Color(242, 99, 34,55));
    java.awt.Color Bot = (new Color(122, 45, 89));
    java.awt.Color Sun = (new Color(254, 200, 4));
    java.awt.Color SunSet = (new Color(255, 0, 128));
    java.awt.Color Star = (new Color(255, 200, 255));
    java.awt.Color Water = (new Color(24,27,100));
    java.awt.Color Waves = (new Color(49,69,165));
    Random rand = new Random();
    public static void main(String[] args) {
        new Scene().go();
    }

    private void go() {
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawPanel = new DrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(1265, 710);
        frame.setLocation((int) screenSize.getWidth()/25, (int) screenSize.getHeight()/26); //change to fit screens auto
        moveDot();
    }
    
    private void moveDot() {
        while(true){
            checkBounds();
            moveLoc();
            try{
                Thread.sleep(40);
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
    private void checkBounds(){
    	if(oneX >= 1000){
            right = false;
            left = true;
        }
        if(oneX <= 300){
            right = true;
            left = false;
        }
        if(oneY >=420){
            oneY = 200;
            oneX= 300;
        	up = true;
            down = false;
        }
        if(oneY <= 250){
            up = false;
            down = true;
        }	
    }
    class DrawPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -3030379568821478211L;
		
		public void paintComponent(Graphics g) {
			
			
			 //sky (49,69,165)
            g.setColor(Sky);
            g.fillRect(0, 0, this.getWidth(),190);
            if (oneY > 270 && oneY < 350) {//2
            	Sky = (new Color(35, 49, 118));
            }
            else if (oneY >= 350 && oneY < 487) {//3
        		Sky = (new Color (29, 41, 98));
        	}
            else {//start 1
            		Sky= (new Color (41, 57, 137));
            
            	}
          //stars
			g.setColor(Star);
			if (oneY >=0&& oneY <270) {
				for(int n = 0; n <= 1; n++) {
					int  x = rand.nextInt(1250) + 1;
					int  y = rand.nextInt(160) + 1;
					g.fillOval(x, y, 8,8);
				}
			}
			else if(oneY>=270 && oneY < 350) {
				for(int n = 0; n <= 3; n++) {
					int  x = rand.nextInt(1250) + 1;
					int  y = rand.nextInt(160) + 1;
					g.fillOval(x, y, 8,8);
				}
			}
			else {
					for(int n = 0; n <= 8; n++) {
						int  x = rand.nextInt(1250) + 1;
						int  y = rand.nextInt(160) + 1;
						g.fillOval(x, y, 8,8);
					
				}
			}
            
			//color persimmon (242, 99, 34)
            g.setColor(Mid);
            g.fillRect(0, 170,this.getWidth(), 200);
            if (oneY > 270 && oneY < 350) {//2
            	Mid = (new Color(241, 86, 14));
            }
            else if (oneY >= 350 && oneY < 487) {//3
        		Mid = (new Color (217, 77, 13));
        	}
            else {//start 1
        		Mid= (new Color (242,99,34));
        
        	}
            
            
            
            //color- merrigold
            //g.setColor(new Color(254, 200, 4));
            
            //color plum (new Color(122, 45, 89)
            g.setColor(Bot);
            g.fillRect(0, 310, this.getWidth(),480);
            if (oneY > 270 && oneY < 350) {//2
            	Bot = (new Color(112, 41, 81));
            }
            else if (oneY >= 350 && oneY < 487) {//3
        		Bot = (new Color (93, 34, 69));
        	}
            else {//start 1
            	Bot = (new Color (122,45,96));
            }
            //blend
            g.setColor(MidB);
            g.fillRect(0, 370,this.getWidth(), 30);
            if (oneY > 270 && oneY < 350) {//2
            	MidB = (new Color(241, 86, 14,55));
            }
            else if (oneY >= 350 && oneY < 487) {//3
        		MidB = (new Color (217, 77, 13,55));
        	}
            else {//start 1
        		MidB= (new Color (242,99,34,55));
        
        	} 
          //SunSet shades
            g.setColor(SunSet);
            g.fillRect(430, 460,280, 20);
            if (oneY > 270 && oneY < 350) {//2
            	SunSet = (new Color(230, 0, 115,100));
            }
            else if (oneY >= 350 && oneY < 487) {//3
        		SunSet = (new Color (204, 0, 102,100));
        	}
            else {//start 1
        		SunSet = (new Color (255, 0, 128,100));
            }
            
            g.setColor(SunSet);
            g.fillRect(460, 440,220, 20);
            if (oneY > 270 && oneY < 350) {//2
            	SunSet = (new Color(230, 0, 115,100));
            }
            else if (oneY >= 350 && oneY < 487) {//3
        		SunSet = (new Color (204, 0, 102,100));
        	}
            else {//start 1
        		SunSet = (new Color (255, 0, 128,100));
            }
            g.setColor(SunSet);
            g.fillRect(490, 420,160, 20);
            if (oneY > 270 && oneY < 350) {//2
            	SunSet = (new Color(230, 0, 115,100));
            }
            else if (oneY >= 350 && oneY < 487) {//3
        		SunSet = (new Color (204, 0, 102,100));
        	}
            else {//start 1
        		SunSet = (new Color (255, 0, 128,100));
            }
            // Sun (new Color(254, 200, 4)
            g.setColor(Sun);
            g.fillOval(oneX, oneY, 150, 150); 
            if (oneY > 270 && oneY < 350) {//2
            	Sun = (new Color(255, 221, 0));
            }
            else if (oneY >= 350 && oneY < 487) {//3
        		Sun = (new Color (255,218,30));
        	}
            else { //start1 
        		Sun= (new Color (255,224,30));
        
        	}
            
            //g.fillRect(oneX + 2, oneY - 2, 2, 10);
            //g.fillRect(oneX - 2, oneY + 2, 10, 2);
            
            
            //color indigo
            g.setColor(Water);
            g.fillRect(0, 480, this.getWidth(), this.getHeight());
            if (oneY > 270 && oneY < 350) {//2
            	Water = (new Color(20, 21, 82));
            }
            else if (oneY >= 350 && oneY < 487) {//3
        		Water = (new Color(15, 16, 62));
        	}
            else { //start1 
        		Water= (new Color (24,27,100));
        
        	}
            
            
            //offset
            if (waveRight) {
            	if (offset > WAVEAMT) {
            		waveRight = false;
            		offset -= WAVESPEED;
            	} else {
            		offset += WAVESPEED;
            	}
            } else {
            	if (offset < -WAVEAMT) {
            		waveRight = true;
            		offset += WAVESPEED;
            	}else {
            		offset -= WAVESPEED;
            	}
            }
            
            //arcs for water
            //fillArc(int xTopLeft, int yTopLeft, int width, int height, int startAngle, int arcAngle)
            for(int x = -40; x < 1300; x= x + 70) {
            	for(int y = 480; y <700 ; y= y+ 50) {
            		g.setColor(Waves);
            		g.fillArc(x + offset, y, 150, 100, 60, 60);
            	}
            }
            if (oneY > 270 && oneY < 350) {//2
            	Waves = (new Color(41, 57, 137));
            }
            else if (oneY >= 350 && oneY < 487) {//3
        		Waves = (new Color(35, 49, 118));
        	}
            else { //start1 
        		Waves= (new Color(49,69,165));
        
        	}
          //fillArc(int xTopLeft, int yTopLeft, int width, int height, int startAngle, int arcAngle)
            //birds 
            //g.setColor(new Color(255,255,255));
           // g.fillArc(800, 200, 50, 10, 130, 150);
           // g.fillArc(850, 200, 50, 30, 30, 50);
     
        }
    }

    

    
    

}