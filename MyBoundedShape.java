
/*
 * Abstract class for BoundedShapes
 */
public abstract class MyBoundedShape extends MyShape {
	private boolean _isFill = false;
	//Constructor
	
	public MyBoundedShape() {
		
	}
	
	public MyBoundedShape(int x1, int x2, int y1, int y2) {
		super(x1, x2, y1, y2);
	}
	// method to get if shape fill or not.
	public boolean getFill() {
		return _isFill;
				}
	//sets shape to be fill or not
	public void setFill(boolean fill) {
		_isFill =fill;
	}
	
}
