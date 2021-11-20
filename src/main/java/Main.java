import database.DatabaseConnector;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManager entityManager = DatabaseConnector.getInstance().getConnection();

    }
}
