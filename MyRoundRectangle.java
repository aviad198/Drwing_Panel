import java.awt.Graphics;

public class MyRoundRectangle extends MyBoundedShape {
//constructor
	public MyRoundRectangle() {
		
	}
	public MyRoundRectangle(int x1, int x2, int y1, int y2) {
		super(x1, x2, y1, y2);
		// TODO Auto-generated constructor stub
	}

	@Override
	//draw Round Rectangle
	protected void draw(Graphics g) {
		g.setColor(getColor());
		
		if (getFill())
			g.fillRoundRect(getX1(), getY1(), getX2(), getY2(),15,15);
		else
			g.drawRoundRect(getX1(), getY1(), getX2(), getY2(),15,15);

	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MyRoundRectangle && ((MyRoundRectangle)obj).getX2()==this.getX2() && ((MyRoundRectangle)obj).getY2()==this.getY2()&&((MyRoundRectangle)obj).getColor()==this.getColor())
			return true;
		return false;
	}

}
