package dto;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
public class WeatherStatsDTO {

    private int id;
    private LocalDate date;
    private LocalTime time;
    private double currentTemp;
    private double minTemp;
    private double maxTemp;
    private double currentPressure;
    private double humidity;
    private double windSpeed;
    private int windDirection;
    private int cityId;

}
