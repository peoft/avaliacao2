package persitencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import av2.JPAUtil;
import entidade.ModeloCarro;

public class ModeloCarroDAO implements IModeloCarroDAO {

	@Override
	public boolean criar(ModeloCarro modeloCarro) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		manager.persist(modeloCarro);
		tx.commit();
		manager.close();
		//JPAUtil.close();		
		return false;
	}

	@Override
	public boolean recuperar(ModeloCarro modeloCarro) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
		//JPAUtil.close();		
		return false;
	}

	@Override
	public boolean atualizar(ModeloCarro modeloCarro) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
		//JPAUtil.close();		
		return false;
	}

	@Override
	public boolean deletar(ModeloCarro modeloCarro) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
		//JPAUtil.close();		
		return false;
	}

}
