package com.hackathon.completeroute.dao.json;

import com.hackathon.completeroute.pojo.Category;

import java.util.List;

/**
 * @author Michal Dojcar
 */
public class JsonDomain {

    private static JsonDomain instance;
    private List<Category> categories;

    private JsonDomain() {
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public static JsonDomain getInstance() {
        if (instance == null)
            instance = new JsonDomain();
        return instance;
    }
}
