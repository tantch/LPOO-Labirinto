package maze.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class InputFrame extends JFrame {

	

	public InputFrame(final MyFrame frame,final int mode) {

		setTitle("Input Key");
		getContentPane().setLayout(null);
		setSize(200, 200);
		setResizable(false);
		JLabel lbl = new JLabel("Input Key");
		lbl.setBounds(50,50 , 70, 70);
		getContentPane().add(lbl);
		setLocationRelativeTo(null);
	

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch(mode){
				
				case 0: //up
					frame.boardPanel.upKey=e.getKeyCode();
					frame.optionsPanel.lblup.setText(KeyEvent.getKeyText(e.getKeyCode()) + " key");
					break;
				case 1: //down
					frame.boardPanel.downKey=e.getKeyCode();
					frame.optionsPanel.lbldown.setText(KeyEvent.getKeyText(e.getKeyCode()) + " key");
					break;
				case 2: //left
					frame.boardPanel.leftKey=e.getKeyCode();
					frame.optionsPanel.lblleft.setText(KeyEvent.getKeyText(e.getKeyCode()) + " key");
					break;
				case 3: //right
					frame.boardPanel.rightKey=e.getKeyCode();
					frame.optionsPanel.lblright.setText(KeyEvent.getKeyText(e.getKeyCode()) + " key");
					break;
				case 4: //eagle
					frame.boardPanel.eagleKey=e.getKeyCode();
					frame.optionsPanel.lbleagle.setText(KeyEvent.getKeyText(e.getKeyCode()) + " key");
					break;
				}
				
				dispose();
			}
		});
	}
}
