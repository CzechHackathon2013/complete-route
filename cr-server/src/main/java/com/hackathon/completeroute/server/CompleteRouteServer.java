package com.hackathon.completeroute.server;

import com.mongodb.*;
import spark.*;
import static spark.Spark.*;

import java.io.IOException;

/**
 * @author Michal Dojcar
 */
public class CompleteRouteServer {

    //TODO

    public static final String DATABASE_NAME = "completeroute";
    public static final String CONTEXT = "completeroute";

    private RouteDAO routeDAO;

    public CompleteRouteServer(String mongoUri) throws IOException {
        MongoClient mongoClient = new MongoClient(new MongoClientURI(mongoUri));
        DB blogDatabase = mongoClient.getDB(DATABASE_NAME);
        routeDAO = new RouteDAO(blogDatabase);

        setPort(8082);
        initializeRoutes();
    }

    private void initializeRoutes() throws IOException {

        get(new Route(CONTEXT + "/") {
            @Override
            public Object handle(Request request, Response response) {
                return "Complete-route server says hello!";
            }
        });

        get(new Route(CONTEXT + "/categories") {
            @Override
            public Object handle(Request request, Response response) {
                return routeDAO.getCategories();
            }
        });

        get(new Route(CONTEXT + "/companies/:category") {
            @Override
            public Object handle(Request request, Response response) {
                return routeDAO.getCompanies(request.params(":category"));
            }
        });
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0)
            new CompleteRouteServer("mongodb://localhost");
        else
            new CompleteRouteServer(args[0]);
    }
}
