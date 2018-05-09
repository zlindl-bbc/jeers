package ch.bbc.uek223.openair.entitytest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;

public class EntityManagerTest {
	
    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jeersTest");
    protected EntityManager em;

    @Before
    public void before() throws Exception {
        em = emf.createEntityManager();
    }
    
    @After
    public void after() throws Exception {
        em.close();
    }
    
}
