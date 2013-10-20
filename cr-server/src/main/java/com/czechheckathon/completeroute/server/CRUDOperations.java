package com.czechheckathon.completeroute.server;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.*;

/**
 * @author Michal Dojcar
 */
public class CRUDOperations {

    private static DBCollection collection;

    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient();
        DB courseDB = client.getDB(CompleteRouteServer.DATABASE_NAME);
        collection = courseDB.getCollection(RouteDAO.ROUTES_COLLECTION);

        CRUDOperations ops = new CRUDOperations();
        ops.dropCollection();
        ops.insertData();
    }

    private void dropCollection() {
        collection.drop();
    }

    private void insertData() {
        insertTelco();
        insertBanking();
        insertServices();
        insertInsurance();
        insertGovernment();
    }

    private void insertBanking() {
        BasicDBObject banking = new BasicDBObject("_id", "banking").append("name", "Bankovnictví").append("icon", "banking");
        banking.append("companies", Collections.emptyList());
        collection.insert(banking);
    }

    private void insertTelco() {
        BasicDBObject telecommunications = new BasicDBObject("_id", "telco").append("name", "Telekomunikace").append("icon", "telco");

        BasicDBObject telefonica = new BasicDBObject("name", "O2").append("description", "Telefonica O2")
                .append("phone", "800184084").append("icon", "o2_logo");
        BasicDBObject routeTelefonica1 = new BasicDBObject("keypad", 1).append("description","Faktury, platby a poslední vyúčtování");
        BasicDBObject routeTelefonica11 = new BasicDBObject("keypad", 1).append("description","Faktury").append("routes", Collections.emptyList());
        BasicDBObject routeTelefonica12 = new BasicDBObject("keypad", 2).append("description","Platby").append("routes", Collections.emptyList());;
        BasicDBObject routeTelefonica13 = new BasicDBObject("keypad", 3).append("description","Poslední vyúčtování").append("routes", Collections.emptyList());;
        routeTelefonica1.append("routes", Arrays.asList(routeTelefonica11, routeTelefonica12, routeTelefonica13));
        BasicDBObject routeTelefonica2 = new BasicDBObject("keypad", 2).append("description","Nastavení stávajících služeb, a roaming");
        BasicDBObject routeTelefonica21 = new BasicDBObject("keypad", 1).append("description","Nastavení stávajících služeb").append("routes", Collections.emptyList());;
        BasicDBObject routeTelefonica22 = new BasicDBObject("keypad", 2).append("description","Informace").append("routes", Collections.emptyList());;
        BasicDBObject routeTelefonica23 = new BasicDBObject("keypad", 3).append("description","Roaming").append("routes", Collections.emptyList());;
        routeTelefonica2.append("routes", Arrays.asList(routeTelefonica21, routeTelefonica22, routeTelefonica23));
        BasicDBObject routeTelefonica3 = new BasicDBObject("keypad", 3).append("description","Aktivace tarifů a služeb");
        BasicDBObject routeTelefonica31 = new BasicDBObject("keypad", 1).append("description","Aktivace nového tarifu").append("routes", Collections.emptyList());;
        BasicDBObject routeTelefonica32 = new BasicDBObject("keypad", 2).append("description","Aktivace nové služby").append("routes", Collections.emptyList());;
        routeTelefonica3.append("routes", Arrays.asList(routeTelefonica31, routeTelefonica32));
        BasicDBObject routeTelefonica4 = new BasicDBObject("keypad", 4).append("description","Nahlášení poruchy").append("routes", Collections.emptyList());;
        BasicDBObject routeTelefonica5 = new BasicDBObject("keypad", 5).append("description","Výpověď služby").append("routes", Collections.emptyList());;
        telefonica.append("routes", Arrays.asList(routeTelefonica1, routeTelefonica2, routeTelefonica3, routeTelefonica4, routeTelefonica5));

        BasicDBObject centropol = new BasicDBObject("name", "Centropol").append("description", "Centropol - virtuální operátor")
                .append("phone", "906666666").append("icon", "centropol_logo");

        telecommunications.append("companies", Arrays.asList(telefonica, centropol));
        collection.insert(telecommunications);
    }

    private void insertServices() {
        BasicDBObject services = new BasicDBObject("_id", "services").append("name", "Služby").append("icon", "services");
        services.append("companies", Collections.emptyList());
        collection.insert(services);
    }

    private void insertInsurance() {
        BasicDBObject insurance = new BasicDBObject("_id", "insurance").append("name", "Pojištění").append("icon", "insurance");
        insurance.append("companies", Collections.emptyList());
        collection.insert(insurance);
    }

    private void insertGovernment() {
        BasicDBObject government = new BasicDBObject("_id", "government").append("name", "Státní správa").append("icon", "government");
        government.append("companies", Collections.emptyList());
        collection.insert(government);
    }
}
