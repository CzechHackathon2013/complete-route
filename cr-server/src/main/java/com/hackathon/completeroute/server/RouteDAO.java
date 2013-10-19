package com.hackathon.completeroute.server;

import com.mongodb.DB;
import com.mongodb.DBCollection;

/**
 * @author Michal Dojcar
 */
public class RouteDAO {

    private DBCollection routeCollection;

    public RouteDAO(DB routeDB) {
        routeCollection = routeDB.getCollection("routes");
    }
}
