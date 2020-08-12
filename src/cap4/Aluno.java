package cap4;

public class Aluno {
	private String nome;
	private double media;
	
	public Aluno(String nome, double media) {
		this.nome = nome;
		
		if(media > 0.0) {
			if(media <= 100.00) {
				this.media = media;
			}
		}
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getMedia() {
		return media;
	}
	public void setMedia(double media) {
		if(media > 0) {
			if(media <= 100) {
				this.media = media;
			}
		}
	}
	
	public String getLetraNota() {
		String letraNota = "";
		
		if(media >= 90.0) {
			letraNota = "A";
		}
		else if (media >= 80.0) {
			letraNota = "B";
		}
		else if (media >= 70.0) {
			letraNota = "C";
		}
		else if (media >= 60.0) {
			letraNota = "D";
		}
		else{
			letraNota = "F";
		}
		return letraNota;
	}
	
	public static void mostarMedia(Aluno aluno) {
		System.out.println("O aluno " + aluno.getNome() + " teve média de " 
	+ aluno.getMedia() + " com a nota: " 
	+ aluno.getLetraNota());
	}
	
	

}
