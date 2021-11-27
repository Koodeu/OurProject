import api.model.Weather;
import api.retrofit.RetrofitConfig;
import dao.CityDAO;
import dao.WeatherStatsDAO;
import database.DatabaseConnector;
import dto.WeatherStatsDTO;
import entities.City;
import entities.WeatherStats;
import retrofit2.Call;
import retrofit2.Response;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Call<Weather> call = RetrofitConfig.getApi().getWeatherDataByCityName("Warszawa", "metric", RetrofitConfig.API_KEY);
        Response<Weather> execute = null;
        try {
            execute = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(execute.body());

        Weather weather = execute.body();
        CityDAO cityDAO = new CityDAO();

        City city = cityDAO.getCityByCityName(weather.name);
        if (city == null) {
            city = City.builder().cityName(weather.name).build();

            city = cityDAO.create(city); // dopisać metodę w CityDao która dopisuje city i zwraca
        }

        WeatherStats weathertats = WeatherStats.builder()
                .humidity(weather.getMain().getHumidity())
                .currentPressure(weather.getMain().getCurrentPressure())
                .maxTemp(weather.getMain().getMaxTemp())
                .minTemp(weather.getMain().getMinTemp())
                .currentTemp(weather.getMain().getTemp())
                .windSpeed(weather.getWind().speed)
                .windDirection(weather.getWind().direction)
                .city(city)
                .build();


        EntityManager entityManager = DatabaseConnector.getInstance().getConnection();
        entityManager.getTransaction().begin();
        entityManager.merge(weathertats);
        entityManager.getTransaction().commit();
        entityManager.close();


    }
}
