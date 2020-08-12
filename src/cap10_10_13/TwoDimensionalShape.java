package cap10_10_13;

public class TwoDimensionalShape extends AbsShape {

	public TwoDimensionalShape(double a1, double a2) {
		super(a1, a2);
	}

	@Override
	public double getArea() {
		return getA1() * getA2();
	}
	
	public String toString() {
		return String.format("2 dimensões área: ", getArea());
	}
	
	

}
