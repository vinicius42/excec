package companhiaAerea;

import java.util.Scanner;

public class Teste {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		boolean rodaPrograma = true;
		boolean[] assentos = new boolean[10]; // inicializa��o dos assentos

		do {
			textoMenuPrincipal(); // Apresenta��o
			int classe = leitor.nextInt();
			switch (classe) {
			case 1:
			case 2:
				assentos = reservaAssento(assentos, classe); // todo processo de reserva se d� nesse m�todo
				pressioneEnter();
				break;
			case 0:
				rodaPrograma = false;
				break;
			default:
				System.out.println("Op��o inv�lida.");
				break;
			}
		} while (rodaPrograma);
		// fim programa
	}

	// m�todo principal
	public static boolean[] reservaAssento(boolean[] assentos, int classe) {
		Scanner leitor = new Scanner(System.in);
		boolean continuarReserva = true;
		boolean reexibePoltronas = false; // caso troque de classe, reexiba as poltronas
		boolean ambosCheios = false; // usado para pausar o processo de reserva

		String classePrincipal = defineClassePrincipal(classe); // usados para exibir nomes corretos das classes
		String classeAlternativa = defineClasseAlternativa(classe);

		desenhaClasse(assentos, classe); // desenha os assentos na tela

		boolean isClasseLotada = checaCapacidade(assentos, classe); // a classe est� lotada?
		if (isClasseLotada) {
			System.out.println(classePrincipal + " lotada. Aceita ficar na " + classeAlternativa + "?");
			System.out.println("1. Sim");
			System.out.println("2. N�o");
			System.out.print("> ");
			int opcao = leitor.nextInt();
			switch (opcao) {
			case 1:
				classe = inverteClasse(classe);
				if (checaCapacidade(assentos, classe)) { // Verifica se a classe alternativa tamb�m est� lotada
					System.out.println("Todas as classes est�o lotadas. Lamentamos.");
					ambosCheios = true; // classe alternativa n�o possui vagas, interrompa o processo de Reserva
				} else {
					reexibePoltronas = true;
				}

				break;
			case 2:
				continuarReserva = false;
				System.out.println("O pr�ximo voo parte em 3 horas.");
				break;
			default:
				System.out.println("Op��o inv�lida");
				break;
			}
		}
		if (ambosCheios) {
			continuarReserva = false; // impede a continua��o da reserva se ambas classes estiverem cheias
		}
		if (reexibePoltronas == true && ambosCheios == false) {
			desenhaClasse(assentos, classe);
		}
		if (continuarReserva) {
			do {
				System.out.println("Escolha o n�mero da poltrona desejada:");
				System.out.print("> ");
				int poltrona = leitor.nextInt();
				poltrona--; // corrige a vari�vel para acesso correto nos indices do vetor

				if (acessoIndevido(classe, poltrona)) { // verifica se a poltrona existe na classe
					System.out.println("N�mero de poltrona inv�lido!");
				} else {
					if (assentoDisponivel(assentos, poltrona)) {
						assentos[poltrona] = true; // poltrona reservada!
						exibeCartaoDeEmbarque(assentos, poltrona, classe);
						break; // sai do DoWhile
					} else {
						System.out.println("Assento indispon�vel. Escolha outro.");
					}
				}

			} while (true); // la�o roda indefinidamente at� que que uma cadeira v�lida seja reservada
		}
		return assentos; // fim processo de reserva
	}

	// Verifica se a poltrona desejada existe na classe
	public static boolean acessoIndevido(int classe, int cadeiraEscolhida) {
		int classePrimeira[] = { 0, 1, 2, 3, 4 };
		int classeEconomica[] = { 5, 6, 7, 8, 9 };
		boolean acessoIndevido = true;

		if (classe == 1) { // verificar se a escolhida � valida
			for (int i = 0; i < classePrimeira.length; i++) {
				if (classePrimeira[i] == cadeiraEscolhida) {
					acessoIndevido = false;
				}
			}
		}

		if (classe == 2) { // verificar se a escolhida � valida
			for (int i = 0; i < classeEconomica.length; i++) {
				if (classeEconomica[i] == cadeiraEscolhida) {
					acessoIndevido = false;
				}
			}
		}
		return acessoIndevido;
	}

	// Exibe o texto do menu raiz
	public static void textoMenuPrincipal() {
		System.out.println("1. Primeira classe");
		System.out.println("2. Classe economica");
		System.out.println("0. Sair");
		System.out.print("> ");
	}

	// Desenha cart�o de embarque na tela
	public static void exibeCartaoDeEmbarque(boolean[] assentos, int poltrona, int classe) {
		String nomeClasse = defineClassePrincipal(classe);
		String classeAlternativa = defineClasseAlternativa(classe);
		System.out.println("***********************");
		System.out.println("  Cart�o de Embarque");
		System.out.println(nomeClasse);
		System.out.println("Poltrona N� " + (++poltrona));
		System.out.println("***********************");
	}

	// Desenha op��es de poltronas/assentos/cadeiras na tela
	public static void desenhaClasse(boolean[] assentos, int classe) {

		int inicioSetor = 0;
		int fimSetor = 5;
		if (classe == 2) {
			inicioSetor = 5;
			fimSetor = assentos.length;
		}

		for (int i = inicioSetor; i < fimSetor; i++) {
			if (i != fimSetor - 1) {
				System.out.print("[" + (i + 1) + "]" + " - ");
			} else {
				System.out.print("[" + (i + 1) + "]");
			}
		}
		System.out.println();

		for (int i = inicioSetor; i < fimSetor; i++) {
			String ocupado;
			if (assentos[i]) {
				ocupado = "X";
			} else {
				ocupado = " ";
			}
			if (i != fimSetor - 1) {
				System.out.print("|" + ocupado + "|" + " - ");
			} else {
				System.out.print("|" + ocupado + "|");
			}
		}
		System.out.println();
	}

	// Definem nomes apropriados para as classes
	public static String defineClassePrincipal(int classe) {
		if (classe == 1) {
			return "Primeira Classe";
		} else {
			return "Classe Econ�mica";
		}
	}

	public static String defineClasseAlternativa(int classe) {
		if (classe == 1) {
			return "Classe Econ�mica";
		} else {
			return "Primeira Classe";
		}
	}

	// Interrompe o fluxo do programa
	public static void pressioneEnter() {
		Scanner leitor = new Scanner(System.in);
		System.out.print("Pressione Enter para continuar...");
		leitor.nextLine();
	}

	// Verifica se a classe est� cheia
	public static boolean checaCapacidade(boolean[] assentos, int classe) {
		int inicioSetor = 0;
		int fimSetor = 5;
		if (classe == 2) {
			inicioSetor = 5;
			fimSetor = assentos.length;
		}
		boolean cheio = true; // por padr�o considera todos os assentos como ocupados
		for (int i = inicioSetor; i < fimSetor; i++) {
			if (!assentos[i]) // se algum assento estiver vazio [false], classe n�o est� cheia
			{
				cheio = false;
			}
		}
		return cheio;
	}

	// Verifica disponibilidade do assento
	public static boolean assentoDisponivel(boolean[] assentos, int numeroPoltrona) {
		if (assentos[numeroPoltrona]) {
			return false; // se a poltrona estiver ocupada, retorna falso = assento insdisponivel
		}
		return true;
	}

	// M�todo usado quando usu�rio troca de classe
	public static int inverteClasse(int classe) {
		if (classe == 1) {
			return 2;
		} else {
			return 1;
		}
	}
}
