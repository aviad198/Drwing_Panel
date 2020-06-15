import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JPanel;
/*adds drawings to the panel and adds them to shapes list*/
public class PaintPanel extends JPanel{
	private MyShape shape;
	private ArrayList<MyShape> shapes = new ArrayList<MyShape>();
	private int x1, y1,x2,y2;
	int width;
	int height;

	
	public PaintPanel() {
		addMouseMotionListener(new MouseMotionAdapter() {
			
			//when mouse dragged initialize shape size 
			public void mouseDragged(MouseEvent e) {
				
				x2= e.getX();
				y2= e.getY();
				//width and height of shape (absolute value between points)
				width = (Math.abs(x2-x1));
				height = (Math.abs(y2-y1));
				if (shape instanceof MyBoundedShape) {
					//set first point as the smallest point
					shape.setX1(Math.min(x1,x2));
					shape.setY1(Math.min(y1,y2));	
					//set width and height
					shape.setX2(width);
					shape.setY2(height);}
				//if it isn't a bounded shape (line) set first and last point
				else {
					shape.setX2(x2);
					shape.setY2(y2);
				}
				repaint();
			}


		}
				);
		//when mouse is released add it to list of shapes 
		addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				try {//adds a cloned shape to the shapes list
					shapes.add((MyShape) shape.clone());
				} catch (CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				repaint();

			}
			//Initialize a new shape
			public void mousePressed(MouseEvent e) {
				x1 = e.getX();
				y1= e.getY();
				//if its bounded we don't want width and height at first
				if (shape instanceof MyBoundedShape) {
					x2=0;
					y2=0;
				}
				else {
					x2=x1;
					y2=y1;
				}
				shape.setX1(x1);
				shape.setY1(y1);
				
				shape.setX2(x2);
				shape.setY2(y2);
				repaint();

			}
		});
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//adds all shapes on list to panel
		for(MyShape shape :shapes) {
			shape.draw(g);
		}
		//draw current shape 
		shape.draw(g);
	}
	//gets shape to be drawn
	public void setShape(MyShape shape, Color myColor) {
		this.shape=shape;
		this.shape.setColor(myColor);
	}
	//remove last shape from list
	public void undo() {
		if (!shapes.isEmpty()) {
		shapes.remove(shapes.size()-1);
		repaint();}
	}
//clear list of shapes
	public void clear() {
		shapes.clear();
		repaint();
	}
}