package persitencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import av2.JPAUtil;
import entidade.Carro;

public class CarroDAO implements ICarroDAO{

	@Override
	public boolean criar(Carro carro) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		manager.persist(carro);
		tx.commit();
		manager.close();
//		JPAUtil.close();		
		return false;
	}

	@Override
	public boolean recuperar(Carro carro) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
	//	JPAUtil.close();		
		return false;
	}

	@Override
	public boolean atualizar(Carro carro) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
		//JPAUtil.close();		
		return false;
	}

	@Override
	public boolean deletar(Carro carro) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
		//JPAUtil.close();		
		return false;
	}

}
