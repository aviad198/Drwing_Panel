

import java.awt.*;

public class MyLine extends MyShape{
//constructor
	public MyLine() {
		
	}
	
	public MyLine(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}

	@Override
	//draw line
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(getX1(), getY1(), getX2(), getY2());
		

	}
//return line length
	public double length() {
		return Math.hypot((getY2()-getY1()), (getX2()-getX1()));
	}

	@Override
	//returns true if both are lines with same length
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof MyLine && ((MyLine)obj).length()==this.length()&&((MyLine)obj).getColor()==this.getColor())
			return true;
		return false;		
	}


}
