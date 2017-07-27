package persitencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import av2.JPAUtil;
import entidade.ApoliceSeguro;

public class ApoliceSeguroDAO implements IApoliceSeguroDAO {

	@Override
	public boolean criar(ApoliceSeguro aluguel) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
		//JPAUtil.close();		
		return false;
	}

	@Override
	public boolean recuperar(ApoliceSeguro aluguel) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
		//JPAUtil.close();		
		return false;
	}

	@Override
	public boolean atualizar(ApoliceSeguro aluguel) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
		//JPAUtil.close();		
		return false;
	}

	@Override
	public boolean deletar(ApoliceSeguro aluguel) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
		//JPAUtil.close();		
		return false;
	}

}
