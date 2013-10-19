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

        BasicDBObject csob = new BasicDBObject("name", "ČSOB").append("description", "Česká obchodní banka")
                .append("phone", "906112567").append("icon", "csob.png");
        BasicDBObject routeCsob1 = new BasicDBObject("keypad", 1).append("description","Main1");
        BasicDBObject routeCsob11 = new BasicDBObject("keypad", 1).append("description","Sub1");
        BasicDBObject routeCsob12 = new BasicDBObject("keypad", 2).append("description","Sub2");
        BasicDBObject routeCsob13 = new BasicDBObject("keypad", 3).append("description","Sub3");
        routeCsob1.append("routes", Arrays.asList(routeCsob11, routeCsob12, routeCsob13));
        BasicDBObject routeCsob2 = new BasicDBObject("keypad", 2).append("description","Main1");
        BasicDBObject routeCsob21 = new BasicDBObject("keypad", 1).append("description","Sub1");
        BasicDBObject routeCsob22 = new BasicDBObject("keypad", 2).append("description","Sub2");
        BasicDBObject routeCsob23 = new BasicDBObject("keypad", 3).append("description","Sub3");
        routeCsob2.append("routes", Arrays.asList(routeCsob21, routeCsob22, routeCsob23));
        csob.append("routes", Arrays.asList(routeCsob1, routeCsob2));

        BasicDBObject kb = new BasicDBObject("name", "Komerční banka").append("description", "Komerčka")
                .append("phone", "906111555").append("icon", "kb.png");
        BasicDBObject cs = new BasicDBObject("name", "Česká spořitelna").append("description", "Spořka")
                .append("phone", "906666666").append("icon", "cs.png");

        banking.append("companies", Arrays.asList(csob, kb, cs));
        collection.insert(banking);
    }

    private void insertTelco() {
        BasicDBObject telecommunications = new BasicDBObject("_id", "telco").append("name", "Telekomunikace").append("icon", "telco");

        BasicDBObject telefonica = new BasicDBObject("name", "Telefonica").append("description", "Bubliny")
                .append("phone", "800184084").append("icon", "telefonica.png");
        BasicDBObject routeTelefonica1 = new BasicDBObject("keypad", 1).append("description","Faktury, platby a poslední vyúčtování");
        BasicDBObject routeTelefonica11 = new BasicDBObject("keypad", 1).append("description","Faktury");
        BasicDBObject routeTelefonica12 = new BasicDBObject("keypad", 2).append("description","Platby");
        BasicDBObject routeTelefonica13 = new BasicDBObject("keypad", 3).append("description","Poslední vyúčtování");
        routeTelefonica1.append("routes", Arrays.asList(routeTelefonica11, routeTelefonica12, routeTelefonica13));
        BasicDBObject routeTelefonica2 = new BasicDBObject("keypad", 2).append("description","Nastavení stávajících služeb, a roaming");
        BasicDBObject routeTelefonica21 = new BasicDBObject("keypad", 1).append("description","Nastavení stávajících služeb");
        BasicDBObject routeTelefonica22 = new BasicDBObject("keypad", 2).append("description","Informace");
        BasicDBObject routeTelefonica23 = new BasicDBObject("keypad", 3).append("description","Roaming");
        routeTelefonica2.append("routes", Arrays.asList(routeTelefonica21, routeTelefonica22, routeTelefonica23));
        BasicDBObject routeTelefonica3 = new BasicDBObject("keypad", 3).append("description","Aktivace tarifů a služeb");
        BasicDBObject routeTelefonica31 = new BasicDBObject("keypad", 1).append("description","Aktivace nového tarifu");
        BasicDBObject routeTelefonica32 = new BasicDBObject("keypad", 2).append("description","Aktivace nové služby");
        routeTelefonica3.append("routes", Arrays.asList(routeTelefonica31, routeTelefonica32));
        BasicDBObject routeTelefonica4 = new BasicDBObject("keypad", 4).append("description","Nahlášení poruchy");
        BasicDBObject routeTelefonica5 = new BasicDBObject("keypad", 5).append("description","Výpověď služby");
        BasicDBObject routeTelefonica6 = new BasicDBObject("keypad", 6).append("description","Dobíjení kreditu, dotazy k  předplacené kartě");
        BasicDBObject routeTelefonica61 = new BasicDBObject("keypad", 1).append("description","Dobíjení kreditu");
        BasicDBObject routeTelefonica62 = new BasicDBObject("keypad", 2).append("description","Dotazy k  předplacené kartě");
        routeTelefonica6.append("routes", Arrays.asList(routeTelefonica61, routeTelefonica62));
        telefonica.append("routes", Arrays.asList(routeTelefonica1, routeTelefonica2
                , routeTelefonica3, routeTelefonica4, routeTelefonica5, routeTelefonica6));

        BasicDBObject tmobile = new BasicDBObject("name", "T-Mobile").append("description", "Růžováci")
                .append("phone", "906112567").append("icon", "tmobile.png");
        BasicDBObject routeTmobile1 = new BasicDBObject("keypad", 1).append("description","Main1");
        BasicDBObject routeTmobile11 = new BasicDBObject("keypad", 1).append("description","Sub1");
        BasicDBObject routeTmobile12 = new BasicDBObject("keypad", 2).append("description","Sub2");
        BasicDBObject routeTmobile13 = new BasicDBObject("keypad", 3).append("description","Sub3");
        routeTmobile1.append("routes", Arrays.asList(routeTmobile11, routeTmobile12, routeTmobile13));
        BasicDBObject routeTmobile2 = new BasicDBObject("keypad", 2).append("description","Main1");
        BasicDBObject routeTmobile21 = new BasicDBObject("keypad", 1).append("description","Sub1");
        BasicDBObject routeTmobile22 = new BasicDBObject("keypad", 2).append("description","Sub2");
        routeTmobile2.append("routes", Arrays.asList(routeTmobile21, routeTmobile22));
        tmobile.append("routes", Arrays.asList(routeTmobile1, routeTmobile2));

        BasicDBObject vodafone = new BasicDBObject("name", "Vodafone").append("description", "Červeňáci")
                .append("phone", "906111555").append("icon", "vodafone.png");
        BasicDBObject centropol = new BasicDBObject("name", "Centropol").append("description", "Virtuál")
                .append("phone", "906666666").append("icon", "centropol.png");

        telecommunications.append("companies", Arrays.asList(telefonica, tmobile, vodafone, centropol));
        collection.insert(telecommunications);
    }

    private void insertServices() {
        BasicDBObject services = new BasicDBObject("_id", "services").append("name", "Služby").append("icon", "services");
        collection.insert(services);
    }

    private void insertInsurance() {
        BasicDBObject insurance = new BasicDBObject("_id", "insurance").append("name", "Pojištění").append("icon", "insurance");
        collection.insert(insurance);
    }

    private void insertGovernment() {
        BasicDBObject government = new BasicDBObject("_id", "government").append("name", "Státní správa").append("icon", "government");
        collection.insert(government);
    }
}
