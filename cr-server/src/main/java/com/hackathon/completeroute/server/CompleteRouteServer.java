package com.hackathon.completeroute.server;

import com.mongodb.*;
import spark.*;
import static spark.Spark.*;

import java.io.IOException;

/**
 * @author Michal Dojcar
 */
public class CompleteRouteServer {

    private RouteDAO routeDAO;

    public CompleteRouteServer(String mongoUri) throws IOException {
        MongoClient mongoClient = new MongoClient(new MongoClientURI(mongoUri));
        DB blogDatabase = mongoClient.getDB("completeroute");
        routeDAO = new RouteDAO(blogDatabase);

        setPort(8082);
        initializeRoutes();
    }

    private void initializeRoutes() throws IOException {

        get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                return "Complete-route server says hello!";
            }
        });

        get(new Route("/categories") {
            @Override
            public Object handle(Request request, Response response) {
                return "Categories... to be done";
            }
        });

        get(new Route("/companies/:category") {
            @Override
            public Object handle(Request request, Response response) {
                return "Companies of category " + request.params(":category") + "... to be done";
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
