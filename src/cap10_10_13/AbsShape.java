package cap10_10_13;

public abstract class AbsShape {
	private double a1;
	private double a2;
	private double a3;

	public AbsShape(double a1, double a2) {
		this.a1 = a1;
		this.a2 = a2;
	}
	public AbsShape(double a1, double a2, double a3) {
		this.a1 = a1;
		this.a2 = a2;
		this.a3 = a3;
	}
	
	public double getA1() {
		return a1;
	}
	
	public void setA1(double a1) {
		if(a1 < 0.0) {
			throw new IllegalArgumentException("Área 1 deve ser maior que 0");
		}
		this.a1 = a1;
	}
	
	public double getA2() {
		return a2;
	}
	
	public void setA2(double a2) {
		if(a2 < 0.0) {
			throw new IllegalArgumentException("Área 1 deve ser maior que 0");
		}
		this.a2 = a2;
	}

	public double getA3() {
		return a3;
	}

	public void setA3(double a3) {
		this.a3 = a3;
	}
	
	public abstract double getArea();

}
