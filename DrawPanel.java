
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*main panel with all buttons and color to draw implements ActionListener and ChangeListener*/
public class DrawPanel extends JFrame implements ActionListener, ChangeListener{

	private PaintPanel paintP;
	private JPanel panel;
	private JButton  clearB, undoB ,exit;
	private JRadioButton lineB, ovalB, recB,roundRecB;
	private JCheckBox fill;
	private JColorChooser colorPan;
	//Initialize default color
	private Color myColor = Color.black;
	//Initialize default shape
	private MyShape shape = new MyLine();
	
/*Contractor builds the panels */
	public DrawPanel() {
		super("draw panel");
		
//Create new Components	
		//Buttons
		clearB =new JButton("clear"); 
		undoB =new JButton("undo"); 
		exit = new JButton("exit");
		
		//Listener
		
		clearB.addActionListener(this);
		undoB.addActionListener(this);
		exit.addActionListener(this);
		
		//fill checkbox
		fill = new JCheckBox("fill");
		fill.addActionListener(this);
		//Radio Buttons add too group for shapes to choose 
		lineB = new JRadioButton ("line",true);
		ovalB = new JRadioButton ("oval");
		recB = new JRadioButton ("rectangle");
		roundRecB = new JRadioButton ("rounded rectangel");
		
		ButtonGroup shapeG = new ButtonGroup();
		
		shapeG.add(lineB);
		shapeG.add(ovalB);
		shapeG.add(recB);
		shapeG.add(roundRecB);
		
		//listeners
		
		lineB.addActionListener(this);
		ovalB.addActionListener(this);
		recB.addActionListener(this);
		roundRecB.addActionListener(this);
		

		//panel for the components
		panel = new JPanel();
		
		//color chooser panel - leave only color panel
		colorPan = new JColorChooser();
		AbstractColorChooserPanel[] panels = colorPan.getChooserPanels();
		colorPan.getSelectionModel().addChangeListener(this);

		
		
		
		
		//add all to component panel
		panel.add(panels[0]);
		panel.add(lineB);
		panel.add(ovalB);
		panel.add(recB);
		panel.add(roundRecB);
		panel.add(clearB);
		panel.add(undoB);
		panel.add(fill);
		panel.add(exit);
		
		//paint panel 
		paintP = new PaintPanel();
		paintP.setBackground(Color.white);
		
		add(paintP,BorderLayout.CENTER);
		add(panel,BorderLayout.NORTH);
		setSize(1000, 500);
		setVisible(true);
		
		//Initialize first shape
		paintP.setShape(shape, myColor);
	}
	

//action performer
	@Override
	public void actionPerformed(ActionEvent e) {
//clear panel
		if(e.getSource()==clearB) {
			paintP.clear();
		}
//undo last shape
		if(e.getSource()==undoB) {
			paintP.undo();
		}
//exits Draw panel 	
		if(e.getSource()==exit) {
			dispose();
		}
//Initialize shape to line
		if(lineB.isSelected()) {
			shape = new MyLine();
		}
//Initialize shape to Oval
		else if(ovalB.isSelected()) {
			shape = new MyOval();
		}
//Initialize shape to Rectangle
		else if(recB.isSelected()) {
			shape = new MyRectangle();
		}
//Initialize shape to Round Rectangle		
		else if(roundRecB.isSelected()) {
			shape = new MyRoundRectangle();
		}
//if shape is instanceof MyBoundedShape (can be filled) fill if fill-box is checked
		if (shape instanceof MyBoundedShape) {
		if (fill.isSelected()) 
				((MyBoundedShape) shape).setFill(true);
		else 
			((MyBoundedShape) shape).setFill(false);
		}
	//sets new shape
		paintP.setShape(shape,myColor);
	}

	
	
/*
 * lets you draw shapes on a panels. you can switch between shapes, colors and fill or unfill them
 * 
 * 
 * */	
	
	public static void main (String args[]) {
		DrawPanel app = new DrawPanel();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	//if color is changes set new color
	public void stateChanged(ChangeEvent e) {
		myColor = colorPan.getColor();
		paintP.setShape(shape,myColor);
		
	}

	
	
}


