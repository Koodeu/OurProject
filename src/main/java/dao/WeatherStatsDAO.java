package dao;

import database.DatabaseConnector;
import entities.WeatherStats;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class WeatherStatsDAO {


    public List<WeatherStats> getWeatherStats(){

    EntityManager entityManager = DatabaseConnector.getInstance().getConnection();
        TypedQuery<WeatherStats> queryResult = entityManager.createQuery("select w from WeatherStats w", WeatherStats.class);
        List<WeatherStats> weatherStats = queryResult.getResultList();
        return weatherStats;

    }

    public List<WeatherStats> getWeatherStatsByCityName(String cityName){

        EntityManager entityManager = DatabaseConnector.getInstance().getConnection();
        TypedQuery<WeatherStats> queryResult = entityManager.createQuery("select w from WeatherStats w join City c" +
                " on w.city=c.id where c.cityName=:cityName " , WeatherStats.class);
        queryResult.setParameter("cityName", cityName);
        List<WeatherStats> weatherStats = queryResult.getResultList();
        return weatherStats;

    }


}
