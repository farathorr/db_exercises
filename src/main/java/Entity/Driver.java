package Entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int experience;


    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Car> cars = new ArrayList<>();

    public Driver() {
    }

    public Driver(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}