package cap10_10_13;

public class ThreeDimensionalShape extends AbsShape{	
	public ThreeDimensionalShape(double a1, double a2, double a3) {
		super(a1, a2, a3);
	}
	@Override
	public double getArea() {
		return getA1() * getA2();
	}
	
	public double getVolume() {
		return getA1() * getA2() * getA3();
		
	}
	
	public String toString() {
		return String.format("3 dimensões área: ", getArea() + " e volume: ", getVolume());
	}

}
