package teste;

import java.math.BigDecimal;

import av2.EntityManagerFactoryWrapper;
import entidade.Acessorio;
import entidade.Carro;
import entidade.CarroId;
import entidade.Fabricante;
import entidade.ModeloCarro;
import entidade.ModeloCarroId;
import enums.Categoria;
import persitencia.AcessorioDAO;
import persitencia.CarroDAO;
import persitencia.FabricanteDAO;
import persitencia.ModeloCarroDAO;

public class ValidarCarro {
	public static void main(String[] args) {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			Fabricante fabricante = new Fabricante();
			fabricante.setNome("GM");
			fabricanteDAO.criar(fabricante);

			ModeloCarroDAO modeloCarroDAO = new ModeloCarroDAO();

			ModeloCarro modeloCarro = new ModeloCarro();
			ModeloCarroId modeloCarroId = new ModeloCarroId();
			modeloCarro.setCategoria(Categoria.ESPORTIVO);
			modeloCarroId.setFabricanteId(fabricante.getId());
			modeloCarroId.setDescricao("HATCHBACK2");
			
			modeloCarro.setId(modeloCarroId);
			modeloCarro.setFabricante(fabricante);
			modeloCarroDAO.criar(modeloCarro);

			AcessorioDAO acessorioDAO = new AcessorioDAO();
			Acessorio acessorio = new Acessorio();
			acessorio.setDescricao("ar condicionado");
			acessorioDAO.criar(acessorio);

			CarroDAO carroDAO = new CarroDAO();
			Carro carro = new Carro();
			CarroId carroId = new CarroId();
			carroId.setChassi("9G3C3DFDSFDSFSDF323");
			carroId.setPlaca("MKL 3230");
			carro.setModeloCarro(modeloCarro);
			carro.setCor("pRETO");
			carro.setValorDiaria(new BigDecimal(25300));
			carro.setAcessorioId(acessorio.getId());
			carro.setCarroId(carroId);
			carroDAO.criar(carro);
			EntityManagerFactoryWrapper.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
