

import java.awt.*;

public class MyOval extends MyBoundedShape {
	//constructor
	public MyOval() {
		
	}
	
	public MyOval(int x1, int x2, int y1, int y2) {
		super(x1, x2, y1, y2);
	}

	@Override
	//draw an oval, if getFill is true(shape should be fill) fill the oval
	public void draw(Graphics g) {
		g.setColor(getColor());
		
		
		if (getFill())
			g.fillOval(getX1(), getY1(), getX2(), getY2());
		else
			g.drawOval(getX1(), getY1(), getX2(), getY2());
	}


	@Override
	//if both are oval and have the same width and height returns true
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof MyOval && ((MyOval)obj).getX2()==this.getX2() && ((MyOval)obj).getY2()==this.getY2()&&((MyOval)obj).getColor()==this.getColor())
			return true;
		return false;		
	}






}
