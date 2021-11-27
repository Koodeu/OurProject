package dao;

import database.DatabaseConnector;
import entities.City;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.xml.crypto.Data;
import java.util.List;

public class CityDAO {

    public Integer getCityIdByCityName(String cityName){
        EntityManager entityManager = DatabaseConnector.getInstance().getConnection();
      TypedQuery<Integer> query = entityManager.createQuery("select c.id from City c where c.cityName=:cityName", Integer.class);
        query.setParameter("cityName", cityName);
       Integer result = query.getSingleResult();
        return result;
    }

    public City getCityByCityName(String cityName){
        EntityManager entityManager = DatabaseConnector.getInstance().getConnection();
        TypedQuery<City> query = entityManager.createQuery("select c from City c where c.cityName=:cityName", City.class);
        query.setParameter("cityName", cityName);
        City result = null;
        try {
            result = query.getSingleResult();
        return result;
        } catch (Exception e) {
            return null;
        }
    }


    public boolean isCityInDatabase(String cityName){
        EntityManager entityManager = DatabaseConnector.getInstance().getConnection();
        TypedQuery<City> query = entityManager.createQuery("select c from City c where c.cityName=:cityName", City.class);
        query.setParameter("cityName", cityName);
        List<City> citiesList = query.getResultList();
        if(citiesList.isEmpty()){
            return false;
        }
        return true;
    }



}
