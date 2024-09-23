package Dao;

import Entity.Car;
import jakarta.persistence.EntityManager;

public class CarDao {
    public void persist(Car car) {
        EntityManager em = datasource.JpaDatasource.getInstance();
        if(em == null){
            return;
        }
        car.getDriver().getCars().add(car);
        em.getTransaction().begin();
        em.persist(car);
        em.getTransaction().commit();
    }

    public Car update(Car car) {
        EntityManager em = datasource.JpaDatasource.getInstance();
        if(em == null){
            return null;
        }
        em.getTransaction().begin();
        em.merge(car);
        em.getTransaction().commit();
        return car;
    }

    public Car find(int id) {
        EntityManager em = datasource.JpaDatasource.getInstance();
        if(em == null){
            return null;
        }
        return em.find(Car.class,  id);
    }

    public void delete(int id) {
        EntityManager em = datasource.JpaDatasource.getInstance();
        if(em == null){
            return;
        }
        em.getTransaction().begin();
        Car car = em.find(Car.class, id);
        if(car != null){
            em.remove(car);
        }
        em.getTransaction().commit();
    }
}
