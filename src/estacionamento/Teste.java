package estacionamento;

public class Teste {

	public static void main(String[] args) {
		Estacionamento estac1 = new Estacionamento("Carlos");
		estac1.calculateCharges(estac1, 2);
		
		Estacionamento estac2 = new Estacionamento("José");
		estac2.calculateCharges(estac2, 23);
		
		Estacionamento estac3 = new Estacionamento("José");
		estac3.calculateCharges(estac3, 15);

	}

}
