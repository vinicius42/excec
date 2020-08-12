package excecoes;

public class Conta {
	private int number;
	private String holder;
	private double saldo;
	private double limiteRetirarDinheiro;
	public Conta(int number, String holder, double saldo, double limiteRetirarDinheiro) {
		this.number = number;
		this.holder = holder;
		this.saldo = saldo;
		this.limiteRetirarDinheiro = limiteRetirarDinheiro;
	}
	public int getNumber() {
		return number;
	}
	public String getHolder() {
		return holder;
	}
	public double getSaldo() {
		return saldo;
	}
	public double getLimiteRetirarDinheiro() {
		return limiteRetirarDinheiro;
	}
	public void setLimiteRetirarDinheiro(double limiteRetirarDinheiro) {
		this.limiteRetirarDinheiro = limiteRetirarDinheiro;
	}
	
	public void deposito(double quantidadeDinheiro) {
		if(quantidadeDinheiro < 0.0) {
			throw new DomainException("Valor deve ser maior que 0");
		}
		saldo += quantidadeDinheiro;
	}
	
	public void retirarDinheiro(double quantidadeDinheiro) {
		if(quantidadeDinheiro > limiteRetirarDinheiro) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
		if(quantidadeDinheiro > saldo) {
			throw new DomainException("Not enough balance");
		}
		saldo -= quantidadeDinheiro;
		System.out.printf("Foi retirado da conta do %s: %s%n", getHolder(), quantidadeDinheiro);
	}
	
	public static void mostrarSaldoInicial(Conta conta) {
		System.out.printf("O saldo inicial da conta do %s é de: %s%n", conta.getHolder(), conta.getSaldo());
	}
	
	public static void mostrarSaldoFinal(Conta conta) {
		System.out.printf("O saldo final da conta do %s é de: %s", conta.getHolder(), conta.getSaldo());
	}
	
	

}
