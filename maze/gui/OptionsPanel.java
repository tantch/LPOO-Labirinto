package maze.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import maze.logic.*;

public class OptionsPanel extends JPanel {
	private MyFrame fram;
	private JComboBox comboWidth;
	private JComboBox comboHeight;
	private JComboBox comboDragons;
	private JComboBox comboDif;
	private JButton voltar;
	private JButton upB;
	private JButton downB;
	private JButton rightB;
	private JButton leftB;
	private JButton eagleB;
	JLabel lblup,lbldown,lblleft,lblright,lbleagle; 

	public OptionsPanel(final MyFrame fr) {
		
		this.fram=fr;
		setLayout(null);
		setFocusable(true);
		setDoubleBuffered(true);
		setBackground(Color.LIGHT_GRAY);

		comboWidth = new JComboBox<>();
		comboWidth.setModel(new DefaultComboBoxModel(new String[] { "10", "11",
				"12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
				"22", "23", "24", "25", "26", "27", "28", "29", "30" }));
		comboWidth.setBounds(400, 103, 67, 33);
		add(comboWidth);
		JLabel lblWidth = new JLabel("Width");
		lblWidth.setBounds(330, 100, 100, 40);
		add(lblWidth);

		comboHeight = new JComboBox<>();
		comboHeight.setModel(new DefaultComboBoxModel(new String[] { "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
		comboHeight.setBounds(400, 153, 67, 33);
		add(comboHeight);
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setBounds(330, 156, 100, 20);
		add(lblHeight);

		comboDragons = new JComboBox<>();
		comboDragons.setModel(new DefaultComboBoxModel(new String[] { "1","2","3","4" }));
		comboDragons.setBounds(400, 203, 67, 33);
		add(comboDragons);
		JLabel lblDragons = new JLabel("Dragons");
		lblDragons.setBounds(330, 207, 100, 20);
		add(lblDragons);
		
		comboDif = new JComboBox<>();
		comboDif.setModel(new DefaultComboBoxModel(new String[] { "easy","medium","hard","very hard"}));
		comboDif.setBounds(400, 253, 67, 33);
		comboDif.setSelectedIndex(2);
		add(comboDif);
		JLabel lblDif = new JLabel("Dif");
		lblDif.setBounds(336, 255, 100, 20);
		add(lblDif);
		
		
		upB = new JButton("Up");
		upB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				InputFrame frame = new InputFrame(fram,0);
				frame.setVisible(true);
			}
		});
		upB.setSize(90,20);
		upB.setLocation(600,95);
		add(upB);
		lblup = new JLabel("up key");
		lblup.setSize(100,50);
		lblup.setLocation(700,80);
		add(lblup);
		
		downB = new JButton("Down");
		downB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				InputFrame frame = new InputFrame(fram,1);
				frame.setVisible(true);
			}
		});
		downB.setSize(90,20);
		downB.setLocation(600,125);
		add(downB);
		lbldown = new JLabel("down key");
		lbldown.setSize(100,50);
		lbldown.setLocation(700,110);
		add(lbldown);
		
		leftB = new JButton("Left");
		leftB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				InputFrame frame = new InputFrame(fram,2);
				frame.setVisible(true);
			}
		});
		leftB.setSize(90,20);
		leftB.setLocation(600,155);
		add(leftB);
		lblleft= new JLabel("left key");
		lblleft.setSize(100,50);
		lblleft.setLocation(700,140);
		add(lblleft);
		
		rightB = new JButton("Right");
		rightB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				InputFrame frame = new InputFrame(fram,3);
				frame.setVisible(true);
			}
		});
		rightB.setSize(90,20);
		rightB.setLocation(600,185);
		add(rightB);
		lblright= new JLabel("right key");
		lblright.setSize(100,50);
		lblright.setLocation(700,170);
		add(lblright);
		
		eagleB = new JButton("Eagle");
		eagleB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				InputFrame frame = new InputFrame(fram,4);
				frame.setVisible(true);
			}
		});
		eagleB.setSize(90,20);
		eagleB.setLocation(600,215);
		add(eagleB);
		lbleagle= new JLabel("f key");
		lbleagle.setSize(100,50);
		lbleagle.setLocation(700,200);
		add(lbleagle);
		
		
		
		
		
		voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index=comboWidth.getSelectedIndex();
				fram.opWidth=index+10;
				fram.gm.setWidth(index+10);
				
				index=comboHeight.getSelectedIndex();
				fram.opHeight=index+10;
				fram.gm.setHeight(index+10);
				
				index=comboDif.getSelectedIndex();
				fram.opDif=index;
			
				
				index=comboDragons.getSelectedIndex();
				fram.opNum=index+1;
				fram.gm.setDrnum(index +1);
				
				fram.toStart();
				
				
			}
		});
		voltar.setSize(100, 30);
		voltar.setLocation(630, 400);
		
		add(voltar);
		

	}
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(fram.startPanel.fundo, 0, 0, getWidth(), getHeight(), this);

	}

	public void start(){
		
		requestFocusInWindow();
		fram.setResizable(false);
		fram.setJMenuBar(null);
	}
}
