package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseConnector {

    private static DatabaseConnector instance;
    EntityManagerFactory entityManagerFactory;

    private DatabaseConnector(){
        entityManagerFactory = Persistence.createEntityManagerFactory("weather");

    }



    public static DatabaseConnector getInstance(){
        if(instance == null){
            instance = new DatabaseConnector();
        }
        return instance;
    }


    public EntityManager getConnection(){
        return entityManagerFactory.createEntityManager();
    }

}
