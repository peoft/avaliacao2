package av2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryWrapper {
	private static EntityManagerFactory factory;
	static {
		factory = Persistence.createEntityManagerFactory("AluguelCarrosPU");
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

	public static void close() {
		if (factory != null) {
			factory.close();			
		}			
	}
}
