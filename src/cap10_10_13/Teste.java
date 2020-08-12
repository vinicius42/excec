package cap10_10_13;

public class Teste {

	public static void main(String[] args) {
		TwoDimensionalShape dimen2 = new TwoDimensionalShape(10, 10);
		ThreeDimensionalShape dimen3 = new ThreeDimensionalShape(5, 5, 5);

		AbsShape[] shape = new AbsShape[2];
		shape[0] = dimen3;
		shape[1] = dimen2;

		for (AbsShape absShape : shape) {
			if (absShape instanceof TwoDimensionalShape) 
			{
				System.out.println("2 dimensões área: " + dimen2.getArea());
				System.out.println(dimen2);
			} 
			else 
			{
				System.out.println("3 dimensões área: " + dimen3.getArea() + " e volume: " + dimen3.getVolume());
			}
		}
	}

}
