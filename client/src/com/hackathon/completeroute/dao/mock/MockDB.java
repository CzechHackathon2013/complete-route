package com.hackathon.completeroute.dao.mock;

import com.hackathon.completeroute.pojo.*;
import java.util.*;

/**
 * @author Michal Dojcar
 */
public class MockDB {

    private static MockDB instance;
    private List<Category> categories;

    private MockDB() {
        init();
    }

    private void init() {
        categories = new LinkedList<>();
        Category category = new Category("banking", "Banking", "banking");
        categories.add(category);

        category = new Category("telco", "Telco", "telco");
        Company company1 = new Company("O2", "Telefonica O2", "906112567", "o2_logo");
        company1.setCategory("telco");
        //Route route1 = new Route(1, "")
        Company company2 = new Company("Centropol", "Centropol - vitrual operator", "906112567", "centropol_logo");
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

    public static MockDB getInstance() {
        if (instance == null)
            instance = new MockDB();
        return instance;
    }
}
