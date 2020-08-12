package banco;

public class Account {
	private String nome;
	private double saldo;

	public Account(String nome, double saldo){
		this.nome = nome;
		
		if(saldo > 0.0) {
			this.saldo = saldo;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getSaldo() {// Retorna o saldo da conta
		return saldo;
	}
	
	public void deposito(double depositoQuantidade) {
		if(depositoQuantidade > 0.0) { // Se o depósito for maior que zero add ao saldo
			saldo += depositoQuantidade; 
		}
		System.out.println("Depósito de: " + depositoQuantidade + " na conta do " + getNome());
	}
	
	public static void mostrarConta(Account conta) {
		System.out.println("Saldo inicial de " + conta.getSaldo() + " da conta do: " + conta.getNome());
	}
	
	public static void mostrarSaldoFinal(Account conta) {
		System.out.println("Saldo final da conta do " + conta.getNome() + ": "+ conta.getSaldo());
	}
	
	

}
