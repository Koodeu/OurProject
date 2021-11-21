package api.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Wind {

    public double speed;
    @SerializedName("deg")
    public int direction;

}
