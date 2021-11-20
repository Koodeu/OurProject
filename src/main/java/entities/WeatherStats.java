package entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@Entity
@Table(name = "weatherstats")
public class WeatherStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name="time")
    private LocalTime time;

    @Column(name="current_temp")
    private double currentTemp;

    @Column(name ="min_temp")
    private double minTemp;

    @Column(name ="max_temp")
    private double maxTemp;

    @Column(name ="current_pressure")
    private double currentPressure;

    @Column(name ="humidity")
    private double humidity;

    @Column(name ="wind_speed")
    private double windSpeed;

    @Column(name ="wind_direction")
    private int windDirection;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

}
