package cap4;

public class TesteAluno {

	public static void main(String[] args) {
		Aluno aluno1 = new Aluno("Carlos", 93.5);
		Aluno aluno2 = new Aluno("José", 70.5);
		
		Aluno.mostarMedia(aluno1);
		Aluno.mostarMedia(aluno2);

	}

}
