package teste;

import java.math.BigDecimal;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import av2.Categoria;
import av2.JPAUtil;
import entidade.Carro;
import entidade.CarroId;
import entidade.Fabricante;
import entidade.ModeloCarro;
import entidade.ModeloCarroId;

public class ValidarCarro {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		ModeloCarro modeloCarro = new ModeloCarro();
		ModeloCarroId modeloCarroId = new ModeloCarroId();
		modeloCarro.setCategoria(Categoria.ESPORTIVO);
	
				
		Fabricante fabricante = new Fabricante();
		fabricante.setNome("GM");
		
		manager.persist(fabricante);

		modeloCarroId.setFabricante(fabricante);
		modeloCarro.setFabricanteId(fabricante.getId());
		modeloCarroId.setDescricao("HATCHBACK");
		modeloCarro.setId(modeloCarroId);
		
		manager.persist(modeloCarro);
		
		// Carro
		Carro carro = new Carro();
		CarroId carroId = new CarroId();		
		carroId.setChassi("9G3C3DFDSFDSFSDFDSF");
		carroId.setPlaca("IJL 0404");		
		carro.setModeloCarro(modeloCarro);
		carro.setId(carroId);
		carro.setCor("Prata");		
		carro.setValorDiaria(new BigDecimal(71300));
		manager.persist(carro);
		tx.commit();
		manager.close();
		JPAUtil.close();
	}
}
