package api.model;

import lombok.Data;

@Data

public class WeatherDetails {
    public String id;
    public String main;
    public String description;
    public String icon;
}
