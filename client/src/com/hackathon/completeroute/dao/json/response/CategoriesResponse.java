package com.hackathon.completeroute.dao.json.response;

import com.hackathon.completeroute.pojo.*;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Michal Dojcar
 */
public class CategoriesResponse {

    private CategoryResponse[] result;

    public List<Category> getResult() {
        List<Category> categories = new LinkedList<>();
        for (CategoryResponse c : result) {
            Category category = new Category(c._id, c.name, c.icon);
            category.setCompanies(getCompanies(c));
            categories.add(category);
        }
        return categories;
    }

    private List<Company> getCompanies(CategoryResponse c) {
        List<Company> companies = new LinkedList<>();
        if (c.companies != null)
            for (CategoryResponse.Companies cs : c.companies) {
                Company company = new Company(cs.name, cs.description, cs.phone, cs.icon);
                company.setRoutes(getRoutes(cs));
                companies.add(company);
            }
        return companies;
    }

    private List<Route> getRoutes(CategoryResponse.Companies cs) {
        List<Route> routes = new LinkedList<>();
        if (cs.routes != null)
            for (CategoryResponse.Companies.Routes rs : cs.routes) {
                Route route = new Route(Integer.parseInt(rs.keypad), rs.description);
                route.setRoutes(getSubRoutes(rs));
                routes.add(route);
            }
        return routes;
    }

    private List<Route> getSubRoutes(CategoryResponse.Companies.Routes rs) {
        List<Route> subRoutes = new LinkedList<>();
        if (rs.routes != null)
            for (CategoryResponse.Companies.Routes subRs : rs.routes) {
                Route subRoute = new Route(Integer.parseInt(subRs.keypad), subRs.description);
                subRoute.setRoutes(getSubRoutes(subRs));
                subRoutes.add(subRoute);
            }
        return subRoutes;
    }

    private CategoriesResponse(CategoryResponse[] result) {
        this.result = result;
    }

    private static class CategoryResponse {
        private String _id;
        private String name;
        private String icon;
        private Companies[] companies;

        private CategoryResponse(String _id, String name, String icon, Companies[] companies) {
            this._id = _id;
            this.name = name;
            this.icon = icon;
            this.companies = companies;
        }

        private static class Companies {
            private String name;
            private String description;
            private String phone;
            private String icon;
            private Routes[] routes;

            private Companies(String name, String description, String phone, String icon, Routes[] routes) {
                this.name = name;
                this.description = description;
                this.phone = phone;
                this.icon = icon;
                this.routes = routes;
            }

            private static class Routes {
                private String keypad;
                private String description;
                private Routes[] routes;

                private Routes(String keypad, String description, Routes[] routes) {
                    this.keypad = keypad;
                    this.description = description;
                    this.routes = routes;
                }
            }
        }
    }
}
