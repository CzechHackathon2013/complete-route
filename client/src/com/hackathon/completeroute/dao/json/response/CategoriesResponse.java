package com.hackathon.completeroute.dao.json.response;

import com.hackathon.completeroute.pojo.Category;

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
            categories.add(new Category(c._id, c._id, c.icon));
        }
        return categories;
    }

    private CategoriesResponse(CategoryResponse[] result) {
        this.result = result;
    }

    private static class CategoryResponse {
        private String _id;
        private String icon;

        private CategoryResponse(String _id, String icon) {
            this._id = _id;
            this.icon = icon;
        }
    }
}
