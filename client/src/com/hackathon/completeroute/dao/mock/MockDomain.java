package com.hackathon.completeroute.dao.mock;

import com.hackathon.completeroute.pojo.*;
import java.util.*;

/**
 * @author Michal Dojcar
 */
public class MockDomain {

    private static MockDomain instance;
    private List<Category> categories;

    private MockDomain() {
        init();
    }

    private void init() {
        categories = new LinkedList<>();
        Category category = new Category("banking", "Banking", "banking");
        categories.add(category);

        category = new Category("telco", "Telco", "telco");
        Company company1 = new Company("O2", "Telefonica O2", "906112567", "o2_logo");
        company1.setCategory("telco");
        Route route1 = new Route(1,"Faktury, platby a poslední vyúčtování");
        Route route11 = new Route(1,"Faktury");
        Route route12 = new Route(2,"Platby");
        Route route13 = new Route(3,"Poslední vyúčtování");
        route1.setRoutes(Arrays.asList(route11, route12, route13));
        Route route2 = new Route(2,"Nastavení stávajících služeb, a roaming");
        Route route21 = new Route(1,"Nastavení stávajících služeb");
        Route route22 = new Route(2,"Informace");
        Route route23 = new Route(3,"Roaming");
        route2.setRoutes(Arrays.asList(route21, route22, route23));
        Route route3 = new Route(3,"Aktivace tarifů a služeb");
        Route route31 = new Route(1,"Aktivace nového tarifu");
        Route route32 = new Route(2,"Aktivace nové služby");
        route3.setRoutes(Arrays.asList(route31, route32));
        Route route4 = new Route(4,"Nahlášení poruchy");
        Route route5 = new Route(5,"Výpověď služby");
        company1.setRoutes(Arrays.asList(route1, route2, route3, route4, route5));
        Company company2 = new Company("Centropol", "Centropol - virtual operator", "906112567", "centropol_logo");
        company2.setCategory("telco");
        category.setCompanies(Arrays.asList(company1, company2));
        categories.add(category);

        category = new Category("services", "Services", "services");
        categories.add(category);

        category = new Category("insurance", "Insurance", "insurance");
        categories.add(category);

        category = new Category("government", "Government", "government");
        categories.add(category);
    }

    public List<Category> getCategories() {
        return categories;
    }

    public static MockDomain getInstance() {
        if (instance == null)
            instance = new MockDomain();
        return instance;
    }
}
