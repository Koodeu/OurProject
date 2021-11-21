package api.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Main {

    public double temp;
//    @SerializedName("feels_like")
//    public double feelsLike;
    public double humidity;
    @SerializedName("temp_min")
    public double minTemp;
    @SerializedName("temp_max")
    public double maxTemp;
    @SerializedName("pressure")
    public int currentPressure;

}

