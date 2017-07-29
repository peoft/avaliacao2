package persitencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import av2.JPAUtil;
import entidade.Aluguel;

public class AluguelDAO implements IAluguelDAO{

	@Override
	public boolean criar(Aluguel aluguel) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		manager.persist(aluguel);
		
		tx.commit();
		manager.close();
		return false;
	}

	@Override
	public boolean recuperar(Aluguel aluguel) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
		return false;
	}

	@Override
	public boolean atualizar(Aluguel aluguel) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
		return false;
	}

	@Override
	public boolean deletar(Aluguel aluguel) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
		return false;
	}

}
