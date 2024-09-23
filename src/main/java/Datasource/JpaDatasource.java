package datasource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
/**
 * Class for creating a connection to the MariaDB database
 */
public class JpaDatasource {
    private JpaDatasource() {
    }
    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    public static EntityManager getInstance() {
        if (em==null) {
            if (emf==null) {
                try {
                    emf = Persistence.createEntityManagerFactory("car_db");
                } catch (org.hibernate.service.spi.ServiceException e) {
                    return null;
                }

            }
            em = emf.createEntityManager();
        }
        return em;
    }
}