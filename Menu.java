import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends JFrame implements ActionListener {

	
	JButton button2;
	JButton button1;
	
	
	public static void main (String[] args){	
		
		new Menu();
		
	}
	
	 Menu() {
	
	JFrame frame = new JFrame("Main Menu");
	frame.setVisible(true);
	frame.setSize(600,500);
	frame.setLocation(400, 80);
	frame.setResizable(false);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	JPanel panellabel = new JPanel();
	frame.add(panellabel);
	panellabel.setLocation(0, 0);
	panellabel.setSize(600, 100);
	panellabel.setBackground(Color.black);
	
	
	JLabel label = new JLabel("ESCAPE DA MAZE YO");
	panellabel.add(label);
	label.setLocation(300,50);
	label.setForeground(Color.green);
	Font fontlabel = new Font("Agency FB", Font.BOLD, 40);
	label.setFont(fontlabel);
	
	
	
	
	JPanel panelbutton1 = new JPanel();
	frame.add(panelbutton1);
	panelbutton1.setLocation(0, 200);
	panelbutton1.setSize(600, 50);
	panelbutton1.setBackground(Color.black);
	
	button1 = new JButton("Play Game");
	button1.setPreferredSize(new Dimension(200, 50));
	button1.setBackground(Color.yellow);
	Font button1font = new Font("Courier New", Font.BOLD, 22);
	button1.setFont(button1font);
	panelbutton1.add(button1);
	button1.addActionListener(this);
	
	
	
	
	JPanel panelbutton2 = new JPanel();
	frame.add(panelbutton2);
	panelbutton2.setLocation(0, 310);
	panelbutton2.setSize(600, 200);
	panelbutton2.setBackground(Color.black);

	
	button2 = new JButton("Instructions");
	button2.setPreferredSize(new Dimension(200, 50));
	button2.setBackground(Color.cyan);
	Font button2font = new Font("Courier New", Font.BOLD, 20);
	button2.setFont(button2font);
	panelbutton2.add(button2);
	button2.addActionListener(this);
	
	JPanel panel = new JPanel();
	frame.add(panel);
	panel.setBackground(Color.black);
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button2) {
			new Instructions3();
			this.dispose();
		}
		if (e.getSource() == button1) {
			Main.makeLevel();
			this.dispose();
		}
		}
	}
