package persitencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import av2.JPAUtil;
import entidade.Acessorio;

public class AcessorioDAO implements IAcessorioDAO {

	@Override
	public boolean criar(Acessorio acessorio) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
		//JPAUtil.close();		
		return false;
	}

	@Override
	public boolean recuperar(Acessorio acessorio) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
		//JPAUtil.close();		

		return false;
	}

	@Override
	public boolean atualizar(Acessorio acessorio) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
		//JPAUtil.close();		
		return false;
	}

	@Override
	public boolean deletar(Acessorio acessorio) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
		//JPAUtil.close();		
		return false;
	}

}
