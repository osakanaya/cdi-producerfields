package producerfields.db;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class UserDatabaseEntityManager {
	@SuppressWarnings("unused")
	@Produces
	@UserDatabase
	@PersistenceContext
	private EntityManager em;
}
