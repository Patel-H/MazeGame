import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.event.*;
import javax.swing.*;

public class GameMain implements Runnable{

    JFrame frame;
    Canvas canvas;
    BufferStrategy bufferStrategy;
    
    int pY,pX;
    int oY, oX;
    int xst, yst;
    int obsanim=0;
    public static boolean running;
    public static boolean keyTaken = false;
    
	int map[][];
	Maze m;
    Dimension gamesize = new Dimension(1040,650);
    
    public GameMain(int lvl){
    	
    	setUp(lvl);
        frame = new JFrame("ESCAPE THE MAZE");
        frame.setLocation(150,10);
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setPreferredSize(gamesize);
        panel.setLayout(null);
        canvas = new Canvas();
        canvas.setBounds(0, 0, gamesize.width + 10, gamesize.height +10);
        canvas.setIgnoreRepaint(true);
        panel.add(canvas);
        canvas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                moveIt(evt);
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        
    }
    
    public void setUp(int lvl){
    	m = new Maze(lvl);
     	map = m.getMap();
     	for(int x = 0; x <=20; x++){
         	for(int y = 0; y <=12; y++){
         		if(map[y][x]==9){
         			pY = y;
         			pX = x;
         			map[y][x]=0;
         		}else if(map[y][x]==5){
         			oY = y;
         			oX = x;
         			map[y][x]=0;
         		}
         	}
         }
    }
    
    public void run() {
        while (running == true) {
            try {
            	Paint();
            	Move();
            	Check();
                Thread.sleep(2);
            } catch (InterruptedException e) {
            }
        }
    }
    
    private void Check() {
		if(keyTaken){
			running = false;
			keyTaken = false;
			Collision.setTaken(false);
			Main.lvl++;
			Main.makeLevel();
			frame.dispose();
		}
	}
    
    public void Move(){
    	
    	map = Collision.moveXY(map, pX, pY, xst, yst);
    	
    	pX = Collision.getX();
    	pY = Collision.getY();
    	
    	xst=0;
    	yst=0;
    	
    	keyTaken = Collision.getTaken();
    }
    public void Paint() {
    	try{
	        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
	        g.clearRect(0,0,1050,650);        
	        Paint(g);
	        bufferStrategy.show();
    	}catch(Exception e){
    		
    	}
    }
 
    protected void Paint(Graphics2D g) {
   	
    	m.paint(g,map);
    	
    	m.paintPlayer(g,pX,pY);
    }
        
    public void moveIt(KeyEvent evt){
     switch (evt.getKeyCode()) {
            case KeyEvent.VK_DOWN:
            	yst = 1;
            	xst = 0;
                break;
            case KeyEvent.VK_UP:
                yst = -1;
                xst = 0;
                break;
            case KeyEvent.VK_LEFT:
                yst = 0;
                xst = -1;
                break;
            case KeyEvent.VK_RIGHT:
            	yst = 0;
            	xst = 1;
                break;
            case KeyEvent.VK_SPACE:
            	Main.makeLevel();
            	frame.dispose();
            default:
            	yst = 0;
            	xst = 0;
            	
            	
        }
         //be
       
         
    }
}
