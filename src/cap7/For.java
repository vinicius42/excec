package cap7;

public class For {

	public static void main(String[] args) {
		final int ARRAY_SIZE = 10;
		double[] a = new double[ARRAY_SIZE];
		a[9] = 1.667;
		a[6] = 3.333;
		
		double soma = 0.0;
		double exibir = 0.0;
		for (int i = 0; i < a.length; i++) {
			soma += a[i];
			exibir = a[6];
		}
		System.out.println(soma);
		System.out.println(exibir);
		
		int[][] table = new int[ARRAY_SIZE][ARRAY_SIZE];
		
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++) {
				table[i][j] = i + j;
			}
		}
		
		int[] g = {8, 8, 8, 8, 8};
		double[] c = {5, 3, 4, 1};
		for (int i = 0; i < c.length; i++) {
			soma += c[i];
		}
		System.out.println("Elemento c: " + soma);
		
		
		

	}

}
