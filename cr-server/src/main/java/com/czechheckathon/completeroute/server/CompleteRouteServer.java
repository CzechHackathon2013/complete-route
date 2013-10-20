package com.czechheckathon.completeroute.server;

import com.mongodb.*;
import spark.*;
import static spark.Spark.*;

import java.io.IOException;

/**
 * @author Michal Dojcar
 */
public class CompleteRouteServer {

    private static final String DEFAULT_MONGO_URI = "mongodb://localhost";;
    public static final String DATABASE_NAME = "completeroute";
    public static final String CONTEXT = "completeroute";

    private RouteDAO routeDAO;

    public CompleteRouteServer(String mongoUri) throws IOException {
        MongoClient mongoClient = new MongoClient(new MongoClientURI(mongoUri));
        DB blogDatabase = mongoClient.getDB(DATABASE_NAME);
        routeDAO = new RouteDAO(blogDatabase);

        setPort(8082);
        initRoutes();
    }

    private void initRoutes() throws IOException {
        initWelcomeRoute();
        initCategoriesRoute();
        initCompaniesRoute();
        initNestedRoutes();
    }

    private void initWelcomeRoute() {
        get(new Route(CONTEXT + "/") {
            @Override
            public Object handle(Request request, Response response) {
                return "Complete-route server says hallo!";
            }
        });
    }

    private void initCategoriesRoute() {
        get(new Route(CONTEXT + "/categories") {
            @Override
            public Object handle(Request request, Response response) {
                return routeDAO.getCategories();
            }
        });
    }

    private void initCompaniesRoute() {
        get(new Route(CONTEXT + "/companies/:category") {
            @Override
            public Object handle(Request request, Response response) {
                return routeDAO.getCompanies(request.params(":category"));
            }
        });
    }

    private void initNestedRoutes() {
        get(new Route(CONTEXT + "/routes/:category/:company") {
            @Override
            public Object handle(Request request, Response response) {
                return routeDAO.getRoutes(request.params(":category"), request.params(":company"));
            }
        });
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            new CompleteRouteServer(DEFAULT_MONGO_URI);
        }
        else
            new CompleteRouteServer(args[0]);
    }
}
