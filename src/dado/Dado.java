package dado;

import java.security.SecureRandom;

public class Dado {
	private static final SecureRandom randomNumbers = new SecureRandom();
	private enum Status {CONTINUE, WON, LOST};
	private static final int SNAKE_EYES = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_LEVEN = 11;
	private static final int BOX_CARS = 12;

	public static void main(String[] args) {
		int meusPontos = 0;
		Status gameStatus;
		int somaDosDados = rolarDado();
		
		switch (somaDosDados) {
		case SEVEN:
		case YO_LEVEN:
			gameStatus = Status.WON;
			break;
		case SNAKE_EYES:
		case TREY:
		case BOX_CARS:
			gameStatus = Status.LOST;
			break;
		default:
			gameStatus = Status.CONTINUE;
			meusPontos = somaDosDados;
			System.out.println(meusPontos);
			break;
		}
		
		while(gameStatus == Status.CONTINUE) {
			somaDosDados = rolarDado();
			
			if(somaDosDados == meusPontos)
				gameStatus = Status.WON;
			else
				if(somaDosDados == SEVEN)
					gameStatus = Status.LOST;
		}
		
		if(gameStatus == Status.WON)
			System.out.println("Jogador ganhou");
		else
			System.out.println("Jogador perdeu");

	}
	
	public static int rolarDado() {
		int dado1 = 1 + randomNumbers.nextInt(6);
		int dado2 = 1 + randomNumbers.nextInt(6);
		
		int soma = dado1 + dado2;
		
		System.out.println("Jogador jogou o número " + dado1 + " + " + dado2 + " soma total de: " + soma);
		return soma;
	}

}
