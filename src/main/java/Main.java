import api.model.Weather;
import api.retrofit.RetrofitConfig;
import dao.WeatherStatsDAO;
import database.DatabaseConnector;
import entities.WeatherStats;
import retrofit2.Call;
import retrofit2.Response;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Call<Weather> call = RetrofitConfig.getApi().getWeatherDataByCityName("Łódź", "metric", RetrofitConfig.API_KEY);
        Response<Weather> execute = null;
        try {
            execute = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(execute.body());


    }
}
