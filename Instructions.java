import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instructions3 extends JFrame implements ActionListener {

	
	JButton button;
	
	
	
	public static void main (String[] args){	
		
		new Instructions3();
		
	}

	Instructions3() {
		JFrame frame = new JFrame("Instructions");
		frame.setSize(500,450);
		frame.setLocation(300,50);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		
		JPanel panel1 = new JPanel();
		panel1.setSize(500,100);
		panel1.setLocation(0,0);
		panel1.setBackground(Color.black);
		
		JPanel panel2 = new JPanel();
		panel2.setSize(500,250);
		panel2.setLocation(0,100);
		panel2.setBackground(Color.black);
		
		JPanel panel3 = new JPanel();
		panel3.setLocation(0,350);
		panel3.setSize(500,100);
		panel3.setBackground(Color.black);
		
		JPanel panel4 = new JPanel();
		panel4.setSize(500, 450);
		panel4.setBackground(Color.black);
		
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		frame.add(panel4);
		
		JLabel label = new JLabel("InStRuCtIoNs");
		label.setForeground(Color.white);
		
		
		
		button = new JButton("START");
		Font buttonfont = new Font("Courier New", Font.BOLD, 20);
		button.setFont(buttonfont);
		button.setBackground(Color.green);
		button.setForeground(Color.black);
		button.setPreferredSize(new Dimension(100, 30));
		button.addActionListener(this);
		panel1.add(label);
		panel3.add(button);
		
		JPanel panelbutton2 = new JPanel();
		frame.add(panelbutton2);
		panel3.setLocation(80,360);
		panel3.setSize(600, 200);
		panel3.setBackground(Color.black);

				
		JTextArea textarea = new JTextArea("The objective of the game is to get to the key which is located in the maze. " + 
		"The Key can be anywhere in the maze and you are to get it using the arrow keys." + "There will be obstacles such as " +
		"barriers and moving blocks that you can move to get to the key." + "There will also be broken blocks, and you can break " +
		"these broken blocks just by moving into it.");
		textarea.setLineWrap(true); 
		textarea.setSize(450,200);
		textarea.setBackground(Color.black);
		textarea.setForeground(Color.red);
		textarea.setEditable(false);
		panel2.add(textarea);
		
		
		frame.setVisible(true);
	}



@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource() == button) {
		Main.makeLevel();
		this.dispose();
	
	}
}
}
