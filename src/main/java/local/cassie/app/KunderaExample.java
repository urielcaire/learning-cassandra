package local.cassie.app;

import model.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;
import com.impetus.client.cassandra.common.CassandraConstants;
//import com.impetus.kundera.KunderaPersistence;

public class KunderaExample
{
    public static void main(String[] args)
    {
        User user = new User();
        user.setUserId("0001");
        user.setFirstName("Uriel");
        user.setLastName("Caire");
        user.setCity("Caraguatatuba");

        //enable CQL3
        Map<String, String> props = new HashMap<>();
        props.put(CassandraConstants.CQL_VERSION, CassandraConstants.CQL_VERSION_3_0);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cassandra_pu", props);
        EntityManager em = emf.createEntityManager();

        em.persist(user);
        em.close();    
        emf.close();
    }
}
