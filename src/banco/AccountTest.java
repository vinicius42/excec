package banco;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class AccountTest {

	public static void main(String[] args) {	
		
		
		Account conta1 = new Account("Carlos", 50);
		Account conta2 = new Account("José", 0);
		
		Account.mostrarConta(conta1);
		Account.mostrarConta(conta2);
		System.out.println();
		
		conta1.deposito(50);
		conta2.deposito(200);
		System.out.println();
		
		Account.mostrarSaldoFinal(conta1);
		Account.mostrarSaldoFinal(conta2);
		
		JOptionPane.showMessageDialog(null, "Bem vindo");// Exibe mensagens de diálogo
	}

}
