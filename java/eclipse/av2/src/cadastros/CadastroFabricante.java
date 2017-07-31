package cadastros;

import java.util.Scanner;

import entidade.Acessorio;
import entidade.Fabricante;
import persitencia.AcessorioDAO;
import persitencia.FabricanteDAO;

public class CadastroFabricante extends Cadastro {
	private Scanner ler;

	CadastroFabricante(String title) {
		super(title);
	}

	public static void main(String[] args) {
		Cadastro cadastroFabricante = new CadastroFabricante("Cadastro de Fabricantes");
		cadastroFabricante.leOpcoes();
		System.out.println("Saindo...");
	}

	@Override
	public void criar() {
		try {
			System.out.print("Nome:");			
			ler = new Scanner(System.in);
			String nome = ler.nextLine();
			
			if (nome != null) {
				FabricanteDAO fabricanteDAO = new FabricanteDAO();
				Fabricante fabricante = new Fabricante();
				fabricante.setNome(nome);
				if (fabricanteDAO.recuperar(fabricante) == false) {
					if (fabricanteDAO.criar(fabricante) == true) {
						System.out.println("Fabricante cadastrado com sucesso!");
					}
				} else {
					System.out.println("Fabricante já está cadastrado!");
				}
			}			
		} catch (Exception e) {
			System.out.println("Fabricante não foi criado (" + e.getMessage() + ")!");
		}
	}

	@Override
	public void recuperar() {
		try {
			System.out.print("Nome:");			
			ler = new Scanner(System.in);
			String nome = ler.nextLine();
			
			if (nome != null) {
				FabricanteDAO fabricanteDAO = new FabricanteDAO();
				Fabricante fabricante = new Fabricante();
				fabricante.setNome(nome);
				if (fabricanteDAO.recuperar(fabricante) == true) {
					System.out.println("Fabricante está cadastrado!");
				} else {
					System.out.println("Fabricante não está cadastrado!");
				}
			}			
		} catch (Exception e) {
			System.out.println("Fabricante não foi criado (" + e.getMessage() + ")!");
		}
	}

	@Override
	public void atualizar(boolean novoValor, Object original) {
		try {
			System.out.print("Nome:");			
			ler = new Scanner(System.in);
			String nome = ler.nextLine();
			
			if (nome != null) {
				FabricanteDAO fabricanteDAO = new FabricanteDAO();
				Fabricante fabricante = new Fabricante();
				fabricante.setNome(nome);
				boolean result = fabricanteDAO.recuperar(fabricante);
				if (novoValor == false) {
					if (result == true) {
						System.out.println("Fabricante está cadastrado! Digite novo valor!");
						atualizar(true, fabricante);
					} else {
						System.out.println("Fabricante não está cadastrado!");
					}
				} else {
					if (result == false) {
						if (fabricanteDAO.atualizar((Fabricante) original, fabricante) == true) {
							System.out.println("Fabricante atualizado com sucesso!");
						} else {
							System.out.println("Fabricante não foi atualizado!");
						}
					} else {
						System.out.println("Fabricante já existe!");
					}	
				}	
			}			
		} catch (Exception e) {
			System.out.println("Fabricante não foi criado (" + e.getMessage() + ")!");
		}
	}

	@Override
	public void deletar() {
		try {
			System.out.print("Nome:");			
			ler = new Scanner(System.in);
			String nome = ler.nextLine();
			
			if (nome != null) {
				FabricanteDAO fabricanteDAO = new FabricanteDAO();
				Fabricante fabricante = new Fabricante();
				fabricante.setNome(nome);
				if (fabricanteDAO.recuperar(fabricante) == true) {
					if (fabricanteDAO.deletar(fabricante) == true) {
						System.out.println("Fabricante removido com sucesso!");
					} else {
						System.out.println("Fabricante não foi removido!");
					}					
				} else {
					System.out.println("Fabricante não encontrado!");
				}
			}			
		} catch (Exception e) {
			System.out.println("Fabricante não foi removido (" + e.getMessage() + ")!");
		}
	}
}
