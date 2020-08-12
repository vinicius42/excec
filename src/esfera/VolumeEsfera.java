package esfera;

public class VolumeEsfera {
	public static double volumeEsfera(double a, double b, double radius) {
		double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
		System.out.println("O volume da esfera é: " + volume);
		return volume;
	}

}
