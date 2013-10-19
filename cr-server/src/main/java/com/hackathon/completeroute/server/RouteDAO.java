package com.hackathon.completeroute.server;

import com.mongodb.*;

/**
 * @author Michal Dojcar
 */
public class RouteDAO {

    //TODO

    public static final String ROUTES_COLLECTION = "routes";
    private DBCollection routeCollection;

    public RouteDAO(DB routeDB) {
        routeCollection = routeDB.getCollection(ROUTES_COLLECTION);
    }

    public String getCategories() {
        DBObject query = new BasicDBObject();
        DBObject projection = new BasicDBObject("_id", true);
        return executeFind(query, projection);
    }

    public String getCompanies(String company) {
        DBObject query = new BasicDBObject("_id", company);
        DBObject projection = new BasicDBObject("companies", true);
        return executeFind(query, projection);
    }

    private String executeFind(DBObject query, DBObject projection) {
        DBCursor cursor = routeCollection.find(query, projection);
        try {
            return buildResult(cursor);
        } finally {
            cursor.close();
        }
    }

    private String buildResult(DBCursor cursor) {
        if (!cursor.hasNext())
            return "{}";

        StringBuilder result = new StringBuilder("{result:[");
        while(cursor.hasNext()) {
            DBObject doc = cursor.next();
            result.append(doc).append(",");
        }
        result.deleteCharAt(result.length()-1).append("]}");
        return result.toString();
    }
}
