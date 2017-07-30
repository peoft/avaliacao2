package cadastros;

import java.util.Scanner;

public abstract class Cadastro implements CadastroOpcoes {
	private String title;
	public Cadastro(String title) {
		this.title = title;
	}
	public void showOptions() {
		System.out.println(title);
		System.out.println("1 - CRIAR");
		System.out.println("2 - RECUPERAR");
		System.out.println("3 - ATUALIZAR");
		System.out.println("4 - DELETAR");
		System.out.println("5 - SAIR");
		System.out.println();
	}
	
	protected void leOpcoes() {
		int opcao = 0;
		Scanner ler = null;
		do {
			try {
				opcao = 0;
				ler = new Scanner(System.in);
	
				showOptions();
				System.out.print("Digite uma das opções:");
				String digito = ler.nextLine();			
				opcao = Integer.parseInt(digito);
					
				switch (opcao) {
					case 1 : 
						criar();
					break;
					case 2 : 
						recuperar();
					break;
					case 3: 
						atualizar(false, null);
					break;
					case 4: 
						deletar();				
					break;
					case 0:
					case 5:
					break;
					default:
						System.out.println("Opcao inválida!");
					break;
				}			
			} catch (Exception e) {
				System.out.println("Ocorreu a seguinte exceção : "+ e.getMessage());
			}
		} while (opcao != 5);
		System.out.println();
		if (ler != null)
			ler.close();
	}
	
}
