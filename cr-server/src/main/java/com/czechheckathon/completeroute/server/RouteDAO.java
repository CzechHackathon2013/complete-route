package com.czechheckathon.completeroute.server;

import com.mongodb.*;

import java.util.Iterator;

/**
 * @author Michal Dojcar
 */
public class RouteDAO {

    public static final String ROUTES_COLLECTION = "routes";
    private static final String EMPTY_RESPONSE = "{}";
    private DBCollection routeCollection;

    public RouteDAO(DB routeDB) {
        routeCollection = routeDB.getCollection(ROUTES_COLLECTION);
    }

    public String getCategories() {
        DBObject query = new BasicDBObject();
        DBObject projection = new BasicDBObject("_id", true).append("icon", true);
        return executeFind(query, projection);
    }

    public String getCompanies(String category) {
        DBObject query = new BasicDBObject("_id", category);
        DBObject projection = new BasicDBObject("_id", false).append("icon", false)
                .append("companies.routes", false);
        return executeFind(query, projection);
    }

    public String getRoutes(String category, String company, String... routesSelected) {
        DBObject query = new BasicDBObject("_id", category).append("companies.name", company);
        DBCursor cursor = routeCollection.find(query);
        try {
            if (!cursor.hasNext())
                return EMPTY_RESPONSE;
            return buildRoutesResult(company, cursor);
        } finally {
            cursor.close();
        }

    }

    private String executeFind(DBObject query, DBObject projection) {
        DBCursor cursor = routeCollection.find(query, projection);
        try {
            if (!cursor.hasNext())
                return EMPTY_RESPONSE;
            return buildResult(cursor);
        } finally {
            cursor.close();
        }
    }

    private String buildResult(DBCursor cursor) {
        StringBuilder result = new StringBuilder();
        while(cursor.hasNext()) {
            DBObject doc = cursor.next();
            result.append(doc).append(",");
        }
        result.deleteCharAt(result.length() - 1);
        return String.format("{result:[%s]}", result);
    }

    private String buildRoutesResult(String company, DBCursor cursor) {
        DBObject result = cursor.next();
        BasicDBList companies = (BasicDBList) result.get("companies");
        Iterator it = companies.iterator();
        while(it.hasNext()) {
            DBObject o = (DBObject) it.next();
            if (o.get("name").equals(company))
                return String.format("{result:%s}", o.get("routes"));
        }
        return EMPTY_RESPONSE;
    }
}
