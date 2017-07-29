package persitencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import av2.JPAUtil;
import entidade.ApoliceSeguro;

public class ApoliceSeguroDAO implements IApoliceSeguroDAO {

	@Override
	public boolean criar(ApoliceSeguro apoliceSeguro) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		manager.persist(apoliceSeguro);
		
		tx.commit();
		manager.close();
		return false;
	}

	@Override
	public boolean recuperar(ApoliceSeguro apoliceSeguro) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
		return false;
	}

	@Override
	public boolean atualizar(ApoliceSeguro apoliceSeguro) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
		return false;
	}

	@Override
	public boolean deletar(ApoliceSeguro apoliceSeguro) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
		return false;
	}

}
