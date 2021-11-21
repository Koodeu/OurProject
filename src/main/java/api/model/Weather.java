package api.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {

    public Main main;
    public int id;
    public String name;
//    @SerializedName("weather")
//    public List<WeatherDetails> details;
    public Wind wind;

}
