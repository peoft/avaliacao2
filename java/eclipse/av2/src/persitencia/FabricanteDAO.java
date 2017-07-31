package persitencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import av2.EntityManagerFactoryWrapper;
import entidade.Fabricante;

public class FabricanteDAO implements IFabricanteDAO {

	@Override
	public boolean criar(Fabricante fabricante) {
		boolean ret = true;
		EntityManager manager = null;
		EntityTransaction tx = null;
		try {
			manager = EntityManagerFactoryWrapper.getEntityManager();
			tx = manager.getTransaction();
			tx.begin();
			manager.persist(fabricante);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (manager != null)
				manager.close();
		}
		return ret;
	}

	@Override
	public boolean recuperar(Fabricante fabricante) {
		boolean ret = true;
		EntityManager manager = null;
		EntityTransaction tx = null;
		try {
			manager = EntityManagerFactoryWrapper.getEntityManager();
			tx = manager.getTransaction();
			tx.begin();
			
			Query query = manager.createQuery("select f from Fabricante f where lower(f.nome) = lower(:nome))");
			query.setParameter("nome", fabricante.getNome());
			Fabricante result = (Fabricante) query.getSingleResult();
			if (result == null)
				ret = false;
			else {
				fabricante.setId(result.getId());
			}

			tx.commit();
		} catch (NoResultException noResult) {
			ret = false;
		} catch (NonUniqueResultException NonUnique) {
			ret = false;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (manager != null)
				manager.close();
		}
		return ret;
	}

	@Override
	public boolean atualizar(Fabricante original, Fabricante modified) {
		boolean ret = true;
		EntityManager manager = null;
		EntityTransaction tx = null;
		try {
			manager = EntityManagerFactoryWrapper.getEntityManager();
			tx = manager.getTransaction();
			tx.begin();
			Fabricante valor = manager.find(original.getClass(), original.getId());
			valor.setNome(modified.getNome());
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (manager != null)
				manager.close();
		}

		return ret;
	}

	@Override
	public boolean deletar(Fabricante fabricante) {
		boolean ret = true;
		EntityManager manager = null;
		EntityTransaction tx = null;
		try {
			manager = EntityManagerFactoryWrapper.getEntityManager();
			tx = manager.getTransaction();
			tx.begin();
			Fabricante result = manager.find(fabricante.getClass(), fabricante.getId());
			manager.remove(result);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (manager != null)
				manager.close();
		}
		return ret;
	}

}
