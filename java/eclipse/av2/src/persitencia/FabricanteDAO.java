package persitencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import av2.EntityManagerFactoryWrapper;
import entidade.Fabricante;

public class FabricanteDAO implements IFabricanteDAO {

	@Override
	public boolean criar(Fabricante fabricante) {
		EntityManager manager = EntityManagerFactoryWrapper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		manager.persist(fabricante);
		tx.commit();
		manager.close();
		return false;
	}

	@Override
	public boolean recuperar(Fabricante fabricante) {
		EntityManager manager = EntityManagerFactoryWrapper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();
		return false;
	}

	@Override
	public boolean atualizar(Fabricante fabricante) {
		EntityManager manager = EntityManagerFactoryWrapper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
				
		tx.commit();
		manager.close();
		return false;
	}

	@Override
	public boolean deletar(Fabricante fabricante) {
		EntityManager manager = EntityManagerFactoryWrapper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		tx.commit();
		manager.close();		
		return false;
	}

}
