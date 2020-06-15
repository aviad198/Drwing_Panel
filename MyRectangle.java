

import java.awt.Graphics;

public class MyRectangle extends MyBoundedShape {
	//constructor
	public MyRectangle() {
		
	}
	public MyRectangle(int x1, int x2, int y1, int y2) {
		super(x1, x2, y1, y2);
	}

	@Override
	//draw a Rectangle, if getFill is true(shape should be fill) fill the Rectangle
	public void draw(Graphics g) {
		g.setColor(getColor());
		if (getFill())
			g.fillRect(getX1(), getY1(), getX2(), getY2());
		else
			g.drawRect(getX1(), getY1(), getX2(), getY2());
	}


	@Override
	//if both are Rectangle and have the same width and height returns true
	public boolean equals(Object obj) {
			if (obj instanceof MyRectangle && ((MyRectangle)obj).getX2()==this.getX2() && ((MyRectangle)obj).getY2()==this.getY2()&&((MyRectangle)obj).getColor()==this.getColor())
				return true;
			return false;
	}
}
