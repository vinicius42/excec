package excecoes;

public class Teste {

	public static void main(String[] args) {
		Conta conta = new Conta(8021, "Bob", 150, 300);
		
		try {
			Conta.mostrarSaldoInicial(conta);
			conta.retirarDinheiro(200);
			Conta.mostrarSaldoFinal(conta);
		} 
		catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}

	}

}
