package Dao;
import jakarta.persistence.EntityManager;
import Entity.Driver;

public class DriverDao {

    public void persist(Driver driver) {
        EntityManager em = datasource.JpaDatasource.getInstance();
        if(em == null){
            return;
        }
        em.getTransaction().begin();
        em.persist(driver);
        em.getTransaction().commit();
    }

    public Driver update(Driver driver) {
        EntityManager em = datasource.JpaDatasource.getInstance();
        if(em == null){
            return null;
        }
        em.getTransaction().begin();
        em.merge(driver);
        em.getTransaction().commit();
        return driver;
    }

    public Driver find(int id) {
        EntityManager em = datasource.JpaDatasource.getInstance();
        if(em == null){
            return null;
        }
        return em.find(Driver.class,  id);
    }

    public void delete(int id) {
        EntityManager em = datasource.JpaDatasource.getInstance();
        if(em == null){
            return;
        }
        em.getTransaction().begin();
        Driver driver = em.find(Driver.class, id);
        if(driver != null){
            em.remove(driver);
        }
        em.getTransaction().commit();
    }

}
