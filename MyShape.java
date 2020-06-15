

import java.awt.Graphics;
import java.awt.Color;
/*
 * Abstract Class to represent a Shape, implements cloneable
 */
public abstract class MyShape implements Cloneable {
	private int _x1,_x2,_y1,_y2;
	private Color _rgb;
	//constructor
	public MyShape() {
		
	}
	public MyShape(int x1,int x2, int y1, int y2) {
		this._x1=x1;
		this._x2=x2;
		this._y1=y1;
		this._y2=y2;
	}
//return x1
	public int getX1() {
		return _x1;
	}
	//return y2
	public int getY1() {
		return _y1;
	}
	//return x2
	public int getX2() {
		return _x2;
	}
	//return y2
	public int getY2() {
		return _y2;
	}
	public void setX1(int x1) {
		this._x1=x1;
	}
	public void setY1(int y1) {
		this._y1=y1;
	}
	public void setX2(int x2) {
		this._x2=x2;
	}
	public void setY2(int y2) {
		this._y2=y2;
	}
//abstract method to draw each shape
	protected abstract void draw(Graphics g);
	//returns shape color
	protected Color getColor() {
		return _rgb;
	}
	//sets shape color
	protected void setColor(Color rgb) {
		this._rgb = rgb;
	}
	//abstract method to check each shape if equal
	public abstract boolean equals(Object obj); 
	//clone method to clone shapes 
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}





}






