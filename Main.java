import javax.swing.*;

public class Main {
	public static int lvl=1;
	
	public static void main(String[] args) {
		makeLevel();
	}
	
	public static void makeLevel(){
		if(lvl<=3){
			GameMain.running = true;
			new Thread(new GameMain(lvl)).start();
		}
		else{
			JFrame end = new JFrame("Game Finished");
			JPanel endp = new JPanel();
			JLabel endl = new JLabel("YOU FINISHED THE GAME!");
			
			endp.setSize(200,300);
			endp.add(endl);
			end.add(endp);
			
			endl.setFont(endl.getFont().deriveFont(18.0f));
			
			end.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			end.setSize(300,200);
			end.setLocation(500, 250);
			end.setVisible(true);
		}
	}
}
