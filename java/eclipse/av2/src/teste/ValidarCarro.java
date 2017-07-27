package teste;

import java.math.BigDecimal;

import av2.Categoria;
import av2.JPAUtil;
import entidade.Carro;
import entidade.CarroId;
import entidade.Fabricante;
import entidade.ModeloCarro;
import entidade.ModeloCarroId;
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
			modeloCarroId.setFabricante(fabricante);
			modeloCarro.setFabricanteId(fabricante.getId());
			modeloCarroId.setDescricao("HATCHBACK");
			modeloCarro.setId(modeloCarroId);
			
			modeloCarroDAO.criar(modeloCarro);
			
			CarroDAO carroDAO = new CarroDAO();
			Carro carro = new Carro();
			CarroId carroId = new CarroId();		
			carroId.setChassi("9G3C3DFDSFDSFSDFDSF");
			carroId.setPlaca("IJL 0404");		
			carro.setModeloCarro(modeloCarro);
			carro.setId(carroId);
			carro.setCor("Prata");		
			carro.setValorDiaria(new BigDecimal(71300));			
			carroDAO.criar(carro);
			JPAUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
