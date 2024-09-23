import Dao.CarDao;
import Dao.DriverDao;
import Entity.Car;
import Entity.Driver;

public class Main {
    public static void main(String[] args) {
        Driver driver1 = new Driver("Aapo", 99);
        Driver driver2 = new Driver("Jorma", 1);
        Car car1 = new Car("Toyota", driver1);
        Car car2 = new Car("BMW", driver2);
        DriverDao driverDao = new DriverDao();
        CarDao carDao = new CarDao();
        driverDao.persist(driver1);
        driverDao.persist(driver2);
        carDao.persist(car1);
        carDao.persist(car2);

        driver1.setCar(car1);
        driver2.setCar(car2);
        driverDao.update(driver1);
        driverDao.update(driver2);

       System.out.println(driver1.getCar().getModel());
       System.out.println(car1.getDriver().getName());
    }
}
