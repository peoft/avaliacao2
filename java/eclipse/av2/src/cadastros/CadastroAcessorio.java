package cadastros;

import java.util.Scanner;

import entidade.Acessorio;
import persitencia.AcessorioDAO;

public class CadastroAcessorio extends Cadastro {
	private Scanner ler;

	CadastroAcessorio(String title) {
		super(title);
	}

	public static void main(String[] args) {
		Cadastro cadastroAcessorio = new CadastroAcessorio("Cadastro de Acessorios");
		cadastroAcessorio.leOpcoes();
		System.out.println("Saindo...");
	}

	@Override
	public void criar() {
		try {
			System.out.print("Descrição:");			
			ler = new Scanner(System.in);
			String descricao = ler.nextLine();
			
			if (descricao != null) {
				AcessorioDAO acessorioDAO = new AcessorioDAO();
				Acessorio acessorio = new Acessorio();
				acessorio.setDescricao(descricao);
				if (acessorioDAO.recuperar(acessorio) == false) {
					if (acessorioDAO.criar(acessorio) == true) {
						System.out.println("Acessório cadastrado com sucesso!");
					}
				} else {
					System.out.println("Acessório já está cadastrado!");
				}
			}			
		} catch (Exception e) {
			System.out.println("Acessório não foi criado (" + e.getMessage() + ")!");
		}
	}

	@Override
	public void recuperar() {
		try {
			System.out.print("Descrição:");			
			ler = new Scanner(System.in);
			String descricao = ler.nextLine();
			
			if (descricao != null) {
				AcessorioDAO acessorioDAO = new AcessorioDAO();
				Acessorio acessorio = new Acessorio();
				acessorio.setDescricao(descricao);
				if (acessorioDAO.recuperar(acessorio) == true) {
					System.out.println("Acessório está cadastrado!");
				} else {
					System.out.println("Acessório não está cadastrado!");
				}
			}			
		} catch (Exception e) {
			System.out.println("Acessório não foi criado (" + e.getMessage() + ")!");
		}
	}

	@Override
	public void atualizar(boolean novoValor, Acessorio original) {
		try {
			System.out.print("Descrição:");			
			ler = new Scanner(System.in);
			String descricao = ler.nextLine();
			
			if (descricao != null) {
				AcessorioDAO acessorioDAO = new AcessorioDAO();
				Acessorio acessorio = new Acessorio();
				acessorio.setDescricao(descricao);
				boolean result = acessorioDAO.recuperar(acessorio);
				if (novoValor == false) {
					if (result == true) {
						System.out.println("Acessório está cadastrado! Digite novo valor!");
						atualizar(true, acessorio);
					} else {
						System.out.println("Acessório não está cadastrado!");
					}
				} else {
					if (result == false) {
						if (acessorioDAO.atualizar(original, acessorio) == true) {
							System.out.println("Acessório atualizado com sucesso!");
						} else {
							System.out.println("Acessório não foi atualizado!");
						}
					} else {
						System.out.println("Acessório já existe!");
					}	
				}	
			}			
		} catch (Exception e) {
			System.out.println("Acessório não foi criado (" + e.getMessage() + ")!");
		}
	}

	@Override
	public void deletar() {
		try {
			System.out.print("Descrição:");			
			ler = new Scanner(System.in);
			String descricao = ler.nextLine();
			
			if (descricao != null) {
				AcessorioDAO acessorioDAO = new AcessorioDAO();
				Acessorio acessorio = new Acessorio();
				acessorio.setDescricao(descricao);
				if (acessorioDAO.recuperar(acessorio) == true) {
					if (acessorioDAO.deletar(acessorio) == true) {
						System.out.println("Acessório removido com sucesso!");
					} else {
						System.out.println("Acessório não foi removido!");
					}					
				} else {
					System.out.println("Acessório não encontrado!");
				}
			}			
		} catch (Exception e) {
			System.out.println("Acessório não foi removido (" + e.getMessage() + ")!");
		}
	}
}
