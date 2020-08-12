package estacionamento;


public class Estacionamento {
	private String nome;
	private double tarifa = 2;
	private int recibo;

	public Estacionamento(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
	
	public double getRecibo() {
		return recibo;
	}

	public double calculateCharges(Estacionamento cliente, int hora) {
		double total;
		if (hora >= 3 && hora <= 23) {
			total = tarifa + 0.5 * (hora - 3);
			recibo++;
		} 
		else if (hora == 24) {
			total = 10;
			recibo++;
		} 
		else {
			total = 2;
			recibo++;
		}
		System.out.println("O cliente " + cliente.getNome() + " ficou estacionado por " + hora + " horas.");
		System.out.println("O cliente " + cliente.getNome() + " vai pagar: " + total);
		System.out.println("Total de " + recibo + " recibo(s) até o momento");
		System.out.println();
		return total;
	}

}
