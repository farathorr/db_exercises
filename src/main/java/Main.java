import Dao.CarDao;
import Dao.DriverDao;
import Entity.Car;
import Entity.Driver;

public class Main {
    public static void main(String[] args) {
        Driver driver1 = new Driver("Aapo", 99);
        Driver driver2 = new Driver("Jorma", 1);
        Car car1 = new Car("Toyota" );
        Car car2 = new Car("BMW");
        DriverDao driverDao = new DriverDao();
        CarDao carDao = new CarDao();
        driverDao.persist(driver1);
        driverDao.persist(driver2);
        carDao.persist(car1);
        carDao.persist(car2);

       // System.out.println(driver1.getCars());
    }
}
