package dao;

import com.impetus.client.cassandra.common.CassandraConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAO<E>{
	
	protected EntityManager entityManager;

	public DAO(){
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager(){
		Map<String, String> props = new HashMap<>();
		props.put(CassandraConstants.CQL_VERSION, CassandraConstants.CQL_VERSION_3_0);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cassandra_pu", props);
		if(entityManager == null)
			entityManager = emf.createEntityManager();

		return entityManager;
	}

	public boolean persist(E object){
		boolean result = true;

		try{
			entityManager.persist(object);
		}catch(Exception e){
			System.out.println("DAO - Erro during persistence: "+e);
			result = false;
		}finally{
			entityManager.close();	
		}

		return result;
	}

	public abstract E getById(String id);

	public abstract boolean removeById(String id);

	public abstract List<E> getAll();

}
