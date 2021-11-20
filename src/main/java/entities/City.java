package entities;

import javax.persistence.*;

@Entity
Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="city_name")
    private String cityName;
}
