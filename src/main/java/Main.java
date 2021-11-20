import dao.WeatherStatsDAO;
import database.DatabaseConnector;
import entities.WeatherStats;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    public static void main(String[] args) {



        WeatherStatsDAO weatherStatsDAO = new WeatherStatsDAO();
        List<WeatherStats> weather = weatherStatsDAO.getWeatherStatsByCityName("Pabianice");
        System.out.println(weather);
    }
}
